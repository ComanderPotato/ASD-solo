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
                supportFormDBManager.addSupportFormWithId(supportForm);
            }
            db.closeConnection();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void querySupportForms() {
        try {
            ArrayList<SupportForm> queriedForms = supportFormDBManager.querySupportForms();
            assertEquals(queriedForms.size(), supportFormList.size());
            for(int i = 0; i < queriedForms.size(); i++) {
                assertEquals(queriedForms.get(i).getUserId(), supportFormList.get(i).getUserId());
                assertEquals(queriedForms.get(i).getEmail(), supportFormList.get(i).getEmail());
                assertEquals(queriedForms.get(i).getMessage(), supportFormList.get(i).getMessage());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void removeSupportForm() {

    }
    @Test
    void findSupportFormsByEmail() {
        try {
            ArrayList<SupportForm> formsByEmail = supportFormDBManager.findSupportFormsByEmail(supportFormOne.getEmail());
            assertEquals(formsByEmail.get(0).getUserId(), supportFormOne.getUserId());
            assertEquals(formsByEmail.get(0).getEmail(), supportFormOne.getEmail());
            assertEquals(formsByEmail.get(0).getMessage(), supportFormOne.getMessage());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void findSupportFormByUserId() {
//        try {
//            supportFormDBManager.
//        } catch (SQLException e) {
//
//        }
    }

}