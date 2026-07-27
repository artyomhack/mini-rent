package org.artyomhack.api;

import lombok.RequiredArgsConstructor;
import org.artyomhack.model.FileInfo;
import org.artyomhack.model.RentalBookingReportFilter;
import org.artyomhack.model.RentalCreateBookingReport;
import org.artyomhack.service.RentalBookingReportService;
import org.artyomhack.service.RentalCreateBookingReportProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API для работы с отчётами по сформированным броням по сдачи объектов в аренду.
 */
@RestController
@RequestMapping("/api/v1/rental-analytics/report/create-booking")
@RequiredArgsConstructor
public class RentalCreateBookingReportController {

    private final RentalCreateBookingReportProvider createBookingReportProvider;

    private final RentalBookingReportService rentalBookingReportService;

    /**
     * Сформировать отчёт по созданным броням в пределах даты.
     */
    @GetMapping
    public ResponseEntity<?> getReportRentalCreateBooking(RentalBookingReportFilter reportFilter) {
        FileInfo file = createBookingReportProvider.getReportByFilter(reportFilter);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"%s\""
                        .formatted(file.getFilename()))
                .body(file.getData());
    }

    //TODO: Синхронное взаимодействие.
    @PostMapping
    public ResponseEntity<Void> receiveEvent(@RequestBody RentalCreateBookingReport bookingReport) {
        rentalBookingReportService.createBookingRentalReport(bookingReport);
        return ResponseEntity.ok().build();
    }

//    @PostMapping
//    public ResponseEntity<Void> receiveEvent(@RequestBody RentalCreateBookingReport bookingReport) {
//        try {
//            Thread.sleep(5000);
//            rentalBookingReportService.createBookingRentalReport(bookingReport);
//            return ResponseEntity.ok().build();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
