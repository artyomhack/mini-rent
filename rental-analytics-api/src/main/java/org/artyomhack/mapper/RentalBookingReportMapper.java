package org.artyomhack.mapper;

import org.artyomhack.entity.RentalBookingReportEntity;
import org.artyomhack.model.RentalCreateBookingReport;
import org.mapstruct.Mapper;

/**
 * Маппер, который конвертирует представление об отчёте в сущность отчёта.
 */
@Mapper(componentModel = "spring")
public interface RentalBookingReportMapper {

    RentalBookingReportEntity toEntity(RentalCreateBookingReport report);
}
