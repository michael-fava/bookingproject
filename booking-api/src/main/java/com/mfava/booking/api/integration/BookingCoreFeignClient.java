package com.mfava.booking.api.integration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mfava.booking.api.config.FeignConfig;
import com.mfava.booking.contract.BookingDTO;
import com.mfava.booking.contract.TripWaypointDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author michaelfava
 */
@FeignClient(name = "booking-core-feign", url = "localhost:8080", configuration = FeignConfig.class, decode404 = true)
public interface BookingCoreFeignClient {

    @GetMapping(value = "/bookings")
    List<BookingDTO> getAllBookings();

    @GetMapping(value = "/bookings/{id}")
    BookingDTO getBookingById(@PathVariable(name = "id") String id);

    @GetMapping(value = "/bookings/{id}/tripwaypoints")
    List<TripWaypointDTO> getBookingTripWayPointsById(@PathVariable(name = "id") String id);
}
