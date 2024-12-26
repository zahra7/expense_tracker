package com.tracker.expense;


import java.time.LocalDateTime;

import com.tracker.expense.db.DataBase;
import com.tracker.expense.models.Category;
import com.tracker.expense.models.Expense;

public class Main {
    public static void main(String[] args) {
        initDb();

        //Test
        Category category = new Category("Beef", "beef meat");
        Long insertedCategoryId = DataBase.insertCategory(category);
        if (insertedCategoryId != null) {
            System.out.println("Category inserted successfully with ID: " + insertedCategoryId);
        } else {
            System.out.println("Failed to insert category.");
            return;
        }
        // Create an expense object
        Expense expense = new Expense(
            LocalDateTime.now(),
            0, 
            "Groceries", 
            insertedCategoryId, 
            LocalDateTime.now());

        Long insertedId = DataBase.insertExpense(expense);

        if (insertedId != null) {
            System.out.println("Expense inserted successfully with ID: " + insertedId);
        } else {
            System.out.println("Failed to insert expense.");
        }
        DataBase.closeConnection();
    }

    public static void initDb(){
        DataBase.connect();
        DataBase.createTables();
    }
}