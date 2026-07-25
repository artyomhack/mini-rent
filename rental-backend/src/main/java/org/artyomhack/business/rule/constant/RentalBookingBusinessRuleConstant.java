package org.artyomhack.business.rule.constant;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Константы для даты и времени при работе с бронированием.
 */
public class RentalBookingBusinessRuleConstant {

    private static final String MESSAGE_DEFAULT_EXCEPTION = "Нельзя создать бронь: %s";

    private static final String MESSAGE_PERIOD_IS_BUSY = String.format(MESSAGE_DEFAULT_EXCEPTION,
            "Выбранное время для бронирования от %s до %s занято.");

    public static final String MESSAGE_DURATION_INCORRECT = String.format(
            MESSAGE_DEFAULT_EXCEPTION, "Дата и время должна иметь разницу в один час");

    public static final String MESSAGE_DURATION_MIN_DATETIME = String.format(
            MESSAGE_DEFAULT_EXCEPTION, "Минимальное время для бронирования аренды один час.");

    public static final String MESSAGE_DURATION_MAX_DATETIME = String.format(
            MESSAGE_DEFAULT_EXCEPTION, "Максимальное время для бронирования аренды 7 дней.");

    public static String getMessagePeriodIsBusy(LocalDateTime startAt, LocalDateTime endAt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        return String.format(MESSAGE_PERIOD_IS_BUSY,  formatter.format(startAt), formatter.format(endAt));
    }
}
