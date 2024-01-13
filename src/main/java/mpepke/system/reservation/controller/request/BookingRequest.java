package mpepke.system.reservation.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequest {


    @DateTimeFormat(pattern = "dd:MM:yyyy HH:mm")
    private Date dateStart;
    @DateTimeFormat(pattern = "dd:MM:yyyy HH:mm")
    private Date dateEnd;
    private float totalTimeBooked;
    private Long roomId;
    private Long userId;

}
