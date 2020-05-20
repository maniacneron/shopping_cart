package com.trendyol.shoppingcart.discount.calculator;

public class AmountCalculator extends DiscountCalculator implements Calculator {
    public AmountCalculator(double amount) {
        super(amount);
    }

    @Override
    public double calculate(double price) {
        return amount;
    }
}
