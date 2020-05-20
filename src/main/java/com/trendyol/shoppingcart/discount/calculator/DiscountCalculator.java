package com.trendyol.shoppingcart.discount.calculator;

public class DiscountCalculator {
    protected double amount;

    public DiscountCalculator(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
