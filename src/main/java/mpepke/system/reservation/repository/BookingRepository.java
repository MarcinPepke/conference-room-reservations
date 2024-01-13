package mpepke.system.reservation.repository;

import mpepke.system.reservation.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query("select b from Booking b inner join b.users users where users.id = ?1")
    List<Booking> findByUsers_Id(Long id);

    @Query("select b from Booking b inner join b.rooms rooms where rooms.id = ?1")
    List<Booking> findByRooms_Id(Long id);


}
