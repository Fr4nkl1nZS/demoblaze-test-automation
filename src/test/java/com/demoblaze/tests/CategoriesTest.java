package com.demoblaze.tests;

import com.demoblaze.pages.HomePage;
import com.demoblaze.utils.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CategoriesTest extends BaseTest {

    @Test
    public void testsCategoriesExist() {
        HomePage homePage = new HomePage(driver);

        assertTrue(homePage.isCategoriesDisplayed(), "The categories should be visible");

        //Verified the required categories exist
        assertTrue(homePage.verifyCategoryExists("Phones"), "The Phone folder should be exist");
        assertTrue(homePage.verifyCategoryExists("Laptops"), "The laptops folder should be exist");
        assertTrue(homePage.verifyCategoryExists("Monitors"), "The Monitors folder should be exist");
    }

    @Test
    public void testCategoriesShowCorrectProducts() {
        HomePage homePage = new HomePage(driver);

        //Test Phone category
        homePage.selectCategory("Phones");
        assertFalse(homePage.getProductTitles().isEmpty(), "The phone category should show products");

        // Test Laptops category
        homePage.selectProducts("Laptops");
        assertFalse(homePage.getProductTitles().isEmpty(), "The laptops category should show products");

        //Test Monitors category
        homePage.selectCategory("Monitors");
        assertFalse(homePage.getProductTitles().isEmpty(), "The Monitors category should show products");
    }
}
