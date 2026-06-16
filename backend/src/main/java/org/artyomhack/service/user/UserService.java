package org.artyomhack.service.user;

import org.artyomhack.entity.UserEntity;

/**
 * Сервис, который работает с пользователями платформы.
 */
public interface UserService {

    /**
     * Метод, который возвращает пользователя по идентификатору.
     *
     * @param id - идентификатор пользователя.
     */
    UserEntity getUserById(Long id);
}
