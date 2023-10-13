package dao;

import CarBooking.Model.SupportForm;
import CarBooking.Model.User;
import CarBooking.Model.dao.SupportFormDBManager;
import CarBooking.Model.dao.UserDBManager;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SupportFormDBManagerTest {
    TestDBConnector db;
    SupportFormDBManager supportFormDBManager;
    ArrayList<SupportForm> supportFormList = new ArrayList<>();
    SupportForm supportFormOne = new SupportForm(
            1,
            "Tomgolding2012@outlook.com",
            "Help me"
            );
    SupportForm supportFormTwo = new SupportForm(
            2,
            "Tomgolding2013@outlook.com",
            "Help me Please"
    );
    {
        try {
            db = new TestDBConnector();
            supportFormDBManager = new SupportFormDBManager(db.conn);
            supportFormList.add(supportFormOne);
            supportFormList.add(supportFormTwo);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void addSupportForm() {
        try {
            db.openConnection();
            supportFormDBManager.resetSupportFormDB();
            for(SupportForm supportForm : supportFormList) {
                supportFormDBManager.addSupportForm(supportForm);
            }
            db.closeConnection();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void querySupportForms() {

    }

    @Test
    void removeSupportForm() {

    }
    @Test
    void findSupportFormsByEmail() {

    }
    @Test
    void findSupportFormById() {

    }

}