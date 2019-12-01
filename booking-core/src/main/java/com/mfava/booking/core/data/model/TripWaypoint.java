package com.mfava.booking.core.data.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

/**
 * @author michaelfava
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TripWaypoint {

    @Id
    @Type(type = "uuid-char")
    @ColumnDefault("random_uuid()")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID tripWayPointId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "booking", referencedColumnName = "bookingId")
    private Booking booking;
    private Boolean lastStop;
    private String locality;
    private Double lat;
    private Double lng;
    private Instant tripWayPointTimestamp;

    private boolean deleted;
}
