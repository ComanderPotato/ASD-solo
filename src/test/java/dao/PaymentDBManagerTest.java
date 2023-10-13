package dao;

import CarBooking.Model.Payment;
import CarBooking.Model.User;
import CarBooking.Model.dao.PaymentDBManager;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PaymentDBManagerTest {
    TestDBConnector db;
    PaymentDBManager paymentDBManager;

    ArrayList<Payment> paymentList = new ArrayList<>();
    Payment paymentOne = new Payment(
            1,
            1,
            "Tom Golding",
            "1234444492311283",
            "14/24",
            "343"
    );
    Payment paymentTwo = new Payment(
            1,
            1,
            "Tom Golding",
            "1234444492314323",
            "14/25",
            "342"
    );
    Payment paymentThree = new Payment(
            2,
            2,
            "Tom Becker",
            "1234444492311232",
            "10/25",
            "399"
    );


    {
        try {
            db = new TestDBConnector();
            paymentDBManager = new PaymentDBManager(db.conn);
            paymentList.add(paymentOne);
            paymentList.add(paymentTwo);
            paymentList.add(paymentThree);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void addPayment() {
        try {
            paymentDBManager.resetPaymentDB();
            for(Payment payment : paymentList) {
                paymentDBManager.addPayment(payment);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void removePayment() {
        try {

        Payment testPayment = new Payment(
                3,
                1,
                "Bob Golding",
                "1234444492311283",
                "14/24",
                "343"
        );
        paymentDBManager.addPayment(testPayment);
        ArrayList<Payment> testQuery = paymentDBManager.queryPayments(3);
        assertNotNull(testQuery.get(0));
        paymentDBManager.removePayment(testQuery.get(0).getId());
        ArrayList<Payment> deletedPayment = paymentDBManager.queryPayments(3);
        assertEquals(deletedPayment.size(), 0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void queryPayments() {
        try {
        ArrayList<Payment> queriedPayments = paymentDBManager.queryPayments(2);
        assertEquals(queriedPayments.get(0).getPaymentTypeId(), paymentThree.getPaymentTypeId());
        assertEquals(queriedPayments.get(0).getName(), paymentThree.getName());
        assertEquals(queriedPayments.get(0).getNumber(), paymentThree.getNumber());
        assertEquals(queriedPayments.get(0).getExpiry(), paymentThree.getExpiry());
        assertEquals(queriedPayments.get(0).getCvv(), paymentThree.getCvv());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void updatePayment() {
        try {
            String newName = "Tom Golding";
            ArrayList<Payment> queriedPayments = paymentDBManager.queryPayments(1);
            for(Payment payment : queriedPayments) {
                payment.setName(newName);
                paymentDBManager.updatePayment(payment);
            }
            ArrayList<Payment> updatedPayments = paymentDBManager.queryPayments(1);
            for(Payment payment : queriedPayments) {
                assertEquals(payment.getName(), newName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}