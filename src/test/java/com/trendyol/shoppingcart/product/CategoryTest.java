package com.trendyol.shoppingcart.product;

import org.junit.Assert;
import org.junit.Test;

public class CategoryTest {

    @Test
    public void CreateCategory() {
        Category category = new Category("Food");
        Assert.assertTrue(category.getTitle().equals("Food"));
    }

    @Test
    public void equalsCategoriesWithDifferentTitlesShouldReturnFalse(){
        Category food = new Category("Food");
        Category technology = new Category("Technology");
        Assert.assertFalse(food.equals(technology));
    }

    @Test
    public void isAncestorOfCategoriesParent_Technology_Child_Phones_Child_SmartPhones_ShouldReturn_True(){
        Category technology = new Category("Technology");
        Category phones = new Category("Phones");
        phones.setParentCategory(technology);
        Category smartPhones = new Category("Smart Phones");
        smartPhones.setParentCategory(phones);

        Assert.assertTrue(technology.isAncestorOf(smartPhones));
    }

    @Test
    public void isAncestorOfCategory_Parent_Technology_Child_Phones_With_Parent_Null_ShouldReturn_False(){
        Category technology = new Category("Technology");
        Category phones = new Category("Phones");
        Category smartPhones = new Category("Smart Phones");

        Assert.assertFalse(technology.isAncestorOf(smartPhones));
    }
}
