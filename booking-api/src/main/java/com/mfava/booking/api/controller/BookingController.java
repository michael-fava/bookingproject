package com.mfava.booking.api.controller;

import com.mfava.booking.api.dto.ApiBooking;
import com.mfava.booking.api.dto.ApiBookingRequest;
import com.mfava.booking.api.dto.ApiBookingUpdateRequest;
import com.mfava.booking.api.service.BookingService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author michaelfava
 */
@AllArgsConstructor
@RestController
@RequestMapping(value = "/bookings", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class BookingController {

    BookingService bookingService;

    @ApiOperation(value = "List all bookings")
    @GetMapping
    List<ApiBooking> getBookings(){
        return bookingService.getBookings();
    }

    @ApiOperation(value = "Get a booking by Id")
    @GetMapping(value = "/{id}")
    ApiBooking getBookingById(@PathVariable @NotNull @ApiParam(name = "booking_id") String id){
        return bookingService.getBookingById(id);
    }

    @ApiOperation(value = "Create a new booking", response = ApiBooking.class)
    @PostMapping
    ApiBooking createBooking(@RequestBody @Valid ApiBookingRequest request){
        return bookingService.createBooking(request);
    }

    @ApiOperation(value = "Update a booking", response = ApiBooking.class)
    @PutMapping
    ApiBooking updateBooking(@RequestBody @Valid ApiBookingUpdateRequest request){
        return bookingService.updateBooking(request);
    }

    @ApiOperation(value = "Delete a booking")
    @DeleteMapping(value ="/{id}")
    void deleteBooking(@PathVariable @NotNull @ApiParam(name = "booking_id", type = "UUID") String id){
        bookingService.deleteBooking(id);
    }

}
