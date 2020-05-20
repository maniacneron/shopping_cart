package com.trendyol.shoppingcart.cart;

import com.trendyol.shoppingcart.discount.campaign.Campaign;
import com.trendyol.shoppingcart.discount.DiscountType;
import com.trendyol.shoppingcart.product.Category;
import com.trendyol.shoppingcart.product.Product;
import org.junit.Assert;
import org.junit.Test;

public class CartItemTest {

    @Test
    public void createCartItem(){
        Category category = new Category("Food");
        Product apple = new Product("Apple",10, category);

        CartItem item = new CartItem(apple,3);

        Assert.assertTrue(item.getProduct().equals(apple));
        Assert.assertEquals(item.getQuantity(),3,0);
    }

    @Test
    public void getDiscountedPriceWithCampaign_Category_Food_Amount_10_MinQuantity_3_Type_Rate_WithCartItem_Price_10_Quantity_3_Expected_DiscountedPrice_27(){
        Category category = new Category("Food");
        Campaign campaign = new Campaign(category,10,3, DiscountType.RATE);
        Product apple = new Product("Apple",10, category);

        CartItem item = new CartItem(apple,3);

        item.applyDiscount(campaign);

        Assert.assertEquals(item.getDiscountedPrice(),27,0);
    }

    @Test
    public void getDiscountedPriceCampaign_Null_CartItemTotalPrice_30_ShouldReturn_30(){
        Category category = new Category("Food");
        Campaign campaign = null;
        Product apple = new Product("Apple",10, category);

        CartItem item = new CartItem(apple,3);

        item.applyDiscount(campaign);

        Assert.assertEquals(item.getDiscountedPrice(),30,0);
    }
}
