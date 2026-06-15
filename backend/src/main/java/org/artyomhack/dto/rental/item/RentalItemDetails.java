package org.artyomhack.dto.rental.item;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Модель, которая информирует о сведениях объекта аренды.
 */
@Data
public class RentalItemDetails {

    /**
     * Идентификатор владельца объекта для аренды.
     */
    private Long ownerId;

    /**
     * Название объекта для аренды.
     */
    private String title;

    /**
     * Описание объекта для аренды.
     */
    private String description;


    /**
     * Цена за час у объекта для аренды.
     */
    private BigDecimal pricePerHour;
}
