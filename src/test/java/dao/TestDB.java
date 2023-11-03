package dao;

import java.sql.Connection;

public abstract class TestDB {
    protected String driver = "org.sqlite.JDBC";
    protected String url = "jdbc:sqlite:ASD_DB_TEST.db";
    protected Connection conn;
}