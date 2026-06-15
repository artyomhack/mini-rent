package org.artyomhack.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.artyomhack.dto.rentalitem.CreateRentalItemRequest;
import org.artyomhack.dto.rentalitem.RentalItemDetail;
import org.artyomhack.service.rentalitem.RentalItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rental-items")
@RequiredArgsConstructor
public class RentalItemController {

    private final RentalItemService rentalItemService;

    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public RentalItemDetail createRentalItem(@RequestBody @Valid CreateRentalItemRequest request) {
        return rentalItemService.createRentalItem(request);
    }
}
