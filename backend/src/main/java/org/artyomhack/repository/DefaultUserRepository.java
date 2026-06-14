package org.artyomhack.repository;

import org.artyomhack.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Базовый репозиторий, который работает с таблицей users (Пользователи).
 */
@Repository
public interface DefaultUserRepository extends JpaRepository<User, Long> {

}
