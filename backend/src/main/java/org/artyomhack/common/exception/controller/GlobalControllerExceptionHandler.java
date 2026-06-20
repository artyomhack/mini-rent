package org.artyomhack.common.exception.controller;

import lombok.extern.slf4j.Slf4j;
import org.artyomhack.common.exception.RentalBookingDateTimeException;
import org.artyomhack.common.exception.RentalItemNotFoundException;
import org.artyomhack.common.exception.UserNotFoundException;
import org.artyomhack.common.exception.controller.dto.ErrorResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * Глобальный контроллер по обработке исключений.
 */
@Slf4j
@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    private static final String REASON_UNKNOWN_ERROR = "Возникла непредвиденная ошибка: Пожалуйста, обратитесь в тех. поддержку.";

    private static final String REASON_BAD_REQUEST = "Введённые данные некорректны.";

    private static final String REASON_PERIOD_INCORRECT = "Некорректный период времени при создании брони.";

    private static final String REASON_DATA_NOT_FOUND = "Данные не найдены.";

    /**
     * Обработка исключения {@link MethodArgumentNotValidException}.
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBadRequest(final MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        List<String> errors = new ArrayList<>();

        e.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .forEach(errors::add);

        ErrorResponse response = new ErrorResponse(e, HttpStatus.BAD_REQUEST, REASON_BAD_REQUEST);
        response.setErrors(errors);
        return response;
    }


    /**
     * Обработка исключения {@link HttpMessageNotReadableException}.
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBadRequest(final HttpMessageNotReadableException e) {
        log.error(e.getMessage(), e);
        return new ErrorResponse(e, HttpStatus.BAD_REQUEST, REASON_BAD_REQUEST);
    }

    /**
     * Обработка исключения {@link RentalBookingDateTimeException}.
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleRentalBookingDateTimeException(RentalBookingDateTimeException e) {
        log.error(e.getMessage(), e);
        return new ErrorResponse(e, HttpStatus.CONFLICT, REASON_PERIOD_INCORRECT);
    }

    /**
     * Обработка исключения {@link RentalItemNotFoundException}
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleRentalItemNotFoundException(RentalItemNotFoundException e) {
        log.error(e.getMessage(), e);
        return new ErrorResponse(e, HttpStatus.NOT_FOUND, REASON_DATA_NOT_FOUND);
    }

    /**
     * Обработка исключения {@link UserNotFoundException}
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleUserNotFoundException(UserNotFoundException e) {
        log.error(e.getMessage(), e);
        return new ErrorResponse(e, HttpStatus.NOT_FOUND, REASON_DATA_NOT_FOUND);
    }

    /**
     * Обработка исключения {@link Exception}.
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(Exception e) {
        log.error(e.getMessage(), e);
        return new ErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR, REASON_UNKNOWN_ERROR);
    }
}
