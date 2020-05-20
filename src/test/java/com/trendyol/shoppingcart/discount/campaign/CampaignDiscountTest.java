package com.trendyol.shoppingcart.discount.campaign;

import com.trendyol.shoppingcart.discount.DiscountType;
import com.trendyol.shoppingcart.discount.campaign.Campaign;
import com.trendyol.shoppingcart.discount.campaign.CampaignDiscount;
import com.trendyol.shoppingcart.product.Category;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CampaignDiscountTest {

    Category category;
    Campaign campaign;
    CampaignDiscount campaignDiscount;
    @Before
    public void init(){
        category = new Category("Food");
        campaign = new Campaign(category,10,2, DiscountType.RATE);
         campaignDiscount = new CampaignDiscount(campaign);

    }
    @Test
    public void CreateCampaignDiscount(){

        Assert.assertTrue(campaignDiscount.getCampaign().equals(campaign));
        Assert.assertEquals(campaignDiscount.getTotalDiscount(),0,0);
    }

    @Test
    public void addDiscountAmount_20_TotalDiscount_ShouldBe_20(){
        campaignDiscount.addDiscount(20);

        Assert.assertEquals(campaignDiscount.getTotalDiscount(),20,0);
    }

    @Test
    public void AddDiscountAmount_minus20_TotalDiscount_ShouldBe_0(){
        campaignDiscount.addDiscount(-20);

        Assert.assertEquals(campaignDiscount.getTotalDiscount(),0,0);
    }
}
