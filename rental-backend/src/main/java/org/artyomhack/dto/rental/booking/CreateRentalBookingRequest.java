package org.artyomhack.dto.rental.booking;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Модель создания брони на объект аренды(объявления).
 */
@Data
public class CreateRentalBookingRequest {

    /**
     * Идентификатор объекта аренды(объявления)
     */
    @NotNull(message = "Идентификатор объекта аренды(объявления) обязателен!")
    private Long rentalItemId;

    /**
     * Идентификатор пользователя, который хочет арендовать объект аренды.
     */
    @NotNull(message = "Идентификатор пользователя, который хочет арендовать объект аренды обязателен!")
    private Long renterId;

    /**
     * Дата начала аренды.
     */
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @FutureOrPresent
    private LocalDateTime start;

    /**
     * Дата окончания аренды.
     */
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @FutureOrPresent
    private LocalDateTime end;
}
