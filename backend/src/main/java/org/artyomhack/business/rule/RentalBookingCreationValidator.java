package org.artyomhack.business.rule;

import lombok.RequiredArgsConstructor;
import org.artyomhack.business.rule.constant.RentalBookingBusinessRuleConstant;
import org.artyomhack.common.exception.RentalBookingDateTimeException;
import org.artyomhack.config.BookingProperties;
import org.artyomhack.dto.rental.booking.CreateRentalBookingRequest;
import org.artyomhack.repository.RentalBookingRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Абстрактная модель о правилах бизнес для бронирования аренды.
 */
@Service
@RequiredArgsConstructor
public class RentalBookingCreationValidator {

    private final BookingProperties bookingProperties;

    private final RentalBookingRepository rentalBookingRepository;

    /**
     * Метод, который проверяет бизнес правила при создании брони.
     *
     * @param bookingRequest - модель запроса для создания брони.
     */
    public void validateBookingCreation(CreateRentalBookingRequest bookingRequest) {
        Long rentalItemId = bookingRequest.getRentalItemId();
        LocalDateTime start = bookingRequest.getStart();
        LocalDateTime end = bookingRequest.getEnd();

        validateBookingPeriod(start, end);

        validateBookingIntersection(rentalItemId, start, end);
    }

    private void validateBookingIntersection(Long rentalItemId, LocalDateTime start, LocalDateTime end) {
        rentalBookingRepository.findFirstOverlappingBooking(rentalItemId, start, end).ifPresent(
                booking -> {
                    throw new RentalBookingDateTimeException(
                            RentalBookingBusinessRuleConstant.getMessagePeriodIsBusy(
                                    booking.getStartAt(), booking.getEndAt()));
                });
    }

    private void validateBookingPeriod(LocalDateTime start, LocalDateTime end) {
        BookingProperties.LimitHour limitHour = bookingProperties.getLimitHour();
        int maxLimitInHour = limitHour.getMax();
        int minLimitInHour = limitHour.getMin();

        Duration duration = Duration.between(start, end);

        if (duration.isNegative() || duration.isZero()) {
            throw new RentalBookingDateTimeException(RentalBookingBusinessRuleConstant.MESSAGE_DURATION_INCORRECT);
        }

        if (duration.toHours() < minLimitInHour) {
            throw new RentalBookingDateTimeException(RentalBookingBusinessRuleConstant.MESSAGE_DURATION_MIN_DATETIME);
        }

        if (duration.toHours() > maxLimitInHour) {
            throw new RentalBookingDateTimeException(RentalBookingBusinessRuleConstant.MESSAGE_DURATION_MAX_DATETIME);
        }
    }
}
