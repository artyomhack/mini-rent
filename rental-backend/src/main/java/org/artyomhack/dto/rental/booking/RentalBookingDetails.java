package org.artyomhack.dto.rental.booking;

import lombok.Data;

import java.util.List;

/**
 * Модель, которая представляет сведения о бронировании на объявление
 * о сдаче объекта в аренду.
 */
@Data
public class RentalBookingDetails {

    /**
     * Идентификатор бронирования
     */
    private Long rentalBookingId;

    /**
     * Идентификатор объекта бронирования(объявления).
     */
    private Long rentalItemId;

    /**
     * Идентификаторы пользователей, которые бронировали объявление
     */
    private List<RentalBookingState> bookingStates;
}
