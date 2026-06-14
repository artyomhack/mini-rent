package org.artyomhack.service.rentalitem.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.artyomhack.dto.rentalitem.CreateRentalItemRequest;
import org.artyomhack.entity.RentalItem;
import org.artyomhack.entity.User;
import org.artyomhack.mapper.RentalItemMapper;
import org.artyomhack.repository.RentalItemRepository;
import org.artyomhack.service.rentalitem.RentalItemService;
import org.artyomhack.service.user.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Реализация сервиса {@link RentalItemService}.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RentalItemServiceImpl implements RentalItemService {

    private final UserService userService;

    private final RentalItemRepository rentalItemRepository;

    private final RentalItemMapper rentalItemMapper;

    @Override
    @Transactional
    public void createRentalItem(CreateRentalItemRequest request) {
        log.info("Выполняется создание объекта для аренды: {}", request);
        User user = userService.getUserById(request.getOwnerId());
        RentalItem newEntity = rentalItemMapper.toEntity(request);

        newEntity.setOwner(user);

        rentalItemRepository.save(newEntity);
        log.info("Успешно выполнилось создание объекта для аренды c идентификатором: {}", newEntity.getId());
    }
}
