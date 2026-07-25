package org.artyomhack.mapper;

import org.artyomhack.dto.rental.booking.CreateRentalBookingRequest;
import org.artyomhack.dto.rental.item.CreateRentalItemRequest;
import org.artyomhack.dto.rental.item.RentalItemDetails;
import org.artyomhack.entity.RentalBookingEntity;
import org.artyomhack.entity.RentalItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Маппер, который преобразовывает сущность {@link RentalBookingEntity} в модель {@link CreateRentalItemRequest}
 * и преобразует из сущности {@link RentalItemEntity} в модель {@link RentalItemDetails}.
 */
@Mapper(componentModel = "spring")
public interface RentalBookingMapper {

    @Mapping(target = "startAt", source = "start")
    @Mapping(target = "endAt", source = "end")
    RentalBookingEntity toEntity(CreateRentalBookingRequest dto);
}
