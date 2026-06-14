package org.artyomhack.service.rentalitem;

import org.artyomhack.dto.rentalitem.CreateRentalItemRequest;

/**
 * Сервис, который работает с объектами для аренды.
 */
public interface RentalItemService {

    /**
     * Метод, который создаёт объект аренды.
     * @param request - запрос на создание объекта аренды.
     */
    void createRentalItem(CreateRentalItemRequest request);
}
