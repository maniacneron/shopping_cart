package com.trendyol.shoppingcart.product;


import java.util.Objects;

public class Product {

    private String title;

    private double price;

    private Category category;


    public Product(String title, double price, Category category) {

        this.category = category;
        this.price = price;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(title, product.title) &&
                Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, category);
    }

    @Override
    public String toString() {
        return "- Product:" +
                "Name='" + title + '\'' +
                ", Unit Price=" + price +
                ", Category=" + category;
    }
}
