package dao;

import CarBooking.Model.Booking;

import CarBooking.Model.Payment;
import CarBooking.Model.dao.BookingDBManager;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BookingDBManagerTest {
    TestDBConnector db;
    BookingDBManager bookingDBManager;

    ArrayList<Booking> bookingList = new ArrayList<>();
    Booking bookingOne = new Booking(
            1,
            1,
            1,
            14.99,
            LocalDate.of(2024, 3, 13),
            LocalTime.of(10, 15),
            LocalDate.of(2024, 3, 16),
            LocalTime.of(10, 15));
    Booking bookingTwo = new Booking(
            1,
            4,
            1,
            20.99,
            LocalDate.of(2024, 4, 13),
            LocalTime.of(10, 15),
            LocalDate.of(2024, 4, 16),
            LocalTime.of(10, 15));
    Booking bookingThree = new Booking(
            2,
            4,
            1,
            20.99,
            LocalDate.of(2024, 4, 13),
            LocalTime.of(10, 15),
            LocalDate.of(2024, 4, 16),
            LocalTime.of(10, 15));
    {
        try {
            db = new TestDBConnector();
            bookingDBManager = new BookingDBManager(db.conn);
            bookingList.add(bookingOne);
            bookingList.add(bookingTwo);
            bookingList.add(bookingThree);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void addBooking() {
        try {
            bookingDBManager.resetBookingDB();
            for(Booking booking : bookingList) {
                bookingDBManager.addBooking(booking);
            }
            db.closeConnection();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void removeBooking() {
        try {

            Booking testBooking = new Booking(
                    3,
                    4,
                    1,
                    20.99,
                    LocalDate.of(2024, 4, 13),
                    LocalTime.of(10, 15),
                    LocalDate.of(2024, 4, 16),
                    LocalTime.of(10, 15));
            bookingDBManager.addBooking(testBooking);
            ArrayList<Booking> testQuery = bookingDBManager.queryBookingsByUserID(3);
            assertNotNull(testQuery.get(0));
            bookingDBManager.removeBooking(testQuery.get(0).getId());
            ArrayList<Booking> deletedPayment = bookingDBManager.queryBookingsByUserID(3);
            assertEquals(deletedPayment.size(), 0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void updateBooking() {
        try {
        LocalTime newExitTime = LocalTime.of(18, 15);
        ArrayList<Booking> queriedBooking = bookingDBManager.queryBookingsByUserID(2);
        for(Booking booking : queriedBooking) {
            booking.setExitTime(newExitTime);
            bookingDBManager.updateBooking(booking);
        }
        ArrayList<Booking> updatedBookings = bookingDBManager.queryBookingsByUserID(2);
        for(Booking booking : updatedBookings) {
            assertEquals(booking.getExitTime(), newExitTime);
            booking.setExitTime(LocalTime.of(10, 15));
            bookingDBManager.updateBooking(booking);
        }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void queryBookings() {
        try {
        ArrayList<Booking> queriedBookings = bookingDBManager.queryBookings();
        for(int i = 0; i < queriedBookings.size(); i++) {
//            assertEquals(queriedBookings.get(i).getId(), bookingList.get(i).getId());
            assertEquals(queriedBookings.get(i).getUserId(), bookingList.get(i).getUserId());
            assertEquals(queriedBookings.get(i).getPaymentID(), bookingList.get(i).getPaymentID());
            assertEquals(queriedBookings.get(i).getarrivalTimeAsString(), bookingList.get(i).getarrivalTimeAsString());
            assertEquals(queriedBookings.get(i).getArrivalDateAsString(), bookingList.get(i).getArrivalDateAsString());
            assertEquals(queriedBookings.get(i).getExitTimeAsString(), bookingList.get(i).getExitTimeAsString());
            assertEquals(queriedBookings.get(i).getExitDateAsString(), bookingList.get(i).getExitDateAsString());
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}