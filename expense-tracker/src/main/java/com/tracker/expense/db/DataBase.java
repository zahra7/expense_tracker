package com.tracker.expense.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tracker.expense.models.Category;
import com.tracker.expense.models.Expense;

public class DataBase {
    static Connection connection;

    public static void connect(){
        connection = DatabaseConnection.getConnection();
    }

    public static void closeConnection(){
        try {
            connection.close();
            System.out.println("Connection closed successfully!!");
        } catch (SQLException e) {
            System.out.println("Error closing connection!!");
            e.printStackTrace();
        }
    }
    public static void createTables() {

        Statement statement;
        try {
            statement = connection.createStatement();

            // Create Categories Table
            if (!tableExists(connection, "categories")){
                String createCategoriesTable = """
                    CREATE TABLE IF NOT EXISTS categories (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(50) NOT NULL UNIQUE,
                        description VARCHAR(255),
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                    );
                """;
                statement.executeUpdate(createCategoriesTable);
            }

            // Create Expenses Table
            if (!tableExists(connection, "expenses")){
                String createExpensesTable = """
                    CREATE TABLE IF NOT EXISTS expenses (
                        id SERIAL PRIMARY KEY,
                        category_id INT NOT NULL,
                        amount DECIMAL(10, 2) NOT NULL,
                        description TEXT,
                        expense_date DATE NOT NULL,
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        FOREIGN KEY (category_id) REFERENCES categories(id)
                    );
                """;
                statement.executeUpdate(createExpensesTable);
            }

            // Create Budget Table
            if (!tableExists(connection, "budget")){
                String createBudgetTable = """
                    CREATE TABLE IF NOT EXISTS budget (
                        id SERIAL PRIMARY KEY,
                        category_id INT NOT NULL,
                        amount DECIMAL(10, 2) NOT NULL,
                        month TEXT,
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        FOREIGN KEY (category_id) REFERENCES categories(id)
                    );
                """;
                statement.executeUpdate(createBudgetTable);
            }
            
            System.out.println("Tables created successfully!");
        } catch (SQLException e) {
            System.out.println("Error creating tables!");
            e.printStackTrace();
        }
    }

     // Method to check if a table exists
     private static boolean tableExists(Connection connection, String tableName) {
        try {
            ResultSet resultSet = connection.getMetaData().getTables(null, null, tableName, new String[]{"TABLE"});
            return resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * Inserts an Expense object into the database.
     *
     * @param expense The Expense object containing the data to insert.
     * @return The ID of the inserted record.
     */
    public static Long insertExpense(Expense expense) {
        // SQL query for inserting the expense record
        String query = "INSERT INTO expenses (expense_date, amount, description, category_id, created_at) "
                     + "VALUES (?, ?, ?, ?, ?)";

        try{
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            // Set the parameters for the prepared statement            
            preparedStatement.setObject(1, expense.getExpenseDate());
            preparedStatement.setFloat(2, expense.getAmount());
            preparedStatement.setString(3, expense.getDescription());
            preparedStatement.setLong(4, expense.getCategoryId());
            preparedStatement.setObject(5, expense.getCreatedAt());

            // Execute the query and check if the insertion was successful
            int rowsAffected = preparedStatement.executeUpdate();

            // If insertion was successful, retrieve the generated ID (primary key)
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getLong(1); // Return the generated ID
                    }
                }
            } else {
                System.out.println("Failed to insert expense.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if insertion fails
    }

        /**
     * Inserts a Category object into the database.
     *
     * @param category The Category object containing the data to insert.
     * @return The ID of the inserted record.
     */
    public static Long insertCategory(Category category) {
        String query = "INSERT INTO categories (name, description) "
                     + "VALUES (?, ?)";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            // Set the parameters for the prepared statement            
            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getDescription());

            // Execute the query and check if the insertion was successful
            int rowsAffected = preparedStatement.executeUpdate();

            // If insertion was successful, retrieve the generated ID (primary key)
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getLong(1); // Return the generated ID
                    }
                }
            } else {
                System.out.println("Failed to insert category.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if insertion fails
    }
}

