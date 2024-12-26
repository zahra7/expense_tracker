package com.tracker.expense.models;

public class Budget {
    private Long id;
    private String month;
    private float amount;
    private long categoryId;
    
    public Budget(Long id, String month, float amount, long categoryId) {
        this.id = id;
        this.month = month;
        this.amount = amount;
        this.categoryId = categoryId;
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
    public long getCategoryId() {
        return categoryId;
    }
    public void setCategory(long categoryId) {
        this.categoryId = categoryId;
    }
}
