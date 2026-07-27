package org.artyomhack.mapper;

import org.artyomhack.dto.rental.booking.CreateRentalBookingRequest;
import org.artyomhack.dto.rental.item.CreateRentalItemRequest;
import org.artyomhack.dto.rental.item.RentalItemDetails;
import org.artyomhack.entity.RentalBookingEntity;
import org.artyomhack.entity.RentalItemEntity;
import org.artyomhack.model.RentalBookingCreateEvent;
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

    @Mapping(target = "bookingId", source = "id")
    @Mapping(target = "bookingStatus", source = "status")
    @Mapping(target = "rentalItemId", source = "rentalItem.id")
    @Mapping(target = "renterId", source = "renter.id")
    @Mapping(target = "ownerId", source = "rentalItem.owner.id")
    @Mapping(target = "pricePerHour", source = "rentalItem.pricePerHour")
    RentalBookingCreateEvent toBookingCreateEvent(RentalBookingEntity entity);
}
