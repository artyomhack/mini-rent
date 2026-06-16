package org.artyomhack.common.exception;

/**
 * Класс, который представляет ошибку, когда произошла проблема с временем
 * или датой во время бронирования объекта для сдачи в аренду.
 */
public class RentalBookingDateTimeException extends RuntimeException {

    public RentalBookingDateTimeException(String message) {
        super(message);
    }

    public RentalBookingDateTimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
