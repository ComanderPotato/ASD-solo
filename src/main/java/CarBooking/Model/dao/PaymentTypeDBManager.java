package CarBooking.Model.dao;

import CarBooking.Model.PaymentType;
import CarBooking.Model.User;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PaymentTypeDBManager {
    private Statement stmt;
    private PreparedStatement prepStmt;
    private Connection conn;
    ResultSet rs;
    public PaymentTypeDBManager(Connection conn) throws SQLException {
        stmt = conn.createStatement();
        this.conn = conn;
    }
    public ArrayList<PaymentType> queryPaymentTypes() throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM PAYMENTTYPES");
        rs = prepStmt.executeQuery();
        ArrayList<PaymentType> paymentTypes = new ArrayList<>();
        while(rs.next()) {
            paymentTypes.add(new PaymentType(
                    rs.getInt(1),
                    rs.getString(2)));
        }
        return paymentTypes;
    }
    public PaymentType getPaymentTypeById(int id) throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM PAYMENTTYPES WHERE ID = ?");
        prepStmt.setInt(1, id);
        rs = prepStmt.executeQuery();
        if(rs.next()) {
            return new PaymentType(
                    rs.getInt(1),
                    rs.getString(2));
        }
        return null;
    }
    public void resetSubscriptionTypeDB() throws SQLException {
        stmt.executeUpdate("DROP TABLE PAYMENTTYPE");
        stmt.executeUpdate("CREATE TABLE \"PaymentType\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL UNIQUE,\n" +
                "\t\"value\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"id\" AUTOINCREMENT)\n" +
                ");");
    }
}
