package com.mfava.booking.core.service;

import com.mfava.booking.core.data.dao.BookingDAO;
import com.mfava.booking.core.data.dao.TripWaypointDAO;

import java.util.List;
import java.util.UUID;

/**
 * @author michaelfava
 */
public interface BookingService {

    BookingDAO createBooking(BookingDAO bookingDAO);

    BookingDAO modifyBooking(BookingDAO bookingDAO);

    void deleteBooking(UUID bookingId);

    BookingDAO getBookingById(UUID id);

    List<BookingDAO> getAllBookings();

    List<TripWaypointDAO> getBookingTripWaypoints(UUID id);
}
