package com.mfava.booking.api.service;

import com.mfava.booking.api.dto.ApiBookingRequest;
import com.mfava.booking.api.dto.ApiBooking;
import com.mfava.booking.api.dto.ApiBookingUpdateRequest;
import com.mfava.booking.api.dto.ApiTripWaypoint;

import java.util.List;

/**
 * @author michaelfava
 */
public interface BookingService {

    List<ApiBooking> getBookings();

    ApiBooking getBookingById(String id);

    List<ApiTripWaypoint> getBookingTripWayPoints(String id);

    ApiBooking createBooking(ApiBookingRequest request);

    ApiBooking updateBooking(ApiBookingUpdateRequest request);

    void deleteBooking(String id);
}
