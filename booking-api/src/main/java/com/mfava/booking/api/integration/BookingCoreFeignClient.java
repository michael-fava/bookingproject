package com.mfava.booking.api.integration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfava.booking.api.config.FeignConfig;
import com.mfava.booking.contract.BookingDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * @author michaelfava
 */
@FeignClient(name = "booking-core-feign", url = "http://localhost:8080", configuration = FeignConfig.class, decode404 = true)
public interface BookingCoreFeignClient {

    @JsonProperty(value = "collection")
    @GetMapping(value = "/bookingscore/bookings")
    Collection<BookingDTO> getAllBookings();

    @GetMapping(value = "/bookingscore/bookings/${id}")
    BookingDTO getBookingById(@PathVariable(name = "id") String id);
}
