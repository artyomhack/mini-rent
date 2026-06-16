package org.artyomhack.business.rule;

import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.artyomhack.business.rule.constant.RentalBookingBusinessRuleConstant;
import org.artyomhack.common.exception.RentalBookingDateTimeException;
import org.artyomhack.dto.rental.booking.CreateRentalBookingRequest;
import org.artyomhack.entity.RentalBookingEntity;
import org.artyomhack.repository.RentalBookingRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Абстрактная модель о правилах бизнес для бронирования аренды.
 */
@Service
@RequiredArgsConstructor
public final class RentalBookingPeriodValidator {

    @Value("${application.booking.limit-hour.max:24}")
    private int maxLimitInHour;

    @Value("${application.booking.limit-hour.min:1}")
    private int minLimitInHour;

    private final RentalBookingRepository rentalBookingRepository;

    /**
     * Метод, который проверяет бизнес правила с периодом времени у бронирования, перед его созданием.
     *
     * @param bookingRequest - модель запроса для создания брони.
     */
    public void validateBookingPeriodBeforeCreate(CreateRentalBookingRequest bookingRequest) {
        LocalDateTime start = bookingRequest.getStart();
        LocalDateTime end = bookingRequest.getEnd();

        checkBookingPeriod(start, end);

        Optional<RentalBookingEntity> anyFinedPeriod = rentalBookingRepository
                .findOverlappingBookings(start, end)
                .stream()
                .findAny();

        if (anyFinedPeriod.isPresent()) {
            RentalBookingEntity finedPeriod = anyFinedPeriod.get();
            start = finedPeriod.getStartAt();
            end = finedPeriod.getEndAt();
            throw new RentalBookingDateTimeException(RentalBookingBusinessRuleConstant
                    .getMessagePeriodIsBusy(start, end));
        }
    }

    private void checkBookingPeriod(LocalDateTime start, LocalDateTime end) {
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
