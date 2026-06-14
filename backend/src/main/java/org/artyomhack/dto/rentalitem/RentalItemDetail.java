package org.artyomhack.dto.rentalitem;

import lombok.Data;

/**
 * Модель, которая информирует о сведениях объекта аренды.
 */
@Data
public class RentalItemDetail {

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
    private String pricePerHour;
}
