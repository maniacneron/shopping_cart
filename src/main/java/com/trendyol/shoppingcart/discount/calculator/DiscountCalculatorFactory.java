package com.trendyol.shoppingcart.discount.calculator;

import com.trendyol.shoppingcart.discount.DiscountType;

public class DiscountCalculatorFactory {


    public static Calculator create(DiscountType type, double amount) {

        if (DiscountType.RATE.equals(type)) {
            return new RateCalculator(amount);
        } else {
            return new AmountCalculator(amount);
        }
    }
}
