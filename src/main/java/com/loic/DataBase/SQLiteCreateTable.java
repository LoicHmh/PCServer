package com.loic.DataBase;


import java.sql.*;

public class SQLiteCreateTable {
    public static void main( String args[] )
    {
        Connection connection = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Opened database successfully");

            stmt = connection.createStatement();
            String sql = "CREATE TABLE Cars " +
                    "(ID         INT PRIMARY KEY     NOT NULL," +
                    " IP           VARCHAR(255)      NOT NULL, " +
                    " PORT        VARCHAR(255)       NOT NULL, " +
                    " SPEED       VARCHAR(255)       NOT NULL , " +
                    " X         INTEGER             NOT NULL ," +
                    " Y           INTEGER             NOT NULL ," +
                    " ORIENTATION  VARCHAR(255)         NOT NULL )";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }

}
