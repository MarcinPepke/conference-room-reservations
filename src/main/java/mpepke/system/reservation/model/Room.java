package mpepke.system.reservation.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder(toBuilder = true)
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    @Column(unique = true)
    private int roomNumber;
    private int capacity;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "layout_id")
    private Layout layout;

    @ManyToMany(mappedBy = "rooms")
    @JsonIgnore
    private Set<Booking> bookings = new HashSet<>();

}
