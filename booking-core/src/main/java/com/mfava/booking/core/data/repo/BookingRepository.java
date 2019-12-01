package com.mfava.booking.core.data.repo;

import com.mfava.booking.core.data.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author michaelfava
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, UUID> {

    Optional<Booking> findByBookingIdAndDeletedFalse(UUID bookingId);

    List<Booking> findAllByDeletedFalse();

}
