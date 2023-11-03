package CarBooking.Model;

import CarBooking.Controller.Formatter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class BookedDates implements Serializable {
    private int id;
    private int carSpotId;
    private LocalDate date;

    public BookedDates(int id, int carSpotId, LocalDate date) {
        this.id = id;
        this.carSpotId = carSpotId;
        this.date = date;
    }

    public BookedDates(int carSpotId, LocalDate date) {
        this.carSpotId = carSpotId;
        this.date = date;
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
    public String getDateAsString() {
        return Formatter.formatDate(date);
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
