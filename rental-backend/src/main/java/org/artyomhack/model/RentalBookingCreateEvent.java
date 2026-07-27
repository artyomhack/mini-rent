package org.artyomhack.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.artyomhack.type.BookingStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Модель, которая представляет событие о созданной брони.
 */
@Data
public class RentalBookingCreateEvent {

    private Long bookingId;

    private Long rentalItemId;

    private Long ownerId;

    private Long renterId;

    private BookingStatus bookingStatus;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;

    private BigDecimal pricePerHour;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startAt;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime endAt;
}
