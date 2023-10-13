package CarBooking.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class BookedDates implements Serializable {
    private int id;
    private int carSpotId;
    private LocalDate date;
    private LocalTime time;

    public BookedDates(int id, int carSpotId, LocalDate date, LocalTime time) {
        this.id = id;
        this.carSpotId = carSpotId;
        this.date = date;
        this.time = time;
    }

    public BookedDates(int carSpotId, LocalDate date, LocalTime time) {
        this.carSpotId = carSpotId;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarSpotId() {
        return carSpotId;
    }

    public void setCarSpotId(int carSpotId) {
        this.carSpotId = carSpotId;
    }

    public LocalDate getDate() {
        return date;
    }
    public String getDateAsString() { return date.toString(); }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }
    public String getTimeAsString() { return time.toString(); }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
