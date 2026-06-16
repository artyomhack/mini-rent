package org.artyomhack.repository;

import org.artyomhack.entity.RentalBookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Репозиторий по работе с таблицей rental_bookings.
 */
@Repository
public interface RentalBookingRepository extends JpaRepository<RentalBookingEntity, Long> {

    /**
     * Получаем брони, которые пересекаются(накладываются) по времени.
     *
     * @param startAt - начало времени бронирования.
     * @param endAt   - окончание времени бронирования.
     * @return список броней, которые пересекаются.
     */
    @Query(nativeQuery = true,
            value = "SELECT rb.* FROM mini_rent.rental_bookings rb WHERE" +
                    "(rb.start_at <= :end_at) AND (rb.end_at >= :start_at)")
    List<RentalBookingEntity> findOverlappingBookings(@Param("start_at") LocalDateTime startAt,
                                                      @Param("end_at") LocalDateTime endAt);
}
