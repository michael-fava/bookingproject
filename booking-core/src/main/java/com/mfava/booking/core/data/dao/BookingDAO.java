package com.mfava.booking.core.data.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mfava.booking.contract.config.OffsetDateTimeModule;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@NoArgsConstructor
public class BookingDAO implements Serializable{

    private static final long serialVersionUID = 345411743618589873L;
    private UUID bookingId;
    private String passengerName;
    private String passengerContactNumber;

    @JsonSerialize(using = OffsetDateTimeModule.CustomOffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeModule.CustomOffsetDateTimeDeserializer.class)
    private OffsetDateTime pickupTime;
    private Boolean asap = true;
    private Integer waitingTime;
    private Integer noOfPassengers;
    private BigDecimal price;
    private Integer rating;

    @JsonFormat(lenient = OptBoolean.TRUE, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    Instant createdOn;

    @JsonFormat(lenient = OptBoolean.TRUE, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    Instant lastModifiedOn;
    private List<TripWaypointDAO> tripWayPoints;
}
