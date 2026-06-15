package org.artyomhack.common.exception;

/**
 * Класс, который представляет ошибку: Пользователь не найден.
 */
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable e) {
        super(message, e);
    }
}
