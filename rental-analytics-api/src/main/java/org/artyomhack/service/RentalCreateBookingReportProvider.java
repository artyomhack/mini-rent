package org.artyomhack.service;

import java.time.LocalDateTime;

/**
 * Сервис, который работает с отчётом по созданным броням объектов, сдавших в аренду.
 */
public interface RentalCreateBookingReportProvider {

     /**
      * Формируем документ отчёта по созданным броням объектов, сдавших в аренду.
      */
     byte[] generateReport(LocalDateTime from, LocalDateTime to, Long bookingId);
}
