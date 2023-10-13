package CarBooking.Model.dao;


import CarBooking.Model.BookedDates;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
    public ArrayList<BookedDates> queryBookingsWithId(int id) throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM BOOKINGDATES WHERE ID = ?");
        prepStmt.setInt(1, id);
        rs = prepStmt.executeQuery();
        ArrayList<BookedDates> bookings = new ArrayList<>();
        while(rs.next()) {
            DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm");
            LocalDate bookedDate = LocalDate.parse(rs.getString(3), formatDate);
            LocalTime bookedTime = LocalTime.parse(rs.getString(4), formatTime);
            bookings.add(new BookedDates(
                    rs.getInt(1),
                    rs.getInt(2),
                    bookedDate, bookedTime));
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
