package com.mfava.booking.api.service;

import com.mfava.booking.api.dto.ApiBookingRequest;
import com.mfava.booking.api.dto.ApiBooking;
import com.mfava.booking.api.dto.ApiBookingUpdateRequest;

import java.util.List;

/**
 * @author michaelfava
 */
public interface BookingService {

    List<ApiBooking> getBookings();

    ApiBooking getBookingById(String id);

    ApiBooking createBooking(ApiBookingRequest request);

    ApiBooking updateBooking(ApiBookingUpdateRequest request);

    void deleteBooking(String id);
}
