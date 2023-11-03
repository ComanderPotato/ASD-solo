package CarBooking.Model.dao;

import CarBooking.Model.Address;
import CarBooking.Model.User;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddressDBManager {
    private Statement stmt;
    private PreparedStatement prepStmt;
    private Connection conn;
    ResultSet rs;
    public AddressDBManager(Connection conn) throws SQLException {
        stmt = conn.createStatement();
        this.conn = conn;
    }
    public int addAddress(Address address) throws SQLException {
        prepStmt = conn.prepareStatement("INSERT INTO ADDRESS " +
                "(STATEID, STREETNUMBER, ADDRESSLINE, SUBURB, CITY, POSTCODE)" +
                "VALUES (?, ?, ?, ?, ?, ?)");
        prepStmt.setInt(1, address.getStateId());
        prepStmt.setString(2, address.getStreetNumber());
        prepStmt.setString(3, address.getAddressLine());
        prepStmt.setString(4, address.getSuburb());
        prepStmt.setString(5, address.getCity());
        prepStmt.setString(6, address.getPostCode());
        prepStmt.executeUpdate();
        rs = prepStmt.getGeneratedKeys();
        return rs.getInt(1);
    }
    public Address queryAddressById(int id) throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM ADDRESS WHERE ID = ?");
        prepStmt.setInt(1, id);
        rs = prepStmt.executeQuery();
        if(rs.next()) {
            return new Address(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7));
        }
        return null;
    }
}
