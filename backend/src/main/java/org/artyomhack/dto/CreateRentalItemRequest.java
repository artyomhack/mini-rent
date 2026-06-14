package org.artyomhack.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Модель создания объекта аренды.
 */
@Data
public class CreateRentalItemRequest {

    @NotBlank(message = "Название объекта для аренды обязательно!")
    private String title;

    @Size(max = 1000, message = "Описание объекта для аренды не должно быть больше 1000 символов!")
    private String description;

    @PositiveOrZero(message = "Цена за час не должна быть отрицательной!")
    private BigDecimal pricePerHour;
}
