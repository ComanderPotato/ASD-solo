package CarBooking.Model.dao;

import CarBooking.Model.Address;
import CarBooking.Model.CarSpot;

import java.sql.*;
import java.util.ArrayList;

public class CarSpotDBManager {
    private Statement stmt;
    private PreparedStatement prepStmt;
    private Connection conn;
    ResultSet rs;
    public CarSpotDBManager(Connection conn) throws SQLException {
        stmt = conn.createStatement();
        this.conn = conn;
    }
    public void addCarSpot(CarSpot carSpot) throws SQLException {
        prepStmt = conn.prepareStatement("INSERT INTO CARSPOT " +
                "(ADDRESSID, LOCATIONNAME, PRICE)" +
                "VALUES (?, ?, ?)");
        prepStmt.setInt(1, carSpot.getAddressId());
        prepStmt.setString(2, carSpot.getLocationName());
        prepStmt.setDouble(3, carSpot.getPrice());
        prepStmt.executeUpdate();
    }
    public ArrayList<CarSpot> queryCarSpots() throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM CARSPOT");
        ArrayList<CarSpot> carSpots = new ArrayList<>();
        rs = prepStmt.executeQuery();
        while(rs.next()) {
            carSpots.add(new CarSpot(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4)));
        }
        return carSpots;
    }
    public ArrayList<CarSpot> queryCarSpotsByState(int stateId) throws SQLException{
        prepStmt = conn.prepareStatement("SELECT CARSPOT.* " +
                                        "FROM CARSPOT " +
                                        "JOIN address ON CARSPOT.ADDRESSID = ADDRESS.ID " +
                                        "WHERE ADDRESS.STATEID = ?");
        prepStmt.setInt(1, stateId);
        ArrayList<CarSpot> carSpots = new ArrayList<>();
        rs = prepStmt.executeQuery();
        while(rs.next()) {
            carSpots.add(new CarSpot(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4)));
        }
        return carSpots;
    }

    // TEMPORARY
    public ArrayList<CarSpot> locationName(String filteredString) throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM CARSPOT WHERE LOCATIONNAME LIKE ?");
        prepStmt.setString(1, "%" + filteredString + "%");
        ArrayList<CarSpot> carSpots = new ArrayList<>();
        rs = prepStmt.executeQuery();
        while(rs.next()) {
            carSpots.add(new CarSpot(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4)));
        }
        return carSpots;
    }
    public boolean carSpotExists(String locationName) throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM CARSPOT WHERE LOCATIONNAME = ?");
        prepStmt.setString(1, locationName);
        rs = prepStmt.executeQuery();
        return rs.next() ? true : false;
    }
    public ArrayList<CarSpot> filterCarSpots(String filteredString, int stateID) throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * " +
                "FROM CARSPOT " +
                "INNER JOIN address ON CARSPOT.ADDRESSID = ADDRESS.ID " +
                "WHERE ADDRESS.STATEID = ?" +
                "AND (LOCATIONNAME LIKE ?" +
                "OR ADDRESS.ADDRESSLINE LIKE ?" +
                "OR ADDRESS.SUBURB LIKE ?" +
                "OR ADDRESS.CITY LIKE ?)");
        prepStmt.setInt(1, stateID);
        prepStmt.setString(2, "%" + filteredString + "%");
        prepStmt.setString(3, "%" + filteredString + "%");
        prepStmt.setString(4, "%" + filteredString + "%");
        prepStmt.setString(5, "%" + filteredString + "%");
        ArrayList<CarSpot> carSpots = new ArrayList<>();
        rs = prepStmt.executeQuery();
        while(rs.next()) {
            carSpots.add(new CarSpot(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4)));
        }
        return carSpots;
    }
    public ArrayList<CarSpot> queryCarSpotsWithAddress() throws SQLException {
        prepStmt = conn.prepareStatement("SELECT * FROM CARSPOT");
        ArrayList<CarSpot> carSpots = new ArrayList<>();
        rs = prepStmt.executeQuery();
        while(rs.next()) {
            Address address = new AddressDBManager(conn).queryAddressById(rs.getInt(2));
            carSpots.add(new CarSpot(rs.getInt(1), address, rs.getString(3), rs.getDouble(4)));
        }
        return carSpots;
    }
}
