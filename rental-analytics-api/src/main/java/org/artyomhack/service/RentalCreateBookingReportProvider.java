package org.artyomhack.service;

import org.artyomhack.model.FileInfo;
import org.artyomhack.model.RentalBookingReportFilter;

/**
 * Сервис, который работает с отчётом по созданным броням объектов, сдавших в аренду.
 */
public interface RentalCreateBookingReportProvider {

     /**
      * Получить отчёт, исходя из фильтра по созданным броням объектов, сдавших в аренду.
      */
     FileInfo getReportByFilter(RentalBookingReportFilter reportFilter);
}
