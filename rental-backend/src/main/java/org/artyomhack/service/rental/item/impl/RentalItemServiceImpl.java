package org.artyomhack.service.rental.item.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.artyomhack.exception.RentalItemNotFoundException;
import org.artyomhack.dto.rental.item.CreateRentalItemRequest;
import org.artyomhack.dto.rental.item.RentalItemDetails;
import org.artyomhack.entity.RentalItemEntity;
import org.artyomhack.entity.UserEntity;
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

    private static final String MESSAGE_RENTAL_ITEM_NOT_FOUND = "Не удалось получить объект аренды: " +
            "Объекта аренды с идентификатором %s не существует";

    private final UserService userService;

    private final RentalItemRepository rentalItemRepository;

    private final RentalItemMapper rentalItemMapper;

    @Override
    @Transactional
    public RentalItemDetails createRentalItem(CreateRentalItemRequest request) {
        log.info("Выполняется создание объекта для аренды: {}", request);
        //TODO: Потом будем брать пользователя из контекста безопасности, а не по id.
        UserEntity user = userService.getUserById(request.getOwnerId());
        RentalItemEntity newEntity = rentalItemMapper.toEntity(request);

        newEntity.setOwner(user);

        RentalItemEntity savedRentalItem = rentalItemRepository.save(newEntity);
        log.info("Успешно выполнилось создание объекта для аренды c идентификатором: {}", savedRentalItem.getId());
        return rentalItemMapper.toDto(newEntity);
    }

    @Override
    public RentalItemEntity getRentalItemById(Long id) {
        return rentalItemRepository.findById(id)
                .orElseThrow(() -> new RentalItemNotFoundException(String.format(MESSAGE_RENTAL_ITEM_NOT_FOUND, id)));
    }
}
