package org.artyomhack.mapper;

import org.artyomhack.dto.rentalitem.CreateRentalItemRequest;
import org.artyomhack.dto.rentalitem.RentalItemDetail;
import org.artyomhack.entity.RentalItem;
import org.mapstruct.Mapper;

/**
 * Маппер, который преобразовывает сущность {@link RentalItem} в модель {@link CreateRentalItemRequest}
 * и преобразует из сущности {@link RentalItem} в модель {@link RentalItemDetail}.
 */
@Mapper(componentModel = "spring")
public interface RentalItemMapper {

    RentalItem toEntity(CreateRentalItemRequest request);

    RentalItemDetail toDto(RentalItem entity);
}
