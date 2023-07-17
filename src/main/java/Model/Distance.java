package Model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Distance implements Serializable {
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private Double distance;

    public Distance(LocalDateTime checkIn, LocalDateTime checkOut, Double distance) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.distance = distance;
    }

//    public Distance(LocalDateTime checkIn, LocalDateTime checkOut, double duration) {
//    }


    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
}
