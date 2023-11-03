package CarBooking.Model.dao;

import java.sql.Connection;

public abstract class DB {
    protected String driver = "org.sqlite.JDBC";
    protected String url = "jdbc:sqlite:/Users/tomgolding/Desktop/ASD/ASD-Project-solo/ASD_DB.db";
//    protected String url = "jdbc:sqlite:ASD_DB.db";
    protected Connection conn;
}