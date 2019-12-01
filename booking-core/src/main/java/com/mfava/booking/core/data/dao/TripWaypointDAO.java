package com.mfava.booking.core.data.dao;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.OptBoolean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

/**
 * @author michaelfava
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripWaypointDAO implements Serializable {

    private static final long serialVersionUID = -3880395148265809451L;
    private UUID tripWayPointId;
    @JsonIgnore
    private BookingDAO booking;
    private Boolean lastStop;
    private String locality;
    private Double lat;
    private Double lng;

    @JsonFormat(lenient = OptBoolean.TRUE, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Instant tripWayPointTimestamp;
}
