package org.artyomhack.dto.rentalitem;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Модель создания объекта аренды.
 */
@Data
public class CreateRentalItemRequest {

    /**
     * Идентификатор текущего пользователя.
     */
    //TODO: Временное решение, брать пользователя из контекста безопасности.
    @NotNull(message = "Идентификатор текущего пользователя обязателен!")
    private Long ownerId;

    /**
     * Название объекта для аренды.
     */
    @NotBlank(message = "Название объекта для аренды обязательно!")
    private String title;

    /**
     * Описание объекта для аренды.
     */
    @Size(max = 1000, message = "Описание объекта для аренды не должно быть больше 1000 символов!")
    private String description;

    /**
     * Цена за час у объекта для аренды.
     */
    @PositiveOrZero(message = "Цена за час не должна быть отрицательной!")
    private BigDecimal pricePerHour;
}
