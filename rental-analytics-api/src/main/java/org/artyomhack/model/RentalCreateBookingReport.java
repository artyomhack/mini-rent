package org.artyomhack.model;

import org.artyomhack.type.BookingStatus;

/**
 * Модель, которая представляем отчёт о создании брони на объект для сдачи в аренду.
 */
public class RentalCreateBookingReport {

    private Long bookingId;

    private BookingStatus status;
}
