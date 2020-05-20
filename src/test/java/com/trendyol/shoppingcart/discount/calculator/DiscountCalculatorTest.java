package com.trendyol.shoppingcart.discount.calculator;

import com.trendyol.shoppingcart.discount.DiscountType;
import org.junit.Assert;
import org.junit.Test;

public class DiscountCalculatorTest {

    @Test
    public void createAmountCalculator(){
        Calculator calculator = DiscountCalculatorFactory.create(DiscountType.AMOUNT,10);

        Assert.assertTrue(calculator instanceof AmountCalculator);
        Assert.assertEquals(((AmountCalculator) calculator).getAmount(),10,0);
    }

    @Test
    public void createRateCalculator(){
        Calculator calculator = DiscountCalculatorFactory.create(DiscountType.RATE,10);

        Assert.assertTrue(calculator instanceof RateCalculator);
        Assert.assertEquals(((RateCalculator) calculator).getAmount(),10,0);
    }

    @Test
    public void calculateDiscountWithAmountCalculatorWith_Amount_20_Price_200_ShouldReturn_20(){
        Calculator calculator = DiscountCalculatorFactory.create(DiscountType.AMOUNT,20);

        Assert.assertEquals(calculator.calculate(200),20,0);
    }

    @Test
    public void calculateDiscountWithRateCalculatorWith_Amount_20_Price_200_ShouldReturn_40(){
        Calculator calculator = DiscountCalculatorFactory.create(DiscountType.RATE,20);

        Assert.assertEquals(calculator.calculate(200),40,0);
    }
}
