package mpepke.system.reservation.model;

import jakarta.persistence.*;

import lombok.Data;

import java.sql.Time;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id", nullable = false)
    private Long id;

    private Time dateStart;
    private Time dateEnd;
    private float totalHourBooked;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToMany
    @JoinTable(name = "Booking_users",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<UserApp> users = new LinkedHashSet<>();

}
