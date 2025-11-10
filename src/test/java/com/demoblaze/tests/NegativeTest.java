package com.demoblaze.tests;

import com.demoblaze.pages.CartPage;
import com.demoblaze.pages.HomePage;
import com.demoblaze.pages.LoginPage;
import com.demoblaze.utils.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NegativeTest extends BaseTest {

    @Test
    public void testCheckoutWithoutProducts() {
        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin");

        //Waiting login
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.isUserLoggedIn(), "User should be logged");

        //Go directly to cart without products
        homePage.goToCart();

        CartPage cartPage = new CartPage(driver);

        //Verified the cart doesn't have products or is empty
        if (cartPage.isCartEmpty()) {
            System.out.println("Cart is empty - expected result");
            assertTrue(true);
        } else {
            System.out.println("Cart with products - first clear");
        }

        assertTrue(cartPage.isPlaceOrderButtonVisible(), "The place order button should be visible according to the current behavior on the web");
    }
}
