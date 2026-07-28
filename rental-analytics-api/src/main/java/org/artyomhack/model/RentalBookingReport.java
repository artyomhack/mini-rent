package org.artyomhack.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Итоговая модель для отчёта.
 */
@Data
@Builder
public class RentalBookingReport {
    private LocalDateTime from;

    private LocalDateTime to;

    private LocalDateTime bookingCreatedAt;

    private Long rentalItemId;
}
