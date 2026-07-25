package org.artyomhack.dto.rental.booking;

import lombok.Data;
import org.artyomhack.type.BookingStatus;

import java.time.LocalDateTime;

/**
 * Модель, которая представляет текущее состояние брони у пользователя.
 */
@Data
public class RentalBookingState {

    /**
     * Идентификатор пользователя, который сформировал бронь на объявление о сдаче объекта в аренду.
     */
    private Long renterId;

    /**
     * Статус по брони на объявление о сдаче объекта в аренду.
     */
    private BookingStatus status;

    /**
     * Дата начала аренды.
     */
    private LocalDateTime start;

    /**
     * Дата окончания аренды.
     */
    private LocalDateTime end;
}
