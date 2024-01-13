package mpepke.system.reservation.service;

import mpepke.system.reservation.controller.request.BookingRequest;
import mpepke.system.reservation.model.Booking;

import java.util.List;


public interface BookingService {

    Booking addNewBooking(BookingRequest bookingRequest) throws Exception;
    List<Booking> getAllUserReservations(Long userId);

    List<Booking> getAllRoomBookings(Long roomId);
}
