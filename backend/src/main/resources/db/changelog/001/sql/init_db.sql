CREATE SCHEMA IF NOT EXISTS mini_rent;

CREATE SEQUENCE IF NOT EXISTS user_sequence
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS rental_items_sequence
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS rental_agreements_sequence
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS mini_rent.users (
    id BIGINT PRIMARY KEY DEFAULT nextval('user_sequence'),
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    middle_name VARCHAR(50),
    phone_number VARCHAR(16) NOT NULL UNIQUE,
    email TEXT UNIQUE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP
);

COMMENT ON COLUMN mini_rent.users.id IS 'Уникальный идентификатор пользователя';

COMMENT ON COLUMN mini_rent.users.first_name IS 'Имя пользователя';

COMMENT ON COLUMN mini_rent.users.last_name IS 'Фамилия пользователя';

COMMENT ON COLUMN mini_rent.users.middle_name IS 'Отчество пользователя';

COMMENT ON COLUMN mini_rent.users.phone_number IS 'Номер телефона пользователя';

COMMENT ON COLUMN mini_rent.users.email IS 'Эл. почта пользователя';

COMMENT ON COLUMN mini_rent.users.created_at IS 'Дата и время создания пользователя';

COMMENT ON COLUMN mini_rent.users.updated_at IS 'Дата и время последнего изменения пользователя';

COMMENT ON COLUMN mini_rent.users.deleted_at IS 'Дата и время логического удаления пользователя';

-- TODO: Больше напоминает объявление, но на начальной стадии оставим, как карточка объекта аренды.
CREATE TABLE IF NOT EXISTS mini_rent.rental_items(
    id BIGINT PRIMARY KEY DEFAULT nextval('rental_items_sequence'),
    owner_id BIGINT NOT NULL,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    price_per_hour NUMERIC(10,2) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP,
    CONSTRAINT fk_rental_item_owner
        FOREIGN KEY(owner_id) REFERENCES mini_rent.users(id)
);

CREATE INDEX IF NOT EXISTS idx_rental_items_owner_id ON mini_rent.rental_items(owner_id);

COMMENT ON COLUMN mini_rent.rental_items.id IS 'Уникальный идентификатор объекта аренды';

COMMENT ON COLUMN mini_rent.rental_items.owner_id IS 'Идентификатор арендодателя';

COMMENT ON COLUMN mini_rent.rental_items.title IS 'Название объекта аренды';

COMMENT ON COLUMN mini_rent.rental_items.description IS 'Описание объекта аренды';

COMMENT ON COLUMN mini_rent.rental_items.price_per_hour IS 'Цена за час аренды';

COMMENT ON COLUMN mini_rent.rental_items.created_at IS 'Дата и время создания объекта аренды';

COMMENT ON COLUMN mini_rent.rental_items.updated_at IS 'Дата и время последнего изменения объекта аренды';

COMMENT ON COLUMN mini_rent.rental_items.deleted_at IS 'Дата и время логического удаления объекта аренды';

CREATE TABLE IF NOT EXISTS mini_rent.rental_agreements (
    id BIGINT PRIMARY KEY DEFAULT nextval('rental_agreements_sequence'),
    rental_item_id BIGINT NOT NULL,
    renter_id BIGINT NOT NULL,
    start_at TIMESTAMP NOT NULL,
    end_at TIMESTAMP NOT NULL CHECK (start_at < end_at),
    agreement_status VARCHAR(20) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP,
    CONSTRAINT fk_rental_agreement_item
        FOREIGN KEY(rental_item_id) REFERENCES mini_rent.rental_items(id),
    CONSTRAINT fk_rental_agreement_renter
        FOREIGN KEY(renter_id) REFERENCES mini_rent.users(id)
);

CREATE INDEX IF NOT EXISTS idx_rental_agreements_renter_id ON mini_rent.rental_agreements(renter_id);

CREATE INDEX IF NOT EXISTS idx_rental_agreements_item_id ON mini_rent.rental_agreements(rental_item_id);

COMMENT ON COLUMN mini_rent.rental_agreements.id IS 'Уникальный идентификатор договора аренды';

COMMENT ON COLUMN mini_rent.rental_agreements.rental_item_id IS 'Идентификатор объекта аренды';

COMMENT ON COLUMN mini_rent.rental_agreements.renter_id IS 'Идентификатор арендатора';

COMMENT ON COLUMN mini_rent.rental_agreements.start_at IS 'Дата и время начала аренды';

COMMENT ON COLUMN mini_rent.rental_agreements.end_at IS 'Дата и время окончания аренды';

COMMENT ON COLUMN mini_rent.rental_agreements.agreement_status IS 'Текущий статус договора аренды';

COMMENT ON COLUMN mini_rent.rental_agreements.created_at IS 'Дата и время создания договора аренды';

COMMENT ON COLUMN mini_rent.rental_agreements.updated_at IS 'Дата и время последнего изменения договора аренды';

COMMENT ON COLUMN mini_rent.rental_agreements.deleted_at IS 'Дата и время логического удаления договора аренды';