package org.artyomhack.generator.impl;

import org.artyomhack.generator.PdfGenerator;
import org.artyomhack.model.RentalBookingReportFilter;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Objects;

/**
 * Реализация сервиса {@link PdfGenerator}.
 */
@Service
public class PdfGeneratorImpl implements PdfGenerator {

    private static final String TEMPLATE_DESCRIPTION =
            "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head><meta charset=\"UTF-8\"/></head>\n" +
            "<body>\n" +
            "   <h1>Отчёт о бронировании с %s по %s у объекта %s:%s</h1>\n" +
            "   <p>Кол-во созданных броней:%s</p>\n" +
            "</body>\n" +
            "</html>";

    @Override
    public byte[] generateReport(RentalBookingReportFilter reportFilter) {
        if (reportFilter.getRentalItemId() == null) {
            throw new IllegalArgumentException("Не удалось определить идентификатор объекта для аренды.");
        }

        LocalDateTime from = Objects.requireNonNullElse(reportFilter.getFrom(), LocalDateTime.now().minusMonths(1));
        LocalDateTime to = Objects.requireNonNullElse(reportFilter.getTo(), LocalDateTime.now());

        return new byte[0];
    }
}
