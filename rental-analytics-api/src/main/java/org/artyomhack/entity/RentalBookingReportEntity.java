package org.artyomhack.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.artyomhack.type.BookingStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.SQLDelete;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Сущность `Отчёт о бронировании`.
 * Представление таблицы rental_bookings_report.
 */
@Entity
@Table(name = "rental_bookings_report", schema = "mini_rent_analytics")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@SQLDelete(sql = "UPDATE mini_rent_analytics.rental_bookings_report SET deleted_at = CURRENT_TIMESTAMP WHERE booking_id = ?")
@FilterDef(name = "deletedReportRentalBookingFilter")
@Filter(name = "deletedReportRentalBookingFilter", condition = "deleted_at IS NULL")
public class RentalBookingReportEntity {

    @Id
    @Column(name = "booking_id")
    private Long bookingId;

    @Column(name = "rental_item_id", nullable = false)
    private Long rentalItemId;

    @Column(name = "owner_id", nullable = false)
    private Long ownerId;

    @Column(name = "renter_id", nullable = false)
    private Long renterId;

    @Column(name = "booking_status", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingStatus;

    @Column(name = "price_per_hour")
    private BigDecimal pricePerHour;

    @Column(name = "start_at")
    private LocalDateTime startAt;

    @Column(name = "end_at")
    private LocalDateTime endAt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "synced_at")
    @CreationTimestamp
    private LocalDateTime syncedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
