package com.trendyol.shoppingcart.discount.coupon;

import com.trendyol.shoppingcart.cart.ShoppingCart;
import com.trendyol.shoppingcart.discount.DiscountType;
import com.trendyol.shoppingcart.discount.coupon.Coupon;
import com.trendyol.shoppingcart.product.Category;
import com.trendyol.shoppingcart.product.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CouponTest {

    Coupon rateCoupon;
    Coupon amountCoupon;
    @Before
    public void init(){
        rateCoupon = new Coupon(200,10, DiscountType.RATE);
        amountCoupon = new Coupon(200,25,DiscountType.AMOUNT);
    }
    @Test
    public void CreateCoupon(){

        Assert.assertEquals(rateCoupon.getMinCartAmount(),200);
        Assert.assertTrue(DiscountType.RATE.equals(rateCoupon.getDiscountType()));
    }

    @Test
    public void isDiscountApplicableWithCoupon_MinAmount_200_And_Cart_Amount_250_ShouldReturn_True(){
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("apple", 25,new Category("Food"));
        cart.addItem(product,10);

        Assert.assertTrue(rateCoupon.isDiscountApplicable(cart));
    }

    @Test
    public void isDiscountApplicableWithCoupon_MinAmount_200_And_Cart_is_Null_ShouldReturn_False(){
        ShoppingCart cart = null;

        Assert.assertFalse(rateCoupon.isDiscountApplicable(cart));
    }

    @Test
    public void isDiscountApplicableWithCoupon_MinAmount_200_And_Cart_is_Empty_ShouldReturn_False(){
        ShoppingCart cart = new ShoppingCart();

        Assert.assertFalse(rateCoupon.isDiscountApplicable(cart));
    }

    @Test
    public void calculateDiscountWithCoupon_MinAmount_200_Amount_10_Type_Rate_Cart_Amount_250_ShouldReturn_25(){
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("apple", 25,new Category("Food"));
        cart.addItem(product,10);

        Assert.assertEquals(rateCoupon.calculateDiscount(cart.getTotalPrice()),25,0);
    }

    @Test
    public void calculateDiscountWithCoupon_MinAmount_200_Amount_25_Type_Amount_Cart_Amount_250_ShouldReturn_25(){
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("apple", 25,new Category("Food"));
        cart.addItem(product,10);

        Assert.assertEquals(amountCoupon.calculateDiscount(cart.getTotalPrice()),25,0);
    }






}
