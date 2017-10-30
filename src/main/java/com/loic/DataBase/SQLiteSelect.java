package com.loic.DataBase;

import java.sql.*;

public class SQLiteSelect {
    public static void main( String args[] ) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Cars;");
            while (rs.next()) {
                int id = rs.getInt("id");
                String ip = rs.getString("ip");
                String port = rs.getString("port");
                int speed = rs.getInt("speed");
                int x = rs.getInt("x");
                int y = rs.getInt("y");
                String orientation = rs.getString("orientation");
                System.out.println("ID = " + id);
                System.out.println("IP = " + ip);
                System.out.println("Port = " + port);
                System.out.println("Speed = " + speed);
                System.out.println("x = " + x);
                System.out.println("y = " + y);
                System.out.println("orientation = " + orientation);
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
}
