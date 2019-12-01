package com.mfava.booking.core.service;

import com.mfava.booking.contract.BookingDTO;
import com.mfava.booking.core.data.dao.BookingDAO;
import com.mfava.booking.core.data.service.BookingDataService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author michaelfava
 */
@Slf4j
@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    BookingDataService bookingDataService;

    @Override
    public BookingDAO createBooking(BookingDAO bookingDAO) {
        return bookingDataService.createBooking(bookingDAO);
    }

    @Override
    public BookingDAO modifyBooking(BookingDAO bookingDAO) {
        return bookingDataService.modifyBooking(bookingDAO);
    }

    @Override
    public void deleteBooking(UUID bookingId) {
        bookingDataService.deleteBooking(bookingId);
    }

    @Override
    public BookingDAO getBookingById(UUID id) {
        return bookingDataService.getBooking(id);
    }

    @Override
    public List<BookingDAO> getAllBookings() {
        return bookingDataService.getAllBookings();
    }
}
