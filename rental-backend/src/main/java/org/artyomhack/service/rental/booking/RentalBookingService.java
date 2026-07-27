package org.artyomhack.service.rental.booking;

import org.artyomhack.dto.rental.booking.CreateRentalBookingRequest;
import org.artyomhack.model.RentalBookingCreateEvent;

/**
 * Сервис по работе с бронированием объявлений по сдаче объектов в аренду.
 */
public interface RentalBookingService {

    /**
     * Метод, который создаёт событие на бронирование сдачи объекта в аренду.
     */
    RentalBookingCreateEvent createBooking(CreateRentalBookingRequest booking);
}
