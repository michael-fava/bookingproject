package com.mfava.booking.api.service;

import com.mfava.booking.api.dto.ApiBooking;
import com.mfava.booking.api.dto.ApiBookingRequest;
import com.mfava.booking.api.dto.ApiBookingUpdateRequest;
import com.mfava.booking.api.integration.BookingCoreFeignClient;
import com.mfava.booking.api.integration.QueueProducer;
import com.mfava.booking.api.util.ModelMapper;
import com.mfava.booking.contract.BookingDTO;
import com.mfava.booking.contract.enums.OperationType;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author michaelfava
 */
@Slf4j
@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    private static final String RABBITMQ_REPLY_TO_CONSTANT = "amq.rabbitmq.reply-to";
    private static final String MESSAGE_TYPE = "message-type";
    private static final String REPLY_TO = "reply-to";

    ModelMapper modelMapper;

    QueueProducer queueProducer;

    BookingCoreFeignClient bookingCoreFeignClient;

    @Override
    public List<ApiBooking> getBookings() {
        return modelMapper.mapAsList(bookingCoreFeignClient.getAllBookings(), ApiBooking.class);
    }

    @Override
    public ApiBooking getBookingById(String id) {
        return modelMapper.map(bookingCoreFeignClient.getBookingById(id), ApiBooking.class);
    }

    @Override
    public ApiBooking createBooking(ApiBookingRequest request) {
        return modelMapper.map(queueProducer.sendMessageGetReply(MessageBuilder.withPayload(modelMapper.map(request, BookingDTO.class))
                .setHeader(MESSAGE_TYPE, OperationType.ADD.getOperationTag())
                .setHeader(REPLY_TO, RABBITMQ_REPLY_TO_CONSTANT)
                .build()), ApiBooking.class);
    }

    @Override
    public ApiBooking updateBooking(ApiBookingUpdateRequest request) {
        return modelMapper.map(queueProducer.sendMessageGetReply(MessageBuilder.withPayload(modelMapper.map(request, BookingDTO.class))
                .setHeader(MESSAGE_TYPE, OperationType.UPDATE.getOperationTag())
                .setHeader(REPLY_TO, RABBITMQ_REPLY_TO_CONSTANT)
                .build()), ApiBooking.class);
    }

    @Override
    public void deleteBooking(String id) {
        queueProducer.sendMessage(MessageBuilder.withPayload(id)
                .setHeader(MESSAGE_TYPE, OperationType.DELETE.getOperationTag())
                .build());
    }
}
