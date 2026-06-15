package org.artyomhack.repository;

import org.artyomhack.entity.RentalBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий по работе с таблицей rental_bookings.
 */
@Repository
public interface RentalBookingRepository extends JpaRepository<RentalBooking, Long> {
}
