package com.trendyol.shoppingcart.discount.coupon;

import com.trendyol.shoppingcart.cart.ShoppingCart;
import com.trendyol.shoppingcart.discount.Discount;
import com.trendyol.shoppingcart.discount.DiscountType;
import com.trendyol.shoppingcart.discount.Discountable;

public class Coupon extends Discount {
    private int minCartAmount;

    public Coupon(int minCartAmount, int amount, DiscountType type) {
        super(amount,type);
        this.minCartAmount = minCartAmount;
    }

    public int getMinCartAmount() {
        return minCartAmount;
    }

    public void setMinCartAmount(int minCartAmount) {
        this.minCartAmount = minCartAmount;
    }

    @Override
    public boolean isDiscountApplicable(Discountable item) {
        return item != null && ((ShoppingCart)item).getTotalPrice() >= this.getMinCartAmount();
    }
}
