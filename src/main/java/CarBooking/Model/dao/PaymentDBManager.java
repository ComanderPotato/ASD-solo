package CarBooking.Model.dao;

import CarBooking.Model.Payment;
import CarBooking.Model.User;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PaymentDBManager {
    private Statement stmt;
    private PreparedStatement prepStmt;
    private Connection conn;
    ResultSet rs;
    public PaymentDBManager(Connection conn) throws SQLException {
        stmt = conn.createStatement();
        this.conn = conn;
    }
    public void addPayment(Payment payment) throws SQLException {
        prepStmt = conn.prepareStatement("INSERT INTO PAYMENT " +
                "(USERID, PAYMENTTYPEID, NAME, NUMBER, EXPIRY, CVV)" +
                "VALUES (?, ?, ?, ?, ?, ?)");
        prepStmt.setInt(1, payment.getUserId());
        prepStmt.setInt(2, payment.getPaymentTypeId());
        prepStmt.setString(3, payment.getName());
        prepStmt.setString(4, payment.getNumber());
        prepStmt.setString(5, payment.getExpiry());
        prepStmt.setString(6, payment.getCvv());
        prepStmt.executeUpdate();
    }
    public void removePayment(int id) throws SQLException {
        prepStmt = conn.prepareStatement("DELETE FROM PAYMENT WHERE ID = ?");
        prepStmt.setInt(1, id);
        prepStmt.executeUpdate();
    }
    public ArrayList<Payment> queryPayments(int userId) throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM PAYMENT WHERE USERID = ?");
        prepStmt.setInt(1, userId);
        rs = prepStmt.executeQuery();
        ArrayList<Payment> payments = new ArrayList<>();
        while(rs.next()) {
            payments.add(new Payment(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7)
            ));
        }
        return payments;
    }
    public void updatePayment(Payment updatedPayment) throws SQLException {
        prepStmt = conn.prepareStatement("UPDATE PAYMENT " +
                "SET USERID = ?, PAYMENTTYPEID = ?, NAME = ?, NUMBER = ?, EXPIRY = ?, CVV = ?" +
                "WHERE ID = ?");
        prepStmt.setInt(1, updatedPayment.getUserId());
        prepStmt.setInt(2, updatedPayment.getPaymentTypeId());
        prepStmt.setString(3, updatedPayment.getName());
        prepStmt.setString(4, updatedPayment.getNumber());
        prepStmt.setString(5, updatedPayment.getExpiry());
        prepStmt.setString(6, updatedPayment.getCvv());
        prepStmt.executeUpdate();
    }
    public void resetPaymentDB() throws SQLException {
        stmt.executeUpdate("DROP TABLE PAYMENT");
        stmt.executeUpdate("CREATE TABLE \"Payment\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL UNIQUE,\n" +
                "\t\"userId\"\tINTEGER NOT NULL,\n" +
                "\t\"paymentTypeId\"\tINTEGER NOT NULL,\n" +
                "\t\"name\"\tTEXT,\n" +
                "\t\"number\"\tTEXT,\n" +
                "\t\"expiry\"\tTEXT,\n" +
                "\t\"cvv\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"id\" AUTOINCREMENT),\n" +
                "\tFOREIGN KEY(\"paymentTypeId\") REFERENCES \"PaymentType\"(\"id\")\n" +
                ");");
    }
}
