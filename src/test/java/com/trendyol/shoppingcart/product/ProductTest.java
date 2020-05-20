package com.trendyol.shoppingcart.product;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void CreateProduct() {
        Category category = new Category("Food");
        Product product = new Product("apple",10,category);

        Assert.assertTrue(product.getTitle().equals("apple"));
        Assert.assertEquals(product.getPrice(),10,0);
        Assert.assertNotEquals(product.getCategory(),null);

    }

    @Test
    public void equalsProductsWithSameCategoryDifferentTitleShouldReturnFalse(){
        Category category = new Category("Food");
        Product apple = new Product("apple",10,category);
        Product banana = new Product("banana",10,category);

        Assert.assertFalse(apple.equals(banana));
    }

    @Test
    public void equalsProductsWithSameCategorySameTitleShouldReturnTrue(){
        Category category = new Category("Food");
        Product apple = new Product("apple",10,category);
        Product apple2 = new Product("apple",10,category);

        Assert.assertTrue(apple.equals(apple2));
    }

    @Test
    public void equalsProductsWithDifferentCategorySameTitleShouldReturnFalse(){
        Category food = new Category("Food");
        Category technology = new Category("Technology");
        Product apple = new Product("apple",10,food);
        Product apple2 = new Product("apple",10,technology);

        Assert.assertFalse(apple.equals(apple2));
    }
}
