package org.artyomhack.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.artyomhack.dto.rental.booking.CreateRentalBookingRequest;
import org.artyomhack.service.rental.booking.RentalBookingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rental-bookings")
@RequiredArgsConstructor
public class RentalBookingController {

    private final RentalBookingService bookingService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createBookings(@RequestBody @Valid CreateRentalBookingRequest request) {
        bookingService.createBooking(request);
    }
}
