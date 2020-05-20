package com.trendyol.shoppingcart.delivery;

public interface Deliverable {
    boolean isEmpty();

    int getNumberOfDeliveries();

    int getNumberOfProducts();

    void setDeliveryCost(double cost);
}
