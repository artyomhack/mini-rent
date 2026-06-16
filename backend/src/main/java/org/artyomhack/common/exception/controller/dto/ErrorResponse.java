package org.artyomhack.common.exception.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * Модель, которая представляет ошибку после обработки исключений.
 */
public class ErrorResponse {
    /**
     * Код ошибки.
     */
    private int code;

    /**
     * Причина возникновения ошибки.
     */
    private String reason;

    /**
     * Сообщение об ошибке.
     */
    private String message;

    /**
     * Метка времени возникновения ошибки.
     */
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssxxx")
    private OffsetDateTime timestamp;

    /**
     * Список ошибок.
     */
    private List<String> errors;

    public ErrorResponse() {
        this.timestamp = OffsetDateTime.now();
    }
}
