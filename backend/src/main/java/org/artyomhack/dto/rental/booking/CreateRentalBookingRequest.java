package org.artyomhack.dto.rental.booking;

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
    private Long rentalItemId;

    /**
     * Идентификатор пользователя, который хочет арендовать объект аренды.
     */
    private Long userRentId;

    /**
     * Дата начала аренды.
     */
    private LocalDateTime start;

    /**
     * Дата окончания аренды.
     */
    private LocalDateTime end;
}
