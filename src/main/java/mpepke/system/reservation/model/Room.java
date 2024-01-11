package mpepke.system.reservation.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

   private String name;
   private int roomNumber;
   private int capacity;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "layout_id")
    private Layout layout;

}
