package com.tracker.expense.models;

import java.time.LocalDate;

public class Expense {
    private Long id;
    private LocalDate expenseDate;
    private float amount;
    private String description;
    private Category category;

    public Expense(Long id, LocalDate expenseDate, float amount, String description, Category category) {
        this.id = id;
        this.expenseDate = expenseDate;
        this.amount = amount;
        this.description = description;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }

    public float getAmount() {
        return amount;
    }

    public Category getCategory(){
        return category;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(Category category){
        this.category = category;
    }
    
}
