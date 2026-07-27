package org.artyomhack.repository;

import org.artyomhack.entity.RentalBookingReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Репозиторий, для работы с таблицей rental_bookings_report
 */
public interface ReportRentalBookingRepository extends JpaRepository<RentalBookingReportEntity, Long> {

    List<RentalBookingReportEntity> findAllByRentalItemIdAndCreatedAtBetween(Long rentalItemId, LocalDateTime from, LocalDateTime to);
}
