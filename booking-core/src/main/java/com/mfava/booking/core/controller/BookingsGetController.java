package com.mfava.booking.core.controller;

import com.mfava.booking.contract.BookingDTO;
import com.mfava.booking.core.ModelMapper;
import com.mfava.booking.core.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * @author michaelfava
 */

@RestController
@RequestMapping(value = "/bookingscore/bookings")
@AllArgsConstructor
public class BookingsGetController {

    BookingService bookingService;

    ModelMapper modelMapper;


    @GetMapping(value = "/")
    public List<BookingDTO> getAllBookings(){
        return modelMapper.mapAsList(bookingService.getAllBookings(), BookingDTO.class);
    }

    @GetMapping(value = "/{id}")
    public BookingDTO getBookingById(@PathVariable String id){
        return modelMapper.map(bookingService.getBookingById(UUID.fromString(id)), BookingDTO.class);
    }

}
