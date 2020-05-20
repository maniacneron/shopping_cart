package com.trendyol.shoppingcart.cart;

import com.trendyol.shoppingcart.discount.Discount;
import com.trendyol.shoppingcart.discount.Discountable;
import com.trendyol.shoppingcart.product.Product;

public class CartItem implements Discountable {

    private Product product;

    private int quantity;

    private double discountedPrice;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.discountedPrice = getTotalPrice();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    @Override
    public void applyDiscount(Discount campaign) {
        if(campaign != null ) {
            this.discountedPrice = this.discountedPrice - campaign.calculateDiscount(this.discountedPrice);
        }
    }

    @Override
    public double getTotalPrice(){
        return product.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return  product +
                ", Quantity=" + quantity +
                ", Discounted Total Price=" + discountedPrice ;
    }
}
