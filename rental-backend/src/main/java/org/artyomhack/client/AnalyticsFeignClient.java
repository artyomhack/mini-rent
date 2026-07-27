package org.artyomhack.client;

import org.artyomhack.dto.rental.booking.CreateRentalBookingRequest;
import org.artyomhack.model.RentalBookingCreateEvent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "rental-analytics-client", url = "${application.services.analytics-url}")
public interface AnalyticsFeignClient {

    @PostMapping("/api/v1/rental-analytics/report/create-booking")
    void sendBookingReport(RentalBookingCreateEvent event);
}
