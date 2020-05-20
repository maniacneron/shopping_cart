package com.trendyol.shoppingcart.discount.calculator;

public class RateCalculator extends DiscountCalculator implements Calculator {

    public RateCalculator(double amount) {
        super(amount);
    }

    @Override
    public double calculate(double price) {
        return (price * this.amount / 100);
    }
}
