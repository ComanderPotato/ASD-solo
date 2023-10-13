package CarBooking.Model.dao;

import CarBooking.Model.SupportForm;
import CarBooking.Model.User;

import java.sql.*;
import java.util.ArrayList;

public class SupportFormDBManager {
    private Statement stmt;
    private PreparedStatement prepStmt;
    private Connection conn;
    ResultSet rs;
    public SupportFormDBManager(Connection conn) throws SQLException {
        stmt = conn.createStatement();
        this.conn = conn;
    }
    public void addSupportForm(SupportForm supportForm) throws SQLException {
        prepStmt = conn.prepareStatement("INSERT INTO SUPPORTFORM " +
                "(EMAIL, MESSAGE)" +
                "VALUES (?, ?)");
        prepStmt.setString(1, supportForm.getEmail());
        prepStmt.setString(1, supportForm.getMessage());
        prepStmt.executeUpdate();
    }
    public ArrayList<SupportForm> querySupportForms() throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM SUPPORTFORM");
        rs = prepStmt.executeQuery();
        ArrayList<SupportForm> supportForms = new ArrayList<>();
        while(rs.next()) {
            supportForms.add(new SupportForm(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(3)
            ));
        }
        return supportForms;
    }
    public void removeSupportForm(int id) throws SQLException {
        prepStmt = conn.prepareStatement("DELETE FROM SUPPORTFORM WHERE ID = ?");
        prepStmt.setInt(1, id);
        prepStmt.executeUpdate();
    }
    public SupportForm findSupportFormById(int id) throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM SUPPORTFORM WHERE ID = ?");
        prepStmt.setInt(1, id);
        rs = prepStmt.executeQuery();
        if(rs.next()) {
            return new SupportForm(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(3)
            );
        }
        return null;
    }
    public ArrayList<SupportForm> findSupportFormsByEmail(String email) throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM SUPPORTFORM WHERE EMAIL = ?");
        prepStmt.setString(1, email);
        rs = prepStmt.executeQuery();
        ArrayList<SupportForm> supportForms = new ArrayList<>();
        while(rs.next()) {
            supportForms.add(new SupportForm(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(3)
            ));
        }
        return supportForms;
    }

    public void resetSupportFormDB() throws SQLException {
        stmt.executeUpdate("DROP TABLE SUPPORTFORM");
        stmt.executeUpdate("CREATE TABLE \"SupportForm\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL UNIQUE,\n" +
                "\t\"userId\"\tINTEGER NOT NULL,\n" +
                "\t\"email\"\tTEXT,\n" +
                "\t\"message\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"id\" AUTOINCREMENT)\n" +
                ");");
    }
}
