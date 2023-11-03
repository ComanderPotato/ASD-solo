package CarBooking.Model;
import java.io.Serializable;
import java.util.ArrayList;

public class CarSpot implements Serializable {
    private int id;
    private int addressId;
    private String locationName;
    private double price;
    private ArrayList<BookedDates> bookedDates;
    private Address address;
    public CarSpot(int id, Address address, String locationName, double price) {
        this.id = id;
        this.address = address;
        this.locationName = locationName;
        this.price = price;
    }

    public CarSpot(int id, int addressId, String locationName, double price, ArrayList<BookedDates> bookedDates) {
        this.id = id;
        this.addressId = addressId;
        this.locationName = locationName;
        this.price = price;
        this.bookedDates = bookedDates;
    }

    public CarSpot(int id, int addressId, String locationName, double price) {
        this.id = id;
        this.addressId = addressId;
        this.locationName = locationName;
        this.price = price;
    }

    public CarSpot(int addressId, String locationName, double price) {
        this.addressId = addressId;
        this.locationName = locationName;
        this.price = price;
    }
    public CarSpot(String locationName, double price) {
        this.locationName = locationName;
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

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
