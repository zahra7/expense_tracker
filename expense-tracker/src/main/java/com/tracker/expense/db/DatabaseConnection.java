package com.tracker.expense.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;
    private static final String URL = "jdbc:postgresql://localhost:5430/expense_tracker";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Connection established successfully!!");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Failed to establish connection!!");
            }
        }
        return connection;
    }
}
