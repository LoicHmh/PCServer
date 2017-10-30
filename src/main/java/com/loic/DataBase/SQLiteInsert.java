package com.loic.DataBase;


import java.sql.*;

public class SQLiteInsert {
    public static void main( String args[] )
    {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO Cars (ID,IP,PORT,SPEED,X,Y,ORIENTATION) " +
                    "VALUES (1, '192.168.1.1', 8808, 5, 0,0,'WE' );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO Cars (ID,IP,PORT,SPEED,X,Y,ORIENTATION) " +
                    "VALUES (2, '192.168.1.1', 8809, 5, 0,0,'EW' );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO Cars (ID,IP,PORT,SPEED,X,Y,ORIENTATION) " +
                    "VALUES (3, '192.168.1.1', 8810, 5, 0,0,'SN' );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO Cars (ID,IP,PORT,SPEED,X,Y,ORIENTATION) " +
                    "VALUES (4, '192.168.1.1', 8811, 5, 0,0,'NS' );";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }

}
