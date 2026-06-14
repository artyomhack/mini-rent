package org.artyomhack.service.user.impl;

import lombok.RequiredArgsConstructor;
import org.artyomhack.entity.User;
import org.artyomhack.repository.DefaultUserRepository;
import org.artyomhack.service.user.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Реализация сервиса {@link UserService}.
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final String MESSAGE_OWNER_HAS_NOT_EXISTS = "Не удалось создать объект аренды: Владельца %s не существует.";

    private final DefaultUserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        return Optional.of(id)
                .map(userRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .orElseThrow(() -> new RuntimeException(String.format(MESSAGE_OWNER_HAS_NOT_EXISTS, id)));
    }
}
