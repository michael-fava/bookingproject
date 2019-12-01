package com.mfava.booking.core.data.service;

import com.mfava.booking.core.ModelMapper;
import com.mfava.booking.core.data.dao.BookingDAO;
import com.mfava.booking.core.data.dao.TripWaypointDAO;
import com.mfava.booking.core.data.model.Booking;
import com.mfava.booking.core.data.model.TripWaypoint;
import com.mfava.booking.core.data.repo.BookingRepository;
import com.mfava.booking.core.data.repo.TripWaypointRepository;
import com.mfava.booking.core.exception.BookingNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author michaelfava
 */
@Slf4j
@Service
@AllArgsConstructor
public class BookingDataServiceImpl implements BookingDataService {

    BookingRepository bookingRepository;

    TripWaypointRepository tripWaypointRepository;

    ModelMapper modelMapper;

    @Override
    @Transactional
    public BookingDAO createBooking(BookingDAO bookingDAO) {
        final Booking savedBooking = bookingRepository.save(modelMapper.map(bookingDAO, Booking.class));
        return modelMapper.map(savedBooking, BookingDAO.class);
    }

    @Override
    public BookingDAO modifyBooking(BookingDAO bookingDAO) {
        Optional<Booking> originalBooking = bookingRepository.findByBookingIdAndDeletedFalse(bookingDAO.getBookingId());
        if (originalBooking.isPresent()) {
            Booking bookingtoSave = updateBookingInstance(originalBooking.get(), bookingDAO);
            return modelMapper.map(bookingRepository.save(bookingtoSave), BookingDAO.class);
        }
        throw new BookingNotFoundException(bookingDAO.getBookingId());
    }

    @Override
    public void deleteBooking(UUID bookingId) {
        bookingRepository.findByBookingIdAndDeletedFalse(bookingId).ifPresent(booking -> {
            booking.setDeleted(Boolean.TRUE);
            bookingRepository.save(booking);
        });
    }

    @Override
    public BookingDAO getBooking(UUID id) throws BookingNotFoundException{
        return modelMapper.map(bookingRepository.findByBookingIdAndDeletedFalse(id)
                                    .orElseThrow(() -> new BookingNotFoundException(id)), BookingDAO.class);
    }

    @Override
    public List<BookingDAO> getAllBookings() {
        return modelMapper.mapAsList(bookingRepository.findAllByDeletedFalse(), BookingDAO.class);
    }


    @Override
    public List<TripWaypointDAO> getBookingTripWayPoints(UUID id) {
        final Optional<Booking> booking = bookingRepository.findByBookingIdAndDeletedFalse(id);
        return booking.stream()
                .map(Booking::getTripWayPoints)
                .flatMap(List::stream)
                .map(tripWaypoint -> modelMapper.map(tripWaypoint ,TripWaypointDAO.class))
                .collect(Collectors.toList());
    }

    private Booking updateBookingInstance(Booking originalBooking, BookingDAO bookingDAO) {
        return Booking.builder()
                .bookingId(originalBooking.getBookingId())
                .passengerName(StringUtils.isNotBlank(bookingDAO.getPassengerName()) ? bookingDAO.getPassengerName() : originalBooking.getPassengerName())
                .passengerContactNumber(StringUtils.isNumeric(bookingDAO.getPassengerContactNumber()) ? bookingDAO.getPassengerContactNumber() : originalBooking.getPassengerContactNumber())
                .pickupTime(Objects.nonNull(bookingDAO.getPickupTime()) ? bookingDAO.getPickupTime() : originalBooking.getPickupTime())
                .asap(Objects.nonNull(bookingDAO.getAsap()) ? bookingDAO.getAsap() : originalBooking.getAsap())
                .waitingTime(Objects.nonNull(bookingDAO.getWaitingTime()) ? bookingDAO.getWaitingTime() : originalBooking.getWaitingTime())
                .noOfPassengers(Objects.nonNull(bookingDAO.getNoOfPassengers()) ? bookingDAO.getNoOfPassengers() : originalBooking.getNoOfPassengers())
                .price(Objects.nonNull(bookingDAO.getPrice()) ? bookingDAO.getPrice() : originalBooking.getPrice())
                .rating(Objects.nonNull(bookingDAO.getRating()) ? bookingDAO.getRating() : originalBooking.getRating())
                .lastModifiedOn(Instant.now())
                .tripWayPoints(!bookingDAO.getTripWayPoints().isEmpty() ? modelMapper.mapAsList(bookingDAO.getTripWayPoints(), TripWaypoint.class) : originalBooking.getTripWayPoints())
                .deleted(originalBooking.isDeleted())
                .createdOn(originalBooking.getCreatedOn())
                .build();
    }
}
