package com.example.connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    static String URL = "jdbc:mysql://localhost:3306/c0723g1";
    static String USERNAME = "root";
    static String PASSWORD = "123456";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            return null;
        }
    }

}
