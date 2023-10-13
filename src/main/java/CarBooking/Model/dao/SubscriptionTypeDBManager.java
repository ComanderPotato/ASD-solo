package CarBooking.Model.dao;

import CarBooking.Model.State;
import CarBooking.Model.SubscriptionType;

import java.sql.*;
import java.util.ArrayList;

public class SubscriptionTypeDBManager {
    private Statement stmt;
    private PreparedStatement prepStmt;
    private Connection conn;
    ResultSet rs;
    public SubscriptionTypeDBManager(Connection conn) throws SQLException {
        stmt = conn.createStatement();
        this.conn = conn;
    }
    public SubscriptionType querySubscriptionTypeById(int id) throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM SUBSCRIPTIONTYPE WHERE ID = ?");
        prepStmt.setInt(1, id);
        rs = prepStmt.executeQuery();
        if(rs.next()) {
            return new SubscriptionType(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getDouble(3));
        }
        return null;
    }
    public ArrayList<SubscriptionType> querySubscriptionTypes() throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM SUBSCRIPTIONTYPES");
        rs = prepStmt.executeQuery();
        ArrayList<SubscriptionType> subscriptionTypes = new ArrayList<>();

        while(rs.next()) {
            subscriptionTypes.add(new SubscriptionType(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getDouble(3)));
        }
        return subscriptionTypes;
    }
    public void resetSubscriptionTypeDB() throws SQLException {
        stmt.executeUpdate("DROP TABLE SUBSCRIPTIONTYPE");
        stmt.executeUpdate("CREATE TABLE \"SubscriptionType\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL UNIQUE,\n" +
                "\t\"type\"\tTEXT,\n" +
                "\t\"price\"\tNUMERIC,\n" +
                "\tPRIMARY KEY(\"id\" AUTOINCREMENT)\n" +
                ");");
    }
}
