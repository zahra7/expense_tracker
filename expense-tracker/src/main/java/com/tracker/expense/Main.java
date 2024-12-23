package com.tracker.expense;

import java.sql.Connection;

import com.tracker.expense.db.DatabaseConnection;

public class Main {
    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();
        if (connection != null) {
            System.out.println("Connection established: " + connection.toString());
        } else {
            System.out.println("Failed to establish connection.");
        }
    }
}