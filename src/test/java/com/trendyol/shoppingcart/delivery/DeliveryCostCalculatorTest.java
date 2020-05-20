package com.trendyol.shoppingcart.delivery;

import com.trendyol.shoppingcart.cart.ShoppingCart;
import com.trendyol.shoppingcart.product.Category;
import com.trendyol.shoppingcart.product.Product;
import org.junit.Assert;
import org.junit.Test;

public class DeliveryCostCalculatorTest {

    @Test
    public void calculateForWhen_CostPerDelivery_2_CostPerProduct_2_NumberOfDeliveries_2_NumberOfProducts_2_ShouldReturn_10_99 (){
        DeliveryCostCalculator costCalculator = new DeliveryCostCalculator(2,2);
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Product("apple",10,new Category("Food")),1);
        cart.addItem(new Product("iphone",1000,new Category("Technology")),1);
        Assert.assertEquals(costCalculator.calculateFor(cart),10.99,0);
    }

    @Test
    public void calculateForWhen_CostPerDelivery_2_CostPerProduct_2_NumberOfDeliveries_1_NumberOfProducts_1_FixedCost_1_9_ShouldReturn_5_99 (){
        DeliveryCostCalculator costCalculator = new DeliveryCostCalculator(2,2,1.99);
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Product("apple",10,new Category("Food")),1);
        Assert.assertEquals(costCalculator.calculateFor(cart),5.99,0);
    }

    @Test
    public void calculateForWhen_CostPerDelivery_2_CostPerProduct_2_NumberOfDeliveries_0_NumberOfProducts_0_ShouldReturn_0 (){
        DeliveryCostCalculator costCalculator = new DeliveryCostCalculator(2,2);
        ShoppingCart cart = new ShoppingCart();
        Assert.assertEquals(costCalculator.calculateFor(cart),0,0);
    }
}
