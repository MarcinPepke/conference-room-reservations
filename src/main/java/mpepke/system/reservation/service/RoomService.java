package mpepke.system.reservation.service;

import mpepke.system.reservation.controller.request.AddNewRoomRequest;
import mpepke.system.reservation.model.Booking;
import mpepke.system.reservation.model.Room;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RoomService {

    Room addNewRoom(AddNewRoomRequest addNewRoomRequest) throws Exception;


}
