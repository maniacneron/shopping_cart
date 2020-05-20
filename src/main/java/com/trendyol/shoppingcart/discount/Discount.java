package com.trendyol.shoppingcart.discount;

import com.trendyol.shoppingcart.discount.calculator.Calculator;
import com.trendyol.shoppingcart.discount.calculator.DiscountCalculatorFactory;

public abstract class Discount {

    private DiscountType discountType;

    private Calculator discountCalculator;

    public Discount(double amount, DiscountType discountType) {
        this.discountType = discountType;
        //Using a factory pattern might be a little over-engineering here since we have only 2 discount type yet.
        //But I wanted to show how to extend if other types come in future
        this.discountCalculator = DiscountCalculatorFactory.create(discountType, amount);
    }

    public double calculateDiscount(double price) {

        return this.discountCalculator.calculate(price);
    }

    public abstract boolean isDiscountApplicable(Discountable item);

    public DiscountType getDiscountType() {
        return discountType;
    }

}
