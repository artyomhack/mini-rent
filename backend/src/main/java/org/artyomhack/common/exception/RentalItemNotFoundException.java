package org.artyomhack.common.exception;

/**
 * Класс, который представляет ошибку, когда не находить объект аренды.
 */
public class RentalItemNotFoundException extends RuntimeException{

    public RentalItemNotFoundException(String message) {
        super(message);
    }

    public RentalItemNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
