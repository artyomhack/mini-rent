package org.artyomhack.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.artyomhack.entity.RentalBookingReportEntity;
import org.artyomhack.mapper.RentalBookingReportMapper;
import org.artyomhack.model.RentalCreateBookingReport;
import org.artyomhack.repository.RentalBookingReportRepository;
import org.artyomhack.service.RentalBookingReportService;
import org.springframework.stereotype.Service;

/**
 * Реализация сервиса {@link RentalBookingReportService}.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RentalBookingReportServiceImpl implements RentalBookingReportService {

    private final RentalBookingReportRepository rentalBookingRepository;

    private final RentalBookingReportMapper rentalBookingReportMapper;

    @Override
    public void createBookingRentalReport(RentalCreateBookingReport report) {
        RentalBookingReportEntity newEntity = rentalBookingReportMapper.toEntity(report);
        rentalBookingRepository.save(newEntity);

        log.info("Успешно сохранили отчёт о созданной брони: {} для вещи {}",
                newEntity.getBookingId(), newEntity.getRentalItemId());
    }
}
