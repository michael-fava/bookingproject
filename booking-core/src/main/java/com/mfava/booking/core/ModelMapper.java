package com.mfava.booking.core;

import com.mfava.booking.contract.BookingDTO;
import com.mfava.booking.contract.TripWaypointDTO;
import com.mfava.booking.core.data.dao.BookingDAO;
import com.mfava.booking.core.data.dao.TripWaypointDAO;
import lombok.Getter;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

/**
 * @author michaelfava
 */
@Component
public class ModelMapper extends ConfigurableMapper {


    @Getter
    private MapperFactory mapperFactory;

    @Override
    protected void configure(MapperFactory mapperFactory) {
        super.configure(mapperFactory);
        this.mapperFactory = mapperFactory;
        mapperFactory.classMap(BookingDTO.class, BookingDAO.class)/*.customize(
                new CustomMapper<BookingDTO, BookingDAO>() {
                    @Override
                    public void mapAtoB(BookingDTO bookingDTO, BookingDAO bookingDAO, MappingContext context) {
                        bookingDAO.setTripWayPoints(mapAsList(bookingDTO.getTripWayPoints(), TripWaypointDAO.class));
                    }
                }
        )*/.byDefault().register();
        mapperFactory.classMap(TripWaypointDTO.class, TripWaypointDAO.class).byDefault().register();
    }
}