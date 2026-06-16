package org.artyomhack.service.rental.booking;

import org.artyomhack.dto.rental.booking.CreateRentalBookingRequest;

/**
 * Сервис по работе с бронированием объявлений по сдаче объектов в аренду.
 */
public interface RentalBookingService {

    /**
     * Метод, который создаёт бронирование на сдачу объекта в аренду.
     */
    void createBooking(CreateRentalBookingRequest booking);
}
