package mpepke.system.reservation.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mpepke.system.reservation.controller.request.AddNewRoomRequest;
import mpepke.system.reservation.model.Booking;
import mpepke.system.reservation.model.Layout;
import mpepke.system.reservation.model.Room;
import mpepke.system.reservation.repository.LayoutRepository;
import mpepke.system.reservation.repository.RoomRepository;
import mpepke.system.reservation.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RoomServiceImpl implements RoomService {

    private final RoomRepository repository;
    private final LayoutRepository layoutRepository;

    @Override
    public Room addNewRoom(AddNewRoomRequest addNewRoomRequest) throws Exception {
        int roomNumber = addNewRoomRequest.getRoomNumber();
        Room roomToAdd;
        if (repository.findByRoomNumber(roomNumber).isEmpty()) {
            Layout layout = layoutRepository.findByType(addNewRoomRequest.getLayout().getType()).get();
            roomToAdd = Room.builder()
                    .capacity(addNewRoomRequest.getCapacity())
                    .roomNumber(addNewRoomRequest.getRoomNumber())
                    .layout(layout)
                    .name(addNewRoomRequest.getName())
                    .build();
        } else {
            /*
            Dodac exception jezeli istnieje juz taki room number
             */
            throw new Exception();
        }
        return repository.save(roomToAdd);
    }




}
