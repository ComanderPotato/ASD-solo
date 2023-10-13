package dao;

import CarBooking.Model.State;
import CarBooking.Model.SubscriptionType;
import CarBooking.Model.dao.StateDBManager;
import CarBooking.Model.dao.SubscriptionTypeDBManager;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StateDBManagerTest {
    TestDBConnector db;
    StateDBManager stateDBManager;
    ArrayList<State> stateList = new ArrayList<>();
    State stateOne = new State(
            "NSW"
    );
    State stateTwo = new State(
            "QLD"
    );
    State stateThree = new State(
            "VIC"
    );
    State stateFour = new State(
            "ACT"
    );
    State stateFive = new State(
            "SA"
    );
    State stateSix = new State(
            "WA"
    );

    {
        try {
            db = new TestDBConnector();
            stateDBManager = new StateDBManager(db.conn);
            stateList.add(stateOne);
            stateList.add(stateTwo);
            stateList.add(stateThree);
            stateList.add(stateFour);
            stateList.add(stateFive);
            stateList.add(stateSix);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void queryStateById() {
        try {
        db.openConnection();
        State one = stateDBManager.queryStateById(1);
        assertEquals(one.getState(), stateOne.getState());
        State two = stateDBManager.queryStateById(2);
        assertEquals(two.getState(), stateTwo.getState());
        State three = stateDBManager.queryStateById(3);
        assertEquals(three.getState(), stateThree.getState());
        State four = stateDBManager.queryStateById(4);
        assertEquals(four.getState(), stateFour.getState());
        State five = stateDBManager.queryStateById(5);
        assertEquals(five.getState(), stateFive.getState());
        State six = stateDBManager.queryStateById(6);
        assertEquals(six.getState(), stateSix.getState());
        db.closeConnection();
        } catch (SQLException e) {

        }

    }

    @Test
    void queryStates() {
        try {
            db.openConnection();
            ArrayList<State> queriedTypes = stateDBManager.queryStates();
            for(int i = 0; i < queriedTypes.size(); i++) {
                assertEquals(queriedTypes.get(i).getState(), stateList.get(i).getState());
            }
            db.closeConnection();
        } catch (SQLException e) {

        }
    }
}