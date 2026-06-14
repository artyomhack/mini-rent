package org.artyomhack.service.user;

import org.artyomhack.entity.User;

/**
 * Сервис, который работает с пользователями платформы.
 */
public interface UserService {

    /**
     * Метод, который возвращает пользователя по идентификатору.
     *
     * @param id - идентификатор пользователя.
     * @return пользователя.
     */
    User getUserById(Long id);
}
