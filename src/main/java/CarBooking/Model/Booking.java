package CarBooking.Model;
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

    public Booking(int id, int userId, int carSpotID, int paymentID, double total, LocalDate arrivalDate, LocalTime arrivalTime, LocalDate exitDate, LocalTime exitTime) {
        this.id = id;
        this.userId = userId;
        this.carSpotID = carSpotID;
        this.paymentID = paymentID;
        this.total = total;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.exitDate = exitDate;
        this.exitTime = exitTime;
    }

    public Booking(int userId, int carSpotID, int paymentID, double total, LocalDate arrivalDate, LocalTime arrivalTime, LocalDate exitDate, LocalTime exitTime) {
        this.userId = userId;
        this.carSpotID = carSpotID;
        this.paymentID = paymentID;
        this.total = total;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.exitDate = exitDate;
        this.exitTime = exitTime;
    }

    public Booking(double total, LocalDate arrivalDate, LocalTime arrivalTime, LocalDate exitDate, LocalTime exitTime) {
        this.total = total;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.exitDate = exitDate;
        this.exitTime = exitTime;
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
    public String getArrivalDateAsString() { return arrivalDate.toString(); }


    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }
    public String getarrivalTimeAsString() { return arrivalTime.toString(); }


    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalDate getExitDate() {
        return exitDate;
    }
    public String getExitDateAsString() { return exitDate.toString(); }
    public void setExitDate(LocalDate exitDate) {
        this.exitDate = exitDate;
    }

    public LocalTime getExitTime() {
        return exitTime;
    }
    public String getExitTimeAsString() { return exitTime.toString(); }


    public void setExitTime(LocalTime exitTime) {
        this.exitTime = exitTime;
    }
}
