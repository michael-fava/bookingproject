package com.mfava.booking.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mfava.booking.contract.config.OffsetDateTimeModule;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author michaelfava
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Request to create a booking")
public class ApiBookingRequest implements Serializable {

    private static final long serialVersionUID = -6177639150122979658L;

    @NotNull
    private String passengerName;

    @NotNull
    private String passengerContactNumber;

    @JsonDeserialize(using = OffsetDateTimeModule.CustomOffsetDateTimeDeserializer.class)
    private OffsetDateTime pickupTime;

    private Boolean asap = true;

    private Integer waitingTime;

    @NotNull
    private Integer noOfPassengers;

    @NotNull
    private BigDecimal price;

    private Integer rating;

    private List<ApiTripWaypoint> tripWayPoints;
}
