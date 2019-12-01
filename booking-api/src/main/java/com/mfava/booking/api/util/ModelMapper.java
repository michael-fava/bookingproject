package com.mfava.booking.api.util;

import com.mfava.booking.api.dto.ApiBookingRequest;
import com.mfava.booking.api.dto.ApiTripWaypoint;
import com.mfava.booking.contract.BookingDTO;
import com.mfava.booking.contract.TripWaypointDTO;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author michaelfava
 */
@Component
@Slf4j
public class ModelMapper extends ConfigurableMapper {


    @Getter
    private MapperFactory mapperFactory;

    @Override
    protected void configure(MapperFactory mapperFactory) {
        super.configure(mapperFactory);
        this.mapperFactory = mapperFactory;
        mapperFactory.classMap(ApiBookingRequest.class, BookingDTO.class).byDefault().register();
        mapperFactory.classMap(ApiTripWaypoint.class, TripWaypointDTO.class).byDefault().register();
    }
}
