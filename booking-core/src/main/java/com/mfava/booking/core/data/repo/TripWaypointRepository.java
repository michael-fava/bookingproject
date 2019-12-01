package com.mfava.booking.core.data.repo;

import com.mfava.booking.core.data.model.TripWaypoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * @author michaelfava
 */
@Repository
public interface TripWaypointRepository extends JpaRepository<TripWaypoint, UUID> {

    List<TripWaypoint> findAllByBookingEquals(UUID bookingId);



}
