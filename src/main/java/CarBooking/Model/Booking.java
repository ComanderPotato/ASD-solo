package CarBooking.Model;
import CarBooking.Controller.Formatter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Booking implements Serializable {
    private int id;
    private int userId;
    private int carSpotID;
    private int paymentID;
    private double total;
    private LocalDate arrivalDate;
    private LocalTime arrivalTime;
    private LocalDate exitDate;
    private LocalTime exitTime;
    private LocalDateTime dateBooked;

    public Booking(int id, int userId, int carSpotID, int paymentID, double total, LocalDate arrivalDate, LocalTime arrivalTime, LocalDate exitDate, LocalTime exitTime, LocalDateTime dateBooked) {
        this.id = id;
        this.userId = userId;
        this.carSpotID = carSpotID;
        this.paymentID = paymentID;
        this.total = total;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.exitDate = exitDate;
        this.exitTime = exitTime;
        this.dateBooked = dateBooked;
    }

    public Booking(int userId, int carSpotID, int paymentID, double total, LocalDate arrivalDate, LocalTime arrivalTime, LocalDate exitDate, LocalTime exitTime, LocalDateTime dateBooked) {
        this.userId = userId;
        this.carSpotID = carSpotID;
        this.paymentID = paymentID;
        this.total = total;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.exitDate = exitDate;
        this.exitTime = exitTime;
        this.dateBooked = dateBooked;
    }

    public Booking(double total, LocalDate arrivalDate, LocalTime arrivalTime, LocalDate exitDate, LocalTime exitTime, LocalDateTime dateBooked) {
        this.total = total;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.exitDate = exitDate;
        this.exitTime = exitTime;
        this.dateBooked = dateBooked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCarSpotID() {
        return carSpotID;
    }

    public void setCarSpotID(int carSpotID) {
        this.carSpotID = carSpotID;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }
    public String getArrivalDateAsString() {
        return Formatter.formatDate(arrivalDate);
    }


    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }
    public String getarrivalTimeAsString() {
        return Formatter.formatTime(arrivalTime);
    }


    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalDate getExitDate() {
        return exitDate;
    }
    public String getExitDateAsString() {
        return Formatter.formatDate(exitDate);
    }
    public void setExitDate(LocalDate exitDate) {
        this.exitDate = exitDate;
    }

    public LocalTime getExitTime() {
        return exitTime;
    }
    public String getExitTimeAsString() {
        return Formatter.formatTime(exitTime);
    }


    public void setExitTime(LocalTime exitTime) {
        this.exitTime = exitTime;
    }

    public LocalDateTime getDateBooked() {
        return dateBooked;
    }
    public String getDateBookedAsString() {
        return Formatter.formatDateTime(dateBooked);
    }
    public void setDateBooked(LocalDateTime dateBooked) {
        this.dateBooked = dateBooked;
    }
}
