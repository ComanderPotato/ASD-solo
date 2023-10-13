package dao;

import CarBooking.Model.SubscriptionType;
import CarBooking.Model.SupportForm;
import CarBooking.Model.dao.SubscriptionTypeDBManager;
import CarBooking.Model.dao.SupportFormDBManager;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SubscriptionTypeDBManagerTest {
    TestDBConnector db;
    SubscriptionTypeDBManager subscriptionTypeDBManager;
    ArrayList<SubscriptionType> subscriptionTypesList = new ArrayList<>();
    SubscriptionType subTypeOne = new SubscriptionType(
            "Standard",
            0
    );
    SubscriptionType subTypeTwo = new SubscriptionType(
            "Premium",
            8.99
    );
    SubscriptionType subTypeThree = new SubscriptionType(
            "Business",
            14.99
    );

    {
        try {
            db = new TestDBConnector();
            subscriptionTypeDBManager = new SubscriptionTypeDBManager(db.conn);
            subscriptionTypesList.add(subTypeOne);
            subscriptionTypesList.add(subTypeTwo);
            subscriptionTypesList.add(subTypeThree);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void querySubscriptionTypeById() {
        try {

        SubscriptionType one = subscriptionTypeDBManager.querySubscriptionTypeById(1);
        assertEquals(one.getType(), subTypeOne.getType());
        assertEquals(one.getPrice(), subTypeOne.getPrice());

        SubscriptionType two = subscriptionTypeDBManager.querySubscriptionTypeById(2);
        assertEquals(two.getType(), subTypeTwo.getType());
        assertEquals(two.getPrice(), subTypeTwo.getPrice());

        SubscriptionType three = subscriptionTypeDBManager.querySubscriptionTypeById(3);
        assertEquals(three.getType(), subTypeThree.getType());
        assertEquals(three.getPrice(), subTypeThree.getPrice());
        } catch (SQLException e) {

        }
    }

    @Test
    void querySubscriptionTypes() {
        try {
            ArrayList<SubscriptionType> queriedTypes = subscriptionTypeDBManager.querySubscriptionTypes();
            for(int i = 0; i < queriedTypes.size(); i++) {
                assertEquals(queriedTypes.get(i).getType(), subscriptionTypesList.get(i).getType());
                assertEquals(queriedTypes.get(i).getPrice(), subscriptionTypesList.get(i).getPrice());
            }
        } catch (SQLException e) {

        }
    }
}