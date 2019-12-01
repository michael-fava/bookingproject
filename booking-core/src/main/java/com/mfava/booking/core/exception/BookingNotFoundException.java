package com.mfava.booking.core.exception;

import java.util.UUID;

/**
 * @author michaelfava
 */
public class BookingNotFoundException extends RuntimeException {

    UUID bookingId;

    public BookingNotFoundException(UUID bookingId) {
        this.bookingId = bookingId;
    }
}
