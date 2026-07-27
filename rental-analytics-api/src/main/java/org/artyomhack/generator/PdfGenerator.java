package org.artyomhack.generator;

import org.artyomhack.model.RentalBookingReportFilter;

/**
 * Сервис, который формирует PDF файлы.
 */
public interface PdfGenerator {

    /**
     * Формируем отчёт о бронировании, исходя из фильтров.
     *
     * @param reportFilter - фильтр.
     * @return сформированный отчёт.
     */
    byte[] generateReport(RentalBookingReportFilter reportFilter);
}
