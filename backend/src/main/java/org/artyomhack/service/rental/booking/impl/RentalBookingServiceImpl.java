package org.artyomhack.service.rental.booking.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.artyomhack.business.rule.RentalBookingPeriodValidator;
import org.artyomhack.dto.rental.booking.CreateRentalBookingRequest;
import org.artyomhack.entity.RentalBookingEntity;
import org.artyomhack.entity.RentalItemEntity;
import org.artyomhack.entity.UserEntity;
import org.artyomhack.entity.type.BookingStatus;
import org.artyomhack.mapper.RentalBookingMapper;
import org.artyomhack.repository.RentalBookingRepository;
import org.artyomhack.service.rental.booking.RentalBookingService;
import org.artyomhack.service.rental.item.RentalItemService;
import org.artyomhack.service.user.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Реализация сервиса {@link RentalBookingService}.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RentalBookingServiceImpl implements RentalBookingService {

    private final RentalItemService rentalItemService;

    private final RentalBookingPeriodValidator bookingPeriodValidator;

    private final UserService userService;

    private final RentalBookingRepository bookingRepository;

    private final RentalBookingMapper bookingMapper;

    @Override
    @Transactional
    public void createBooking(CreateRentalBookingRequest booking) {
        log.info("Начинаем процесс создания бронирования: {}", booking);
        bookingPeriodValidator.validateBookingPeriodBeforeCreate(booking);

        UserEntity renter = userService.getUserById(booking.getRentalItemId());
        RentalItemEntity rentalItem = rentalItemService.getRentalItemById(booking.getRentalItemId());

        RentalBookingEntity newBooking = bookingMapper.toEntity(booking);
        newBooking.setRenter(renter);
        newBooking.setRentalItem(rentalItem);

        newBooking.setStatus(BookingStatus.PENDING);

        bookingRepository.save(newBooking);
        log.info("Успешно создали бронь для пользователя с идентификатором {} для сдачи в аренду объекта {}",
                renter.getId(), rentalItem.getId());
    }
}
