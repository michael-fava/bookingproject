package com.mfava.booking.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mfava.booking.contract.config.OffsetDateTimeModule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @author michaelfava
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiBookingUpdateRequest implements Serializable {

    private static final long serialVersionUID = 2469838855617726424L;
    @NotNull
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

    private List<ApiTripWaypoint> tripWayPoints;
}
