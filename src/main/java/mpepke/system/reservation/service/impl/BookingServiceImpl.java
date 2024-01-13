package mpepke.system.reservation.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mpepke.system.reservation.controller.request.BookingRequest;
import mpepke.system.reservation.model.Booking;
import mpepke.system.reservation.model.Room;
import mpepke.system.reservation.model.UserApp;
import mpepke.system.reservation.repository.BookingRepository;
import mpepke.system.reservation.repository.RoomRepository;
import mpepke.system.reservation.repository.UserAppRepository;
import mpepke.system.reservation.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
public class BookingServiceImpl implements BookingService {

    private final UserAppRepository userAppRepository;
    private final RoomRepository roomRepository;
    private final BookingRepository bookingRepository;

    @Override
    public Booking addNewBooking(BookingRequest bookingRequest) throws Exception {
        Room room = roomRepository.findById(bookingRequest.getRoomId())
                .orElseThrow(Exception::new); // add exception RoomNotFound

        UserApp userApp = userAppRepository.findById(bookingRequest.getUserId())
                .orElseThrow(Exception::new); // add exception UserNotFound

        Booking bookingToAdd = new Booking();

        if (bookingToAdd.getRooms().isEmpty()) {
            Set<Room> rooms = new HashSet<>();
            rooms.add(room);
            bookingToAdd.setRooms(rooms);
        } else {
            bookingToAdd.getRooms().add(room);
        }

        if (bookingToAdd.getUsers().isEmpty()) {
            Set<UserApp> userApps = new HashSet<>();
            userApps.add(userApp);
            bookingToAdd.setUsers(userApps);
        } else {
            bookingToAdd.getUsers().add(userApp);
        }

        bookingToAdd.setTotalHourBooked(bookingRequest.getTotalTimeBooked());
        bookingToAdd.setDateEnd(bookingRequest.getDateEnd());
        bookingToAdd.setDateStart(bookingRequest.getDateStart());

        return bookingRepository.save(bookingToAdd);
    }

    @Override
    public List<Booking> getAllUserReservations(Long userId) {
        return bookingRepository.findByUsers_Id(userId);
    }

    @Override
    public List<Booking> getAllRoomBookings(Long roomId) {
        return bookingRepository.findByRooms_Id(roomId);
    }
}
