package org.artyomhack.service.rental.booking.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.artyomhack.business.rule.RentalBookingCreationValidator;
import org.artyomhack.annotation.DisableDeleted;
import org.artyomhack.client.AnalyticsFeignClient;
import org.artyomhack.dto.rental.booking.CreateRentalBookingRequest;
import org.artyomhack.entity.RentalBookingEntity;
import org.artyomhack.entity.RentalItemEntity;
import org.artyomhack.entity.UserEntity;
import org.artyomhack.model.RentalBookingCreateEvent;
import org.artyomhack.type.BookingStatus;
import org.artyomhack.mapper.RentalBookingMapper;
import org.artyomhack.repository.RentalBookingRepository;
import org.artyomhack.service.rental.booking.RentalBookingService;
import org.artyomhack.service.rental.item.RentalItemService;
import org.artyomhack.service.user.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClient;

import java.time.LocalDateTime;

/**
 * Реализация сервиса {@link RentalBookingService}.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RentalBookingServiceImpl implements RentalBookingService {

    private static final String DELETED_BOOKING_FILTER = "deletedBookingFilter";

    private final RentalItemService rentalItemService;

    private final RentalBookingCreationValidator bookingPeriodValidator;

    private final UserService userService;

    private final RentalBookingRepository bookingRepository;

    private final RentalBookingMapper bookingMapper;

    @Override
    @Transactional
    @DisableDeleted(filter = DELETED_BOOKING_FILTER)
    public RentalBookingCreateEvent createBooking(CreateRentalBookingRequest booking) {
        log.info("Начинаем процесс создания бронирования: {}", booking);
        bookingPeriodValidator.validateBookingCreation(booking);

        UserEntity renter = userService.getUserById(booking.getRentalItemId());
        RentalItemEntity rentalItem = rentalItemService.getRentalItemById(booking.getRentalItemId());

        RentalBookingEntity newBooking = bookingMapper.toEntity(booking);
        newBooking.setRenter(renter);
        newBooking.setRentalItem(rentalItem);

        newBooking.setStatus(BookingStatus.PENDING);

        bookingRepository.saveAndFlush(newBooking);
        log.info("Успешно создали бронь для пользователя с идентификатором {} для сдачи в аренду объекта {}",
                renter.getId(), rentalItem.getId());

        return bookingMapper.toBookingCreateEvent(newBooking);
    }
}
