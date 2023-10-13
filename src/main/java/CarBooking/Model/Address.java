package CarBooking.Model;

import java.io.Serializable;

public class Address implements Serializable {
    private int id;
    private int stateId;
    private String unitNumber;
    private String streetNumber;
    private String addressLine;
    private String suburb;
    private String city;
    private String postCode;

    public Address(int id, int stateId, String unitNumber, String streetNumber, String addressLine, String suburb, String city, String postCode) {
        this.id = id;
        this.stateId = stateId;
        this.unitNumber = unitNumber;
        this.streetNumber = streetNumber;
        this.addressLine = addressLine;
        this.suburb = suburb;
        this.city = city;
        this.postCode = postCode;
    }

    public Address(int stateId, String unitNumber, String streetNumber, String addressLine, String suburb, String city, String postCode) {
        this.stateId = stateId;
        this.unitNumber = unitNumber;
        this.streetNumber = streetNumber;
        this.addressLine = addressLine;
        this.suburb = suburb;
        this.city = city;
        this.postCode = postCode;
    }

    public Address(String unitNumber, String streetNumber, String addressLine, String suburb, String city, String postCode) {
        this.unitNumber = unitNumber;
        this.streetNumber = streetNumber;
        this.addressLine = addressLine;
        this.suburb = suburb;
        this.city = city;
        this.postCode = postCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
