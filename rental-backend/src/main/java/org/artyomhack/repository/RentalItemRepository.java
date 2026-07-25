package org.artyomhack.repository;

import org.artyomhack.entity.RentalItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий, который работает с таблицей rental_items (Объекты аренды).
 */
@Repository
public interface RentalItemRepository extends JpaRepository<RentalItemEntity, Long> {

}
