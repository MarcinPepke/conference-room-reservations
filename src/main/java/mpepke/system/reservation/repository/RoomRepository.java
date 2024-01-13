package mpepke.system.reservation.repository;

import mpepke.system.reservation.model.Booking;
import mpepke.system.reservation.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {


    Optional<Room> findByRoomNumber(int roomNumber);

}
