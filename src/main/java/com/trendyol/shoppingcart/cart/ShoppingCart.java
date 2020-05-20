package com.trendyol.shoppingcart.cart;

import com.trendyol.shoppingcart.delivery.Deliverable;
import com.trendyol.shoppingcart.discount.*;
import com.trendyol.shoppingcart.discount.campaign.Campaign;
import com.trendyol.shoppingcart.discount.campaign.CampaignManager;
import com.trendyol.shoppingcart.product.Category;
import com.trendyol.shoppingcart.product.Product;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class ShoppingCart implements Discountable, Deliverable {

    private Set<Discountable> items = new HashSet<>();
    private Set<Category> categories = new HashSet<>();
    private double totalPrice;
    private double deliveryCost;
    private double campaignDiscount;
    private double couponDiscount;


    public void addItem(Product product, int quantity) {
        if (product != null && quantity != 0) {
            items.add(new CartItem(product, quantity));
            this.categories.add(product.getCategory());
            this.totalPrice += product.getPrice() * quantity;
        }
    }

    public void applyCampaigns(Campaign... campaigns) {
        CampaignManager campaignManager = new CampaignManager();

        this.setCampaignDiscount(campaignManager.applyCampaigns(this.items, campaigns));
    }

    public int getNumberOfCategories() {
        return this.categories.size();
    }



    public double getTotalAmountAfterDiscounts() {
        return this.totalPrice - getCampaignDiscount() - getCouponDiscount();
    }

    public double getCouponDiscount() {
        return this.couponDiscount;
    }

    public double getCampaignDiscount() {
        return this.campaignDiscount;
    }

    public double getDeliveryCost() {
        return this.deliveryCost;
    }

    public void setDeliveryCost(double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public void setCampaignDiscount(double campaignDiscount) {
        this.campaignDiscount = campaignDiscount;
    }

    public void setCouponDiscount(double couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public void print() {

        System.out.println(this.toString());
    }

    @Override
    public int getNumberOfProducts() {
        return this.items.size();
    }

    @Override
    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public void applyDiscount(Discount discount) {
        if (discount.isDiscountApplicable(this)) {
            this.couponDiscount += discount.calculateDiscount(this.getTotalAmountAfterDiscounts());
            items.forEach(item -> item.applyDiscount(discount));
        }
    }

    @Override
    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    @Override
    public int getNumberOfDeliveries() {
        return this.getNumberOfCategories();
    }

    @Override
    public String toString() {
        StringJoiner sb = new StringJoiner(System.lineSeparator());
        this.items.stream().collect(groupingBy(item -> ((CartItem) item).getProduct().getCategory())).forEach((category, items) ->
        {
            items.forEach(subItem -> sb.add(subItem.toString()));
        });

        sb.add("Summary");
        sb.add("Total Price: " + this.totalPrice);
        sb.add("Coupon Discount: " + this.getCouponDiscount());
        sb.add("Campaign Discount: " + this.getCampaignDiscount());
        sb.add("Total Discounted Price: " + this.getTotalAmountAfterDiscounts());
        sb.add("Delivery Price: " + this.getDeliveryCost());
        sb.add("Total Amount With Delivery: " + (this.getTotalAmountAfterDiscounts() + this.getDeliveryCost()));
        return sb.toString();
    }
}
