package com.tracker.expense.models;

import java.time.LocalDateTime;

public class Expense {
    private long id;
    private LocalDateTime expenseDate;
    private float amount;
    private String description;
    private long categoryId;
    private LocalDateTime createdAt;

    public Expense(LocalDateTime expenseDate, float amount, String description, long categoryId, LocalDateTime createdAt) {
        this.expenseDate = expenseDate;
        this.amount = amount;
        this.description = description;
        this.categoryId = categoryId;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDateTime expenseDate) {
        this.expenseDate = expenseDate;
    }

    public float getAmount() {
        return amount;
    }

    public Long getCategoryId(){
        return categoryId;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
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

    public void setCategoryId(long categoryId){
        this.categoryId = categoryId;
    }

    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }
    
}
