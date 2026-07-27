package org.artyomhack.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * Модель, которая представляет данные отчёта о бронировании.
 */
@Data
public class RentalBookingReportFilter {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime from;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime to;

    private Long rentalItemId;
}
