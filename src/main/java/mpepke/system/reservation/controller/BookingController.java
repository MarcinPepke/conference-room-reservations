package mpepke.system.reservation.controller;

import lombok.RequiredArgsConstructor;
import mpepke.system.reservation.controller.request.BookingRequest;
import mpepke.system.reservation.model.Booking;
import mpepke.system.reservation.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;


    @PostMapping()
    private ResponseEntity<Booking> addReservation(@RequestBody BookingRequest request) throws Exception {
        Booking reservation = bookingService.addNewBooking(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(reservation);

    }

    @GetMapping("/{userId}")
    private ResponseEntity<List<Booking>> getUserBookings(@PathVariable String userId) {
        List<Booking> allUserReservations = bookingService.getAllUserReservations(Long.valueOf(userId));
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(allUserReservations);
    }
    @GetMapping("/room/{roomId}")
    private ResponseEntity<List<Booking>> getAllRoomReservations(@PathVariable String roomId){
        List<Booking> allRoomBookings = bookingService.getAllRoomBookings(Long.valueOf(roomId));
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(allRoomBookings);
    }
}
