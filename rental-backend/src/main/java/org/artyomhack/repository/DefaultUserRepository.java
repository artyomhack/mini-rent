package org.artyomhack.repository;

import org.artyomhack.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Базовый репозиторий, который работает с таблицей users (Пользователи).
 */
@Repository
public interface DefaultUserRepository extends JpaRepository<UserEntity, Long> {

}
