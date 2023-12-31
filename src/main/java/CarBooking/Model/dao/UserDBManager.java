package CarBooking.Model.dao;

import CarBooking.Controller.Formatter;
import CarBooking.Controller.PasswordEncrypterDecrypter;
import CarBooking.Model.User;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class UserDBManager {
    private Statement stmt;
    private PreparedStatement prepStmt;
    private Connection conn;
    ResultSet rs;
    public UserDBManager(Connection conn) throws SQLException {
        stmt = conn.createStatement();
        this.conn = conn;
    }
    // Queries all users within the database.
    public ArrayList<User> queryUsers() throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM USER");
        rs = prepStmt.executeQuery();
        ArrayList<User> users = new ArrayList<>();
        while(rs.next()) {
            String decryptedPw = null;
            try {
                decryptedPw = PasswordEncrypterDecrypter.decrypt(rs.getString(4));
            } catch (Exception e) {

            }
            users.add(new User(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    decryptedPw,
                    rs.getString(5),
                    rs.getString(6),
                    Formatter.parseDob(rs.getString(7)),
                    rs.getString(8),
                    rs.getBoolean(9)));
        }
        return users;
    }
    // Checks if the user exists based on the input email, and password.
    public boolean authenticateUser(String email, String password) throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM USER WHERE EMAIL = ? AND PASSWORD = ?");
        prepStmt.setString(1, email);
        prepStmt.setString(2, password);
        rs = prepStmt.executeQuery();

        return rs.next() ? true : false;
    }
    // Checks if a user exists in the database based on the input email.
    public boolean userExists(String email) throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM USER WHERE EMAIL = ?");
        prepStmt.setString(1, email);
        rs = prepStmt.executeQuery();
        return rs.next() ? true : false;
    }
    // Adds the user to the database with necessary fields.
    public void addUser(User user) throws SQLException {
        prepStmt = conn.prepareStatement("INSERT INTO USER " +
                "(EMAIL, PASSWORD, FIRSTNAME, LASTNAME, DOB, PHONENUMBER, ISADMIN)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?)");
        prepStmt.setString(1, user.getEmail());
        prepStmt.setString(2, user.getPassword());
        prepStmt.setString(3, user.getFirstName());
        prepStmt.setString(4, user.getLastName());
        prepStmt.setString(5, user.getDOBAsString());
        prepStmt.setString(6, user.getPhoneNumber());
        prepStmt.setBoolean(7, user.isAdmin());
        prepStmt.executeUpdate();
    }
    public void deleteUser(int ID) throws SQLException {
        prepStmt = conn.prepareStatement("DELETE FROM USER WHERE ID = ?");
        prepStmt.setInt(1, ID);
        prepStmt.executeUpdate();
    }
    // Queries the database user table for users that have the input email and password, and returns the user if
    // // the user exists. else returns null.
    public User findUser(String email, String password) throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM USER WHERE EMAIL = ? AND PASSWORD = ?");
        prepStmt.setString(1, email);
        prepStmt.setString(2, password);

        return getUser();
    }
    // Queries the database user table for users that have the input id, and returns the user if
    // // the user exists. else returns null.
    public User findUserByID(int ID) throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM USER WHERE ID = ?");
        prepStmt.setInt(1, ID);
        return getUser();
    }
    // Queries the database user table for users that have the input email, and returns the user if
    // // the user exists. else returns null.
    public User findUserByEmail(String email) throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM USER WHERE email = ?");
        prepStmt.setString(1, email);
        return getUser();
    }

    // Simple getUser for database information
    private User getUser() throws SQLException {
        rs = prepStmt.executeQuery();
        if(rs.next()) {
            String decryptedPw = null;
            try {
                decryptedPw = PasswordEncrypterDecrypter.decrypt(rs.getString(4));
            } catch (Exception e) {

            }
            return new User(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    decryptedPw,
                    rs.getString(5),
                    rs.getString(6),
                    Formatter.parseDob(rs.getString(7)),
                    rs.getString(8),
                    rs.getBoolean(9));
        }
        return null;
    }
    public void updateUser(User updatedUser) throws SQLException {
        prepStmt = conn.prepareStatement("UPDATE USER " +
                "SET EMAIL = ?, PASSWORD = ?, FIRSTNAME = ?, LASTNAME = ?, DOB = ?, PHONENUMBER = ?" +
                "WHERE ID = ?");
        prepStmt.setString(1, updatedUser.getEmail());
        prepStmt.setString(2, updatedUser.getPassword());
        prepStmt.setString(3, updatedUser.getFirstName());
        prepStmt.setString(4, updatedUser.getLastName());
        prepStmt.setString(5, updatedUser.getDOBAsString());
        prepStmt.setString(6, updatedUser.getPhoneNumber());
        prepStmt.setInt(7, updatedUser.getId());
        prepStmt.executeUpdate();
    }
    public void resetUserDB() throws SQLException {
        stmt.executeUpdate("DROP TABLE USER");
        stmt.executeUpdate("CREATE TABLE \"User\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL UNIQUE,\n" +
                "\t\"subscriptionTypeId\"\tINTEGER DEFAULT 1,\n" +
                "\t\"Email\"\tTEXT NOT NULL UNIQUE,\n" +
                "\t\"Password\"\tTEXT NOT NULL,\n" +
                "\t\"FirstName\"\tTEXT NOT NULL,\n" +
                "\t\"LastName\"\tTEXT NOT NULL,\n" +
                "\t\"DOB\"\tTEXT NOT NULL,\n" +
                "\t\"PhoneNumber\"\tTEXT NOT NULL,\n" +
                "\t\"isAdmin\"\tINTEGER,\n" +
                "\tPRIMARY KEY(\"id\" AUTOINCREMENT)\n" +
                ");");
    }
}
