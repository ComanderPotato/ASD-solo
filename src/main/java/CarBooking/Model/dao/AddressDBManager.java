package CarBooking.Model.dao;

import CarBooking.Model.Address;

import java.sql.*;

public class AddressDBManager {
    private Statement stmt;
    private PreparedStatement prepStmt;
    private Connection conn;
    ResultSet rs;
    public AddressDBManager(Connection conn) throws SQLException {
        stmt = conn.createStatement();
        this.conn = conn;
    }
    public void addAddress(Address address) throws SQLException {
        prepStmt = conn.prepareStatement("INSERT INTO USER " +
                "(COUNTRYID, UNITNUMBER, STREETNUMBER, ADDRESSLINE, CITY, STATE, )" +
                "VALUES (?, ?, ?, ?, ?, ?)");

        prepStmt.executeUpdate();
    }
}
