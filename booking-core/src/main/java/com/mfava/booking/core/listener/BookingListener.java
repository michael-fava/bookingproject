package com.mfava.booking.core.listener;

import com.mfava.booking.contract.BookingDTO;
import com.mfava.booking.core.ModelMapper;
import com.mfava.booking.core.data.dao.BookingDAO;
import com.mfava.booking.core.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author michaelfava
 */

@Component
@AllArgsConstructor
public class BookingListener {

    BookingService bookingService;

    ModelMapper modelMapper;

    @RabbitListener(queues = "booking-add-queue")
    public BookingDTO addBooking(BookingDTO message, @Header("message-type") String messageType) {
        return modelMapper.map(bookingService.createBooking(modelMapper.map(message, BookingDAO.class)), BookingDTO.class);

    }

    @RabbitListener(queues = "booking-edit-queue")
    public BookingDTO updateBooking(BookingDTO message, @Header("message-type") String messageType) {
        return modelMapper.map(bookingService.modifyBooking(modelMapper.map(message, BookingDAO.class)), BookingDTO.class);
    }

    @RabbitListener(queues = "booking-delete-queue")
    public void deleteBooking(String message, @Header("message-type") String messageType) {
        bookingService.deleteBooking(UUID.fromString(message));
    }


}
