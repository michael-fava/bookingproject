package com.mfava.booking.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class ApiTripWaypoint implements Serializable {

    private static final long serialVersionUID = -7236808359526930358L;

    private UUID tripWayPointId;

    private Boolean lastStop;

    private String locality;

    private Double lat;

    private Double lng;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Instant tripWayPointTimestamp;
}
