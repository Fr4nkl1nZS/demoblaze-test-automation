package com.demoblaze.tests;

import com.demoblaze.pages.CartPage;
import com.demoblaze.pages.HomePage;
import com.demoblaze.pages.LoginPage;
import com.demoblaze.pages.ProductPage;
import com.demoblaze.utils.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DynamicValidationTest extends BaseTest {

    @Test
    public void testCartPriceCalculation() {

        //Loggin
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin");

        //waiting login
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        HomePage homePage = new HomePage(driver);

        //Add first product
        homePage.selectProducts("Samsung galaxy s6");
        ProductPage productPage = new ProductPage(driver);
        double firstProductPrice = productPage.getProductPrice();
        System.out.println("First product price: " + firstProductPrice);
        productPage.addToCart();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        homePage.goToHome();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        homePage = new HomePage(driver);

        //Add second product
        homePage.selectProducts("Nokia lumia 1520");
        productPage = new ProductPage(driver);
        double secondProductPrice = productPage.getProductPrice();
        productPage.addToCart();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Go to cart
        homePage.goToCart();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        CartPage cartPage = new CartPage(driver);
        int itemCount = cartPage.getCartItemsCount();
        System.out.println("Products on the cart: " + itemCount);
        assertTrue(itemCount > 0, "Should be have products at the cart");
        double totalPrice = cartPage.getTotalPrice();
        System.out.println("Price total obtained: " + totalPrice);
        double expectedTotal = firstProductPrice + secondProductPrice;
        System.out.println("Total price expected: " + expectedTotal);

        assertEquals(expectedTotal, totalPrice, 0.01, "The total price should be the sum of both products");

    }
}
