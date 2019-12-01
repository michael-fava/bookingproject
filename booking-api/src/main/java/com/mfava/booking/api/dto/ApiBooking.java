package com.mfava.booking.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.OffsetDateTimeSerializer;
import com.mfava.booking.contract.TripWaypointDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
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
@AllArgsConstructor
@NoArgsConstructor
public class ApiBooking implements Serializable {

    private static final long serialVersionUID = -7860268660959630717L;

    private UUID bookingId;

    private String passengerName;

    private String passengerContactNumber;

    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime pickupTime;

    private Boolean asap = true;

    private Integer waitingTime;

    private Integer noOfPassengers;

    private BigDecimal price;

    private Integer rating;

    @JsonFormat(lenient = OptBoolean.TRUE, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Instant createdOn;

    @JsonFormat(lenient = OptBoolean.TRUE, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Instant lastModifiedOn;

    private List<TripWaypointDTO> tripWayPoints;

}
