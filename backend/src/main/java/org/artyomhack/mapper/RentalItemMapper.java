package org.artyomhack.mapper;

import org.artyomhack.dto.rentalitem.CreateRentalItemRequest;
import org.artyomhack.entity.RentalItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RentalItemMapper {

    RentalItem toEntity(CreateRentalItemRequest request);
}
