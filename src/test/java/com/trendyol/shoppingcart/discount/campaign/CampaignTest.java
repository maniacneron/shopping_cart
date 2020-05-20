package com.trendyol.shoppingcart.discount.campaign;

import com.trendyol.shoppingcart.cart.CartItem;
import com.trendyol.shoppingcart.discount.DiscountType;
import com.trendyol.shoppingcart.discount.campaign.Campaign;
import com.trendyol.shoppingcart.product.Category;
import com.trendyol.shoppingcart.product.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CampaignTest {

    Category category;

    Campaign campaign;

    Campaign amountCampaign;
    @Before
    public void init(){
         category = new Category("Food");

         campaign = new Campaign(category,10,2, DiscountType.RATE);
         amountCampaign = new Campaign(category,20, 5,DiscountType.AMOUNT );
    }
    @Test
    public void CreateCampaign(){

        Assert.assertEquals(campaign.getMinQuantity(),2);
        Assert.assertTrue(campaign.getCategory().equals(category));
        Assert.assertTrue(DiscountType.RATE.equals(campaign.getDiscountType()));
    }

    @Test
    public void isDiscountApplicableWithCampaign_Category_Food_MinQuantity_2_ToCartItemWith_Product_Category_Food_Quantity_1_ShouldReturn_False(){

        Product product = new Product("apple",10, category);
        CartItem cartItem = new CartItem(product,1);

        boolean isApplicable = campaign.isDiscountApplicable(cartItem);

        Assert.assertFalse(isApplicable);
    }

    @Test
    public void isDiscountApplicableWithCampaign_Category_Food_MinQuantity_2_ToCartItemWith_Product_Category_Technology_Quantity_4_ShouldReturn_False(){

        Product product = new Product("apple",10, new Category("Technology"));
        CartItem cartItem = new CartItem(product,4);

        boolean isApplicable = campaign.isDiscountApplicable(cartItem);

        Assert.assertFalse(isApplicable);
    }


    @Test
    public void isDiscountApplicableWithCampaign_Category_Food_MinQuantity_2_ToCartItemWith_Product_Category_Food_Quantity_10_ShouldReturn_True(){
        Product product = new Product("apple",10, category);
        CartItem cartItem = new CartItem(product,3);

        boolean isApplicable = campaign.isDiscountApplicable(cartItem);

        Assert.assertTrue(isApplicable);
    }

    @Test
    public void isDiscountApplicableWithCampaign_Category_Food_MinQuantity_2_WhenItemIs_Null(){
        CartItem cartItem = null;
        boolean isApplicable = campaign.isDiscountApplicable(cartItem);

        Assert.assertFalse(isApplicable);
    }

    @Test
    public void calculateDiscountWithCampaign_Category_Food_Amount_10_MinQuantity_2_Type_Rate_WithCartItem_Product_Price_10_Category_Food_Quantity_3_ShouldReturn_3(){
        Product product = new Product("apple",10, category);
        CartItem cartItem = new CartItem(product,3);


        Assert.assertEquals(campaign.calculateDiscount(cartItem.getTotalPrice()),3,0);
    }

    @Test
    public void calculateDiscountWithCampaign_Category_Food_Amount_20_MinQuantity_5_Type_Amount_WithCartItem_Product_Price_20_Category_Food_Quantity_6_ShouldReturn_20(){
        Product product = new Product("banana",20, category);
        CartItem cartItem = new CartItem(product,6);


        Assert.assertEquals(amountCampaign.calculateDiscount(cartItem.getTotalPrice()),20,0);
    }


}
