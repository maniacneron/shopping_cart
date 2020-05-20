package com.trendyol.shoppingcart.product;

import java.util.Objects;

public class Category {

    private String title;

    private Category parentCategory = null;

    public Category(String category) {
        this.title = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public boolean isAncestorOf(Category parent) {
        if (parent == null) return false;
        if (parent.equals(this)) return true;

        return isAncestorOf(parent.getParentCategory());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(title, category.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return title;
    }
}
