package CarBooking.Model.dao;

import CarBooking.Model.PaymentType;
import CarBooking.Model.State;
import CarBooking.Model.User;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class StateDBManager {
    private Statement stmt;
    private PreparedStatement prepStmt;
    private Connection conn;
    ResultSet rs;
    public StateDBManager(Connection conn) throws SQLException {
        stmt = conn.createStatement();
        this.conn = conn;
    }
    public State queryStateById(int id) throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM STATE WHERE ID = ?");
        prepStmt.setInt(1, id);
        rs = prepStmt.executeQuery();
        if(rs.next()) {
            return new State(
                    rs.getInt(1),
                    rs.getString(2));
        }
        return null;
    }
    public ArrayList<State> queryStates() throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM STATE");
        rs = prepStmt.executeQuery();
        ArrayList<State> states = new ArrayList<>();

        while(rs.next()) {
            states.add(new State(
                    rs.getInt(1),
                    rs.getString(2)));
        }
        return states;
    }
    public void resetStateDB() throws SQLException {
        stmt.executeUpdate("DROP TABLE STATE");
        stmt.executeUpdate(" CREATE TABLE \"State\" (\n" +
                "            \"id\"\tINTEGER NOT NULL UNIQUE,\n" +
                "            \"state\"\tTEXT,\n" +
                "    PRIMARY KEY(\"id\" AUTOINCREMENT)\n" +
                ");");
    }

}
