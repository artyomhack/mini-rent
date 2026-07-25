package org.artyomhack.service.impl;

import lombok.RequiredArgsConstructor;
import org.artyomhack.service.RentalCreateBookingReportProvider;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Реализация сервиса {@link RentalCreateBookingReportProvider}.
 */
@Service
@RequiredArgsConstructor
public class RentalCreateBookingReportProviderImpl implements RentalCreateBookingReportProvider {

    @Override
    public byte[] generateReport(LocalDateTime from, LocalDateTime to, Long bookingId) {
        return new byte[0];
    }
}
