package CarBooking.Model;

import java.io.Serializable;

public class State implements Serializable {
    private int id;
    private String state;

    public State(int id, String state) {
        this.id = id;
        this.state = state;
    }

    public State(String state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
