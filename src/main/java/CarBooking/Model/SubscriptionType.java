package CarBooking.Model;

import java.io.Serializable;

public class SubscriptionType implements Serializable {
    private int id;
    private String type;
    private double price;

    public SubscriptionType(int id, String type, double price) {
        this.id = id;
        this.type = type;
        this.price = price;
    }

    public SubscriptionType(String type, double price) {
        this.type = type;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
