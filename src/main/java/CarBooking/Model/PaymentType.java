package CarBooking.Model;

import java.io.Serializable;

public class PaymentType implements Serializable {
    private int id;
    private String type;

    public PaymentType(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public PaymentType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
