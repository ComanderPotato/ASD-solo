package CarBooking.Model.dao;

import CarBooking.Model.Booking;
import CarBooking.Controller.Formatter;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BookingDBManager {
    private Statement stmt;
    private PreparedStatement prepStmt;
    private Connection conn;
    ResultSet rs;
    public BookingDBManager(Connection conn) throws SQLException {
        stmt = conn.createStatement();
        this.conn = conn;
    }
    public void addBooking(Booking booking) throws SQLException {
        prepStmt = conn.prepareStatement("INSERT INTO BOOKING " +
                "(USERID, CARSPOTID, PAYMENTID, TOTAL, ARRIVALDATE, ARRIVALTIME, EXITDATE, EXITTIME, DATEBOOKED)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        prepStmt.setInt(1, booking.getUserId());
        prepStmt.setInt(2, booking.getCarSpotID());
        prepStmt.setInt(3, booking.getPaymentID());
        prepStmt.setDouble(4, booking.getTotal());
        prepStmt.setString(5, booking.getArrivalDateAsString());
        prepStmt.setString(6, booking.getExitTimeAsString());
        prepStmt.setString(7, booking.getExitDateAsString());
        prepStmt.setString(8, booking.getExitTimeAsString());
        prepStmt.setString(9, booking.getDateBookedAsString());
        prepStmt.executeUpdate();
    }
    public void removeBooking(int ID) throws SQLException {
        prepStmt = conn.prepareStatement("DELETE FROM BOOKING WHERE ID = ?");
        prepStmt.setInt(1, ID);
        prepStmt.executeUpdate();
    }
    public void updateBooking(Booking booking) throws SQLException {
        prepStmt = conn.prepareStatement("UPDATE BOOKING " +
                "SET TOTAL = ?, ARRIVALDATE = ?, ARRIVALTIME = ?, EXITDATE = ?, EXITTIME = ?" +
                "WHERE ID = ?");
        prepStmt.setDouble(1, booking.getTotal());
        prepStmt.setString(2, booking.getArrivalDateAsString());
        prepStmt.setString(3, booking.getarrivalTimeAsString());
        prepStmt.setString(4, booking.getExitDateAsString());
        prepStmt.setString(5, booking.getExitTimeAsString());
        prepStmt.setInt(6, booking.getId());
        prepStmt.executeUpdate();
    }
    public ArrayList<Booking> queryBookingsByUserID(int userId) throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM BOOKING WHERE USERID = ?");
        prepStmt.setInt(1, userId);
        ArrayList<Booking> bookings = new ArrayList<>();
        rs = prepStmt.executeQuery();
        while(rs.next()) {
            bookings.add(new Booking(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getDouble(5),
                    Formatter.parseDate(rs.getString(6)),
                    Formatter.parseTime(rs.getString(7)),
                    Formatter.parseDate(rs.getString(8)),
                    Formatter.parseTime(rs.getString(9)),
                    Formatter.parseDateTime(rs.getString(10))));
        }
        return bookings;
    }
    public ArrayList<Booking> queryBookings() throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM BOOKING");
        rs = prepStmt.executeQuery();
        ArrayList<Booking> bookings = new ArrayList<>();
        while(rs.next()) {
            bookings.add(new Booking(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getDouble(5),
                    Formatter.parseDate(rs.getString(6)),
                    Formatter.parseTime(rs.getString(7)),
                    Formatter.parseDate(rs.getString(8)),
                    Formatter.parseTime(rs.getString(9)),
                    Formatter.parseDateTime(rs.getString(10))));
        }
        return bookings;
    }
    public void resetBookingDB() throws SQLException {
        stmt.executeUpdate("DROP TABLE BOOKING");
        stmt.executeUpdate("CREATE TABLE \"Booking\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL UNIQUE,\n" +
                "\t\"userId\"\tINTEGER,\n" +
                "\t\"carSpotId\"\tINTEGER NOT NULL,\n" +
                "\t\"paymentId\"\tINTEGER NOT NULL,\n" +
                "\t\"total\"\tNUMERIC,\n" +
                "\t\"arrivalDate\"\tTEXT,\n" +
                "\t\"arrivalTime\"\tTEXT,\n" +
                "\t\"exitDate\"\tTEXT,\n" +
                "\t\"exitTime\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"id\" AUTOINCREMENT),\n" +
                "\tFOREIGN KEY(\"carSpotId\") REFERENCES \"CarSpot\"(\"id\")\n" +
                ");");
    }
}
