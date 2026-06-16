package org.artyomhack.mapper;

import org.artyomhack.dto.rental.item.CreateRentalItemRequest;
import org.artyomhack.dto.rental.item.RentalItemDetails;
import org.artyomhack.entity.RentalItemEntity;
import org.mapstruct.Mapper;

/**
 * Маппер, который преобразовывает сущность {@link RentalItemEntity} в модель {@link CreateRentalItemRequest}
 * и преобразует из сущности {@link RentalItemEntity} в модель {@link RentalItemDetails}.
 */
@Mapper(componentModel = "spring")
public interface RentalItemMapper {

    RentalItemEntity toEntity(CreateRentalItemRequest request);

    RentalItemDetails toDto(RentalItemEntity entity);
}
