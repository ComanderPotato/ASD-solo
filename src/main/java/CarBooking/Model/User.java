package CarBooking.Model;

import java.time.LocalDate;

public class User {
    private int id;
    private int subscriptionTypeId;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate DOB;
    private String phoneNumber;
    private boolean isAdmin;
    public User(int id, int subscriptionTypeId, String email, String password, String firstName, String lastName, LocalDate DOB, String phoneNumber, boolean isAdmin) {
        this.id = id;
        this.subscriptionTypeId = subscriptionTypeId;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.phoneNumber = phoneNumber;
        this.isAdmin = isAdmin;
    }
    public User(int subscriptionTypeId, String email, String password, String firstName, String lastName, LocalDate DOB, String phoneNumber, boolean isAdmin) {
        this.subscriptionTypeId = subscriptionTypeId;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.phoneNumber = phoneNumber;
        this.isAdmin = isAdmin;
    }

    public User(String email, String password, String firstName, String lastName, LocalDate DOB, String phoneNumber, boolean isAdmin) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.phoneNumber = phoneNumber;
        this.isAdmin = isAdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubscriptionTypeId() {
        return subscriptionTypeId;
    }

    public void setSubscriptionTypeId(int subscriptionTypeId) {
        this.subscriptionTypeId = subscriptionTypeId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDOB() {
        return DOB;
    }
    public String getDOBAsString() { return DOB.toString(); }
    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
