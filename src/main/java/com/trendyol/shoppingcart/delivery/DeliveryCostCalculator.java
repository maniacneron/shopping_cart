package com.trendyol.shoppingcart.delivery;

public class DeliveryCostCalculator {
    private double costPerDelivery;
    private double costPerProduct;
    private double fixedCost = 2.99;


    public double calculateFor(Deliverable cart) {
        double cost = 0;
        if (!cart.isEmpty()) {
            cost =(cart.getNumberOfDeliveries() * this.costPerDelivery) + (cart.getNumberOfProducts() * this.costPerProduct) + this.fixedCost;
            cart.setDeliveryCost(cost);
        }
        return cost;
    }

    public DeliveryCostCalculator(double costPerDelivery, double costPerProduct, double fixedCost) {
        this.costPerDelivery = costPerDelivery;
        this.costPerProduct = costPerProduct;
        this.fixedCost = fixedCost;
    }

    public DeliveryCostCalculator(double costPerDelivery, double costPerProduct) {
        this.costPerDelivery = costPerDelivery;
        this.costPerProduct = costPerProduct;
    }
}
