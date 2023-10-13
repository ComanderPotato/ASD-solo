package CarBooking.Model;
import java.io.Serializable;
import java.util.ArrayList;

public class CarSpot implements Serializable {
    private int id;
    private int addressId;
    private String location;
    private double price;
    private ArrayList<BookedDates> bookedDates;

    public CarSpot(int id, int addressId, double price, ArrayList<BookedDates> bookedDates) {
        this.id = id;
        this.addressId = addressId;
        this.price = price;
        this.bookedDates = bookedDates;
    }

    public CarSpot(int id, int addressId, double price) {
        this.id = id;
        this.addressId = addressId;
        this.price = price;
    }

    public CarSpot(int addressId, double price) {
        this.addressId = addressId;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<BookedDates> getBookedDates() {
        return bookedDates;
    }

    public void setBookedDates(ArrayList<BookedDates> bookedDates) {
        this.bookedDates = bookedDates;
    }
}
