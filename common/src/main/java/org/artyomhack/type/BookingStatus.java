package org.artyomhack.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Статус на котором находится текущее соглашение об аренде.
 */
@Getter
@AllArgsConstructor
public enum BookingStatus {
    PENDING("PENDING"),
    APPROVED("APPROVED"),
    ACTIVE("ACTIVE"),
    COMPLETED("COMPLETED"),
    REJECTED("REJECTED"),
    CANCELLED("CANCELLED");

    private final String status;
}
