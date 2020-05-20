package com.trendyol.shoppingcart.discount.campaign;


import com.trendyol.shoppingcart.cart.CartItem;
import com.trendyol.shoppingcart.discount.Discount;
import com.trendyol.shoppingcart.discount.DiscountType;
import com.trendyol.shoppingcart.discount.Discountable;
import com.trendyol.shoppingcart.product.Category;

public class Campaign extends Discount {

    private int minQuantity;

    private Category category;

    public Campaign(Category category, double amount, int minQuantity, DiscountType discountType) {
        super(amount, discountType);
        this.category = category;
        this.minQuantity = minQuantity;
    }

    public int getMinQuantity() {
        return minQuantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean isDiscountApplicable(Discountable item) {
        CartItem cartItem = ((CartItem) item);
        if (cartItem != null && cartItem.getProduct() != null) {
            Category itemCategory = cartItem.getProduct().getCategory();
            return (itemCategory.equals(this.getCategory())
                    || this.category.isAncestorOf(itemCategory.getParentCategory()))
                    && cartItem.getQuantity() >= this.getMinQuantity();
        }

        return false;
    }

}
