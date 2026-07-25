package org.artyomhack.api;

import lombok.RequiredArgsConstructor;
import org.artyomhack.service.RentalCreateBookingReportProvider;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * API для работы с отчётами по сформированным броням по сдачи объектов в аренду.
 */
@RestController
@RequestMapping("/api/v1/rental-analytics/report/create-booking")
@RequiredArgsConstructor
public class RentalCreateBookingReportController {

    private final RentalCreateBookingReportProvider createBookingReportService;

    /**
     * Сформировать отчёт по созданным броням в пределах даты.
     */
    @GetMapping("/{bookingId}")
    public ResponseEntity<?> getReportRentalCreateBooking(@Param("from") LocalDateTime from,
                                                          @Param("to") LocalDateTime to,
                                                          @PathVariable("bookingId") String bookingId) {
        
    }
}
