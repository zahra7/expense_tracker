package com.tracker.expense.models;

import java.util.Date;

public class Expense {
    private Long id;
    private Date expenseDate;
    private float amount;
    private String description;
    private Category category;

    public Expense(Long id, Date expenseDate, float amount, String description, Category category) {
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

    public Date getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(Date expenseDate) {
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
