package org.artyomhack.service.user.impl;

import lombok.RequiredArgsConstructor;
import org.artyomhack.common.exception.UserNotFoundException;
import org.artyomhack.entity.UserEntity;
import org.artyomhack.repository.DefaultUserRepository;
import org.artyomhack.service.user.UserService;
import org.springframework.stereotype.Service;

/**
 * Реализация сервиса {@link UserService}.
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final String MESSAGE_OWNER_HAS_NOT_EXISTS = "Не удалось найти пользователя: " +
            "Пользователя по идентификатору %s не существует.";

    private final DefaultUserRepository userRepository;

    @Override
    public UserEntity getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format(MESSAGE_OWNER_HAS_NOT_EXISTS, id)));
    }
}
