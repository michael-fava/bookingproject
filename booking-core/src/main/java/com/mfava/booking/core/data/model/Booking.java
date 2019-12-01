package com.mfava.booking.core.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @author michaelfava
 */
@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @Type(type = "uuid-char")
    @ColumnDefault("random_uuid()")
    @GeneratedValue(generator = "UUID_Booking")
    @GenericGenerator(name = "UUID_Booking",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID bookingId;
    private String passengerName;
    private String passengerContactNumber;
    private OffsetDateTime pickupTime;
    private Boolean asap = true;
    private Integer waitingTime;
    private Integer noOfPassengers;
    private BigDecimal price;
    private Integer rating;

    @CreationTimestamp
    private Instant createdOn;

    @UpdateTimestamp
    private Instant lastModifiedOn;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name="booking_waypoints",
            joinColumns = @JoinColumn( name="booking_id"),
            inverseJoinColumns = @JoinColumn( name="trip_way_point_id")
    )
    private List<TripWaypoint> tripWayPoints;


    private boolean deleted;
}
