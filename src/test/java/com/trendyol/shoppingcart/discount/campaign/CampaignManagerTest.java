package com.trendyol.shoppingcart.discount.campaign;

import com.trendyol.shoppingcart.cart.CartItem;
import com.trendyol.shoppingcart.cart.ShoppingCart;
import com.trendyol.shoppingcart.discount.DiscountType;
import com.trendyol.shoppingcart.discount.Discountable;
import com.trendyol.shoppingcart.discount.campaign.Campaign;
import com.trendyol.shoppingcart.discount.campaign.CampaignManager;
import com.trendyol.shoppingcart.product.Category;
import com.trendyol.shoppingcart.product.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class CampaignManagerTest {
    Campaign rateCampaign;
    Campaign rateCampaign2;
    Campaign amountCampaign;
    Campaign amountCampaign2;
    CampaignManager campaignManager;
    ShoppingCart cart;
    Category category;
    Product product;
    Set<Discountable> items;
    @Before
    public void init(){
        campaignManager = new CampaignManager();
        category = new Category("Food");
        product = new Product("apple",20,category);
        rateCampaign = new Campaign(category,10,2, DiscountType.RATE);
        rateCampaign2 = new Campaign(category,20,3,DiscountType.RATE);
        amountCampaign = new Campaign(category,20,2,DiscountType.AMOUNT);
        amountCampaign2 = new Campaign(category,30,3,DiscountType.AMOUNT);
        items = new HashSet<>();
    }

    @Test
    public void applyCampaignsWithCampaigns_Amount_10_MinQuantity_2_DiscountType_Rate_And_Amount_20_MinQuantity_3_DiscountType_Rate_Quantity_3_ShouldReturn_12(){
        items.add(new CartItem(product,3));

        double discount = campaignManager.applyCampaigns(items,rateCampaign,rateCampaign2);

        Assert.assertEquals(discount,12,0);
    }

    @Test
    public void applyCampaignsWithCampaigns_Amount_10_MinQuantity_2_DiscountType_Amount_And_Amount_20_MinQuantity_3_DiscountType_Amount_Quantity_3_ShouldReturn_30(){
        items.add(new CartItem(product,3));

        double discount = campaignManager.applyCampaigns(items,amountCampaign,amountCampaign2);

        Assert.assertEquals(discount,30,0);
    }


    @Test
    public void applyCampaignsWithCampaigns_Amount_20_MinQuantity_2_DiscountType_Rate_And_Amount_30_MinQuantity_3_DiscountType_Amount_Quantity_3_Should_Return_30(){
        items.add(new CartItem(product,3));

        double discount = campaignManager.applyCampaigns(items,rateCampaign2,amountCampaign2);

        Assert.assertEquals(discount,30,0);
    }

    @Test
    public void applyCampaignsWithCampaigns_Amount_20_MinQuantity_2_DiscountType_Amount_And_Amount_30_MinQuantity_3_DiscountType_Amount_Quantity_2_ShouldReturn_4(){
        items.add(new CartItem(product,2));

        double discount = campaignManager.applyCampaigns(items,rateCampaign,rateCampaign2);

        Assert.assertEquals(discount,4,0);
    }

    @Test
    public void applyCampaignsWithCampaigns_Amount_20_MinQuantity_2_DiscountType_Amount_And_Amount_30_MinQuantity_3_DiscountType_Amount_Items_Empty_ShouldReturn_0(){
        double discount = campaignManager.applyCampaigns(items,rateCampaign,rateCampaign2);

        Assert.assertEquals(discount,0,0);
    }

    @Test
    public void applyCampaignsWithCampaigns_Null_Null_Quantity_3_ShouldReturn_0(){
        items.add(new CartItem(product,3));

        double discount = campaignManager.applyCampaigns(items,null,null);

        Assert.assertEquals(discount,0,0);
    }




}
