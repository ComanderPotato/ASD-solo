package dao;

import CarBooking.Model.PaymentType;
import CarBooking.Model.State;
import CarBooking.Model.SubscriptionType;
import CarBooking.Model.dao.PaymentDBManager;
import CarBooking.Model.dao.PaymentTypeDBManager;
import CarBooking.Model.dao.StateDBManager;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTypeDBManagerTest {
    TestDBConnector db;
    PaymentTypeDBManager paymentTypeDBManager;
    ArrayList<PaymentType> paymentTypeList = new ArrayList<>();
    PaymentType paymentTypeOne = new PaymentType(
            "Debit"
    );
    PaymentType paymentTypeTwo = new PaymentType(
            "Credit"
    );

    {
        try {
            db = new TestDBConnector();
            paymentTypeDBManager = new PaymentTypeDBManager(db.conn);
            paymentTypeList.add(paymentTypeOne);
            paymentTypeList.add(paymentTypeTwo);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void queryPaymentTypes() {
        try {
            ArrayList<PaymentType> queriedTypes = paymentTypeDBManager.queryPaymentTypes();
            for(int i = 0; i < queriedTypes.size(); i++) {
                assertEquals(queriedTypes.get(i).getType(), paymentTypeList.get(i).getType());
            }
        } catch (SQLException e) {

        }
    }

    @Test
    void getPaymentTypeById() {
        try {
            PaymentType one = paymentTypeDBManager.getPaymentTypeById(1);
            assertEquals(one.getType(), paymentTypeOne.getType());

            PaymentType two = paymentTypeDBManager.getPaymentTypeById(2);
            assertEquals(two.getType(), paymentTypeTwo.getType());

        } catch (SQLException e) {

        }
    }
}