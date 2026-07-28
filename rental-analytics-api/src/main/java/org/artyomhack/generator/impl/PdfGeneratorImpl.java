package org.artyomhack.generator.impl;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.layout.font.FontProvider;
import org.apache.commons.collections4.CollectionUtils;
import org.artyomhack.generator.PdfGenerator;
import org.artyomhack.model.RentalBookingReport;
import org.artyomhack.model.RentalBookingReportFilter;
import org.springframework.cglib.core.Local;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/**
 * Реализация сервиса {@link PdfGenerator}.
 */
@Service
public class PdfGeneratorImpl implements PdfGenerator {

    private static final String TEMPLATE_DESCRIPTION = """
        <!DOCTYPE html>
        <html>
        <head>
            <meta charset="UTF-8"/>
        </head>
        <body>
            <h2>Отчёт о бронировании</h2>
            <hr/>
            
            <table border="0" cellpadding="4" cellspacing="0">
                <tr>
                    <td><b>Объект:</b></td>
                    <td>%s</td>
                </tr>
                <tr>
                    <td><b>Период:</b></td>
                    <td>с %s по %s</td>
                </tr>
            </table>
            
            <hr/>
            <p>Количество созданных броней: <b>%s</b></p>
        </body>
        </html>
        """;

    private static final String TEMPLATE_ERROR_DESCRIPTION = """
            <!DOCTYPE html>
            <html>
            <head><meta charset="UTF-8"/></head>
            <body>
               <h2>Отчёт о бронировании</h2>
               <hr/>
               <p>На данный момент нет записей о бронях.</p>
            </body>
            </html>
            """;

    private static final String DATE_TIME_FORMAT = "dd MMMM yyyy HH:mm";

    @Override
    public byte[] generateReport(List<RentalBookingReport> bookingReports) {
        if (CollectionUtils.isEmpty(bookingReports)) {
            return generateReport(TEMPLATE_ERROR_DESCRIPTION);
        }

        RentalBookingReport firstReport = bookingReports.getFirst();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);

        String from = firstReport.getFrom().format(dateTimeFormatter);
        String to = firstReport.getTo().format(dateTimeFormatter);
        Long rentalItemId = firstReport.getRentalItemId();
        int sizeAllBookings = bookingReports.size();

        String formattedHtml = TEMPLATE_DESCRIPTION.formatted(rentalItemId, from, to, sizeAllBookings);

        return generateReport(formattedHtml);
    }

    private byte[] generateReport(String formattedHtml) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            ConverterProperties properties = new ConverterProperties();
            properties.setCharset(StandardCharsets.UTF_8.name());

            HtmlConverter.convertToPdf(formattedHtml, outputStream, properties);
            return outputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Не удалось сформировать отчёт по броням в PDF файл: ", e);
        }
    }
}
