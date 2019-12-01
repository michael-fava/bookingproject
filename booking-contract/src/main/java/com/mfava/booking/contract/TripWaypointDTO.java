package com.mfava.booking.contract;


import com.fasterxml.jackson.annotation.JsonFormat;
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
public class TripWaypointDTO implements Serializable {

    private static final long serialVersionUID = -7648827850674402975L;

    private UUID tripWayPointId;
    private BookingDTO booking;
    private Boolean lastStop;
    private String locality;
    private Double lat;
    private Double lng;

    @JsonFormat(lenient = OptBoolean.TRUE, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Instant tripWayPointTimestamp;
}
