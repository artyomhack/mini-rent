package org.artyomhack.service.rental.item;

import org.artyomhack.dto.rental.item.CreateRentalItemRequest;
import org.artyomhack.dto.rental.item.RentalItemDetails;

/**
 * Сервис, который работает с объектами для аренды.
 */
public interface RentalItemService {

    /**
     * Метод, который создаёт объект аренды.
     * @param request - запрос на создание объекта аренды.
     */
    RentalItemDetails createRentalItem(CreateRentalItemRequest request);
}
