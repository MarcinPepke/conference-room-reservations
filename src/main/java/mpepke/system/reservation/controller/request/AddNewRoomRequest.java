package mpepke.system.reservation.controller.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddNewRoomRequest {

    private String name;
    private int roomNumber;
    private int capacity;
    private AddLayoutRequest layout;


}
