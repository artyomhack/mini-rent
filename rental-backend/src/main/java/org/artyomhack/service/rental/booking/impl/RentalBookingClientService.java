package org.artyomhack.service.rental.booking.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.artyomhack.client.AnalyticsFeignClient;
import org.artyomhack.model.RentalBookingCreateEvent;
import org.springframework.stereotype.Service;

/**
 * Сервис, который обрабатывает запросы связанные с бронированием в сторонние системы.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RentalBookingClientService {

    private final AnalyticsFeignClient client;

    public void sendBookingCreateEventRequest(RentalBookingCreateEvent event) {
        try {
            long start = System.currentTimeMillis();
            client.sendBookingReport(event);
            long end = System.currentTimeMillis();
            log.info("Время отправки сообщения: {} ms", end - start);
        } catch (Exception e) {
            log.error("Ошибка при отправке события в сервис аналитики: {}", e.getMessage(), e);
        }
    }
}
