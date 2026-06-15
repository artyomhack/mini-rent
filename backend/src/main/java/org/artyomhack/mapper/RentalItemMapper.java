package org.artyomhack.mapper;

import org.artyomhack.dto.rental.item.CreateRentalItemRequest;
import org.artyomhack.dto.rental.item.RentalItemDetails;
import org.artyomhack.entity.RentalItem;
import org.mapstruct.Mapper;

/**
 * Маппер, который преобразовывает сущность {@link RentalItem} в модель {@link CreateRentalItemRequest}
 * и преобразует из сущности {@link RentalItem} в модель {@link RentalItemDetails}.
 */
@Mapper(componentModel = "spring")
public interface RentalItemMapper {

    RentalItem toEntity(CreateRentalItemRequest request);

    RentalItemDetails toDto(RentalItem entity);
}
