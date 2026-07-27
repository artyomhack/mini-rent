CREATE SCHEMA IF NOT EXISTS mini_rent_analytics;

CREATE SEQUENCE IF NOT EXISTS rental_bookings_report_sequence
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS mini_rent_analytics.rental_bookings_report
(
    booking_id       BIGINT PRIMARY KEY,
    rental_item_id   BIGINT        NOT NULL,
    owner_id         BIGINT        NOT NULL,
    renter_id        BIGINT        NOT NULL,
    booking_status   VARCHAR(20)   NOT NULL,

    price_per_hour   NUMERIC(10, 2),

    start_at         TIMESTAMP     NOT NULL,
    end_at           TIMESTAMP     NOT NULL,
    created_at       TIMESTAMP     NOT NULL,
    synced_at        TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at       TIMESTAMP
);

CREATE INDEX idx_report_bookings_item_created
    ON mini_rent_analytics.rental_bookings_report (rental_item_id, created_at);

COMMENT ON TABLE mini_rent_analytics.rental_bookings_report IS 'Аналитическая таблица отчётов по созданным бронированиям';

COMMENT ON COLUMN mini_rent_analytics.rental_bookings_report.booking_id IS 'Идентификатор бронирования';

COMMENT ON COLUMN mini_rent_analytics.rental_bookings_report.rental_item_id IS 'Идентификатор объекта аренды';

COMMENT ON COLUMN mini_rent_analytics.rental_bookings_report.owner_id IS 'Идентификатор владельца (арендодателя) объекта';

COMMENT ON COLUMN mini_rent_analytics.rental_bookings_report.renter_id IS 'Идентификатор арендатора';

COMMENT ON COLUMN mini_rent_analytics.rental_bookings_report.booking_status IS 'Статус договора аренды';

COMMENT ON COLUMN mini_rent_analytics.rental_bookings_report.price_per_hour IS 'Стоимость часа аренды на момент бронирования';

COMMENT ON COLUMN mini_rent_analytics.rental_bookings_report.start_at IS 'Дата и время начала периода аренды';

COMMENT ON COLUMN mini_rent_analytics.rental_bookings_report.end_at IS 'Дата и время окончания периода аренды';

COMMENT ON COLUMN mini_rent_analytics.rental_bookings_report.created_at IS 'Дата и время создания бронирования';

COMMENT ON COLUMN mini_rent_analytics.rental_bookings_report.synced_at IS 'Дата и время попадания записи в аналитическую БД';

COMMENT ON COLUMN mini_rent_analytics.rental_bookings_report.deleted_at IS 'Дата и время удаление записи';

