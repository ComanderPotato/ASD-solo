package CarBooking.Model.dao;


import CarBooking.Controller.Formatter;
import CarBooking.Model.BookedDates;

import java.sql.*;
import java.util.ArrayList;

public class BookedDatesDBManager {
    private Statement stmt;
    private PreparedStatement prepStmt;
    private Connection conn;
    ResultSet rs;
    public BookedDatesDBManager(Connection conn) throws SQLException {
        stmt = conn.createStatement();
        this.conn = conn;
    }
    public void addBookedDates(BookedDates bookedDate) throws SQLException {
        prepStmt = conn.prepareStatement("DELETE FROM BOOKEDDATES WHERE ID = ?");
//        prepStmt.setInt(1, id);
    }
    public void removeBookedDates(int id) throws SQLException {
        prepStmt = conn.prepareStatement("DELETE FROM BOOKEDDATES WHERE ID = ?");
        prepStmt.setInt(1, id);
        prepStmt.executeUpdate();
    }
    public ArrayList<BookedDates> queryBookingsById(int id) throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM BOOKINGDATES WHERE ID = ?");
        prepStmt.setInt(1, id);
        rs = prepStmt.executeQuery();
        ArrayList<BookedDates> bookings = new ArrayList<>();
        while(rs.next()) {

            bookings.add(new BookedDates(
                    rs.getInt(1),
                    rs.getInt(2),
                    Formatter.parseDate(rs.getString(3))));
        }
        return bookings;
    }
    public ArrayList<BookedDates> queryBookingsByCarId(int carId) throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM BOOKEDDATES WHERE CARSPOTID = ?");
        prepStmt.setInt(1, carId);
        rs = prepStmt.executeQuery();
        ArrayList<BookedDates> bookings = new ArrayList<>();
        while(rs.next()) {
            bookings.add(new BookedDates(
                    rs.getInt(1),
                    rs.getInt(2),
                    Formatter.parseDateReverse(rs.getString(3))));
        }
        return bookings;
    }
    public void resetBookingDB() throws SQLException {
        stmt.executeUpdate("DROP TABLE BOOKEDDATES");
        stmt.executeUpdate("CREATE TABLE \"BookedDates\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL UNIQUE,\n" +
                "\t\"carSpotId\"\tINTEGER NOT NULL,\n" +
                "\t\"date\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"id\" AUTOINCREMENT),\n" +
                "\tFOREIGN KEY(\"carSpotId\") REFERENCES \"CarSpot\"(\"id\")\n" +
                ");");
    }
}
