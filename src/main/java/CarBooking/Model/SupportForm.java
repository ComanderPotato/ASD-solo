package CarBooking.Model;

import java.io.Serializable;

public class SupportForm implements Serializable {
    private int id;
    private int userId;
    private String email;
    private String message;
    private User user;
    public SupportForm(int id, User user, String email, String message) {
        this.id = id;
        this.user = user;
        this.email = email;
        this.message = message;
    }
    public SupportForm(int id, int userId, String email, String message) {
        this.id = id;
        this.userId = userId;
        this.email = email;
        this.message = message;
    }

    public SupportForm(int userId, String email, String message) {
        this.userId = userId;
        this.email = email;
        this.message = message;
    }

    public SupportForm(String email, String message) {
        this.email = email;
        this.message = message;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
