package CarBooking.Model;
import java.io.Serializable;

public class Payment implements Serializable {
    private int id;
    private int userId;
    private int paymentTypeId;
    private String name;
    private String number;
    private String expiry;
    private String cvv;

    public Payment(int id, int userId, int paymentTypeId, String name, String number, String expiry, String cvv) {
        this.id = id;
        this.userId = userId;
        this.paymentTypeId = paymentTypeId;
        this.name = name;
        this.number = number;
        this.expiry = expiry;
        this.cvv = cvv;
    }

    public Payment(int userId, int paymentTypeId, String name, String number, String expiry, String cvv) {
        this.userId = userId;
        this.paymentTypeId = paymentTypeId;
        this.name = name;
        this.number = number;
        this.expiry = expiry;
        this.cvv = cvv;
    }
    public Payment(int paymentTypeId, String name, String number, String expiry, String cvv) {
        this.paymentTypeId = paymentTypeId;
        this.name = name;
        this.number = number;
        this.expiry = expiry;
        this.cvv = cvv;
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

    public int getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(int paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
