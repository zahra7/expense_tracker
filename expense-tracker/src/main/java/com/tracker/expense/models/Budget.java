package com.tracker.expense.models;

public class Budget {
    private Long id;
    private String month;
    private float amount;
    private Category category;
    
    public Budget(Long id, String month, float amount, Category category) {
        this.id = id;
        this.month = month;
        this.amount = amount;
        this.category = category;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMonth() {
        return month;
    }
    public void setMonth(String month) {
        this.month = month;
    }
    public float getAmount() {
        return amount;
    }
    public void setAmount(float amount) {
        this.amount = amount;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
}
