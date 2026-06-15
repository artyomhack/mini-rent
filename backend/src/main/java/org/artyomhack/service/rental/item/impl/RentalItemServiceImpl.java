package org.artyomhack.service.rental.item.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.artyomhack.dto.rental.item.CreateRentalItemRequest;
import org.artyomhack.dto.rental.item.RentalItemDetails;
import org.artyomhack.entity.RentalItem;
import org.artyomhack.entity.User;
import org.artyomhack.mapper.RentalItemMapper;
import org.artyomhack.repository.RentalItemRepository;
import org.artyomhack.service.rental.item.RentalItemService;
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
    public RentalItemDetails createRentalItem(CreateRentalItemRequest request) {
        log.info("Выполняется создание объекта для аренды: {}", request);
        //TODO: Потом будем брать пользователя из контекста безопасности, а не по id.
        User user = userService.getUserById(request.getOwnerId());
        RentalItem newEntity = rentalItemMapper.toEntity(request);

        newEntity.setOwner(user);

        RentalItem result = rentalItemRepository.save(newEntity);
        log.info("Успешно выполнилось создание объекта для аренды c идентификатором: {}", result.getId());
        return rentalItemMapper.toDto(newEntity);
    }
}
