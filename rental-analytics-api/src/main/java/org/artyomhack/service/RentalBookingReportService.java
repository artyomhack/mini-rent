package org.artyomhack.service;

import org.artyomhack.model.RentalCreateBookingReport;

/**
 * Сервис, который работает с отчётами бронирования на аренду вещей.
 */
public interface RentalBookingReportService {

    /**
     * Добавить новый отчёт по созданной брони.
     */
    void createBookingRentalReport(RentalCreateBookingReport report);
}
