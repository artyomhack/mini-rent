package org.artyomhack.common.exception.controller;

import lombok.extern.slf4j.Slf4j;
import org.artyomhack.common.exception.RentalBookingDateTimeException;
import org.artyomhack.common.exception.controller.dto.ErrorResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
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

    /**
     * Обработка исключения {@link Exception}.
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(Exception e) {
        log.error(e.getMessage(), e);
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setReason(REASON_UNKNOWN_ERROR);
        errorResponse.setMessage(e.getLocalizedMessage());
        return errorResponse;
    }

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

        ErrorResponse response = new ErrorResponse();
        response.setCode(HttpStatus.BAD_REQUEST.value());
        response.setReason(REASON_BAD_REQUEST);
        response.setMessage(e.getLocalizedMessage());
        response.setErrors(errors);
        return response;
    }

    /**
     * Обработка исключения {@link org.artyomhack.common.exception.RentalBookingDateTimeException}.
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleRentalBookingDateTimeException(RentalBookingDateTimeException e) {
        log.error(e.getMessage(), e);
        ErrorResponse response = new ErrorResponse();
        response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setReason(REASON_PERIOD_INCORRECT);
        response.setMessage(e.getLocalizedMessage());
        return response;
    }
}
