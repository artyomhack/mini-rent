package org.artyomhack.service.impl;

import lombok.RequiredArgsConstructor;
import org.artyomhack.generator.PdfGenerator;
import org.artyomhack.model.FileInfo;
import org.artyomhack.model.RentalBookingReportFilter;
import org.artyomhack.service.RentalCreateBookingReportProvider;
import org.springframework.stereotype.Service;

/**
 * Реализация сервиса {@link RentalCreateBookingReportProvider}.
 */
@Service
@RequiredArgsConstructor
public class RentalCreateBookingReportProviderImpl implements RentalCreateBookingReportProvider {

    private final PdfGenerator pdfGenerator;

    @Override
    public FileInfo getReportByFilter(RentalBookingReportFilter reportFilter) {
        return null;
    }
}
