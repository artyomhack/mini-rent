package org.artyomhack.generator;

import org.artyomhack.model.RentalBookingReport;
import org.artyomhack.model.RentalBookingReportFilter;

import java.util.List;

/**
 * Сервис, который формирует PDF файлы.
 */
public interface PdfGenerator {

    /**
     * Формируем отчёт о бронировании, исходя из фильтров.
     *
     * @param bookingReports - модели для отчётов о бронировании.
     * @return сформированный отчёт.
     */
    byte[] generateReport(List<RentalBookingReport> bookingReports);
}
