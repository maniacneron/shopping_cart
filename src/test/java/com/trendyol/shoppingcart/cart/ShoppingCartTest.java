package com.trendyol.shoppingcart.cart;

import com.trendyol.shoppingcart.discount.DiscountType;
import com.trendyol.shoppingcart.discount.campaign.Campaign;
import com.trendyol.shoppingcart.discount.coupon.Coupon;
import com.trendyol.shoppingcart.product.Category;
import com.trendyol.shoppingcart.product.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShoppingCartTest {

    ShoppingCart cart;
    @Before
    public void init(){
        cart = new ShoppingCart();
    }
    @Test
    public void addItemToCart_Expected_Size_1(){
        Category food = new Category("Food");
        Product apple = new Product("apple",10,food);

        cart.addItem(apple,10);

        Assert.assertEquals(cart.getNumberOfProducts(),1);
    }

    @Test
    public void getNumberOfDeliveriesWhenCartHasItemsWith_2_DifferentCategories_ShouldReturn_2(){
        Category food = new Category("Food");
        Category technology = new Category("Technology");
        Product apple = new Product("apple",10,food);
        Product iphone = new Product("iphone",1000,technology);

        cart.addItem(apple,10);
        cart.addItem(iphone,1);

        Assert.assertEquals(cart.getNumberOfDeliveries(),2);
    }

    @Test
    public void getNumberOfProductsWhenNullItemAddedToCart_ShouldReturn_0(){
        cart.addItem(null,10);

        Assert.assertEquals(cart.getNumberOfProducts(),0);
    }

    @Test
    public void agetNumberOfProductsWhenItemAddedToWithQuantity_0_ShouldReturn_0(){
        Category food = new Category("Food");
        Product apple = new Product("apple",10,food);

        cart.addItem(apple,0);

        Assert.assertEquals(cart.getNumberOfProducts(),0);
    }

    @Test
    public void getTotalAmountAfterDiscountsWhenCampaign_Category_Food_Amount_10_MinQuantity_2_Type_Rate_AppliedToCartWithItem_Product_Apple_Category_Food_Price_11_Quantity_10_ShodulReturn_99(){
        Category food = new Category("Food");
        Product apple = new Product("apple",11,food);
        Campaign campaign = new Campaign(food,10,2, DiscountType.RATE);
        cart.addItem(apple,10);

        cart.applyCampaigns(campaign);

        Assert.assertEquals(cart.getTotalAmountAfterDiscounts(),99,0);

    }

    @Test
    public void getTotalAmountAfterDiscountsWhenCoupon_MinCartAmount_200_Amount_10_Type_Rate_AppliedToCartWith_TotalAmount_300_ShodulReturn_270(){
        Category food = new Category("Food");
        Product apple = new Product("apple",10,food);
        Coupon coupon = new Coupon(200,10, DiscountType.RATE);
        cart.addItem(apple,30);

        cart.applyDiscount(coupon);

        Assert.assertEquals(cart.getTotalAmountAfterDiscounts(),270,0);
    }

    @Test
    public void applyMultipleCampaignAndSingleCoupon_CheckCampaignDiscount_CouponDiscount_Total_Price_ShoulReturn_30_27_243(){
        Category food = new Category("Food");
        Product apple = new Product("apple",10,food);
        Campaign campaign = new Campaign(food,10,2, DiscountType.RATE);
        Campaign campaign1 = new Campaign(food,25,5, DiscountType.AMOUNT);
        Coupon coupon = new Coupon(200,10, DiscountType.RATE);
        cart.addItem(apple,30);

        cart.applyCampaigns(campaign,campaign1);
        cart.applyDiscount(coupon);


        Assert.assertEquals(cart.getTotalAmountAfterDiscounts(),243,0);
        Assert.assertEquals(cart.getCampaignDiscount(),30,0);
        Assert.assertEquals(cart.getCouponDiscount(),27,0);
    }


}
