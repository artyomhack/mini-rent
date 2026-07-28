package org.artyomhack.service.impl;

import lombok.RequiredArgsConstructor;
import org.artyomhack.entity.RentalBookingReportEntity;
import org.artyomhack.generator.PdfGenerator;
import org.artyomhack.model.FileInfo;
import org.artyomhack.model.RentalBookingReport;
import org.artyomhack.model.RentalBookingReportFilter;
import org.artyomhack.repository.RentalBookingReportRepository;
import org.artyomhack.service.RentalCreateBookingReportProvider;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Реализация сервиса {@link RentalCreateBookingReportProvider}.
 */
@Service
@RequiredArgsConstructor
public class RentalCreateBookingReportProviderImpl implements RentalCreateBookingReportProvider {

    private static String FILE_NAME = "booking_report_%s.pdf";

    private final PdfGenerator pdfGenerator;

    private final RentalBookingReportRepository reportRepository;

    @Override
    public FileInfo getReportByFilter(RentalBookingReportFilter reportFilter) {
        Long rentalItemId = reportFilter.getRentalItemId();
        Objects.requireNonNull(rentalItemId, "Не удалось определить идентификатор объекта для аренды.");

        LocalDateTime from = Objects.requireNonNullElse(reportFilter.getFrom(), LocalDateTime.now().minusMonths(1));
        LocalDateTime to = Objects.requireNonNullElse(reportFilter.getTo(), LocalDateTime.now());

        List<RentalBookingReport> bookingReports = reportRepository
                .findAllByRentalItemIdAndCreatedAtBetween(rentalItemId, from, to)
                .stream()
                .map(it -> RentalBookingReport.builder()
                        .from(from)
                        .to(to)
                        .bookingCreatedAt(it.getCreatedAt())
                        .rentalItemId(it.getRentalItemId())
                        .build())
                .toList();

        byte[] dataOfReport = pdfGenerator.generateReport(bookingReports);
        String filename = String.format(FILE_NAME, UUID.randomUUID());

        return new FileInfo(dataOfReport, filename);
    }
}
