package com.trendyol.shoppingcart.discount;

public interface Discountable {

    void applyDiscount(Discount discount);

    double getTotalPrice();
}
