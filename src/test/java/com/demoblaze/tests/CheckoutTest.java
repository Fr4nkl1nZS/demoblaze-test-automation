package com.demoblaze.tests;

import com.demoblaze.pages.*;
import com.demoblaze.utils.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class CheckoutTest extends BaseTest {

    @Test
    public void testCompletePurchaseFlow() {

        //Loggin
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin");

        //Wait loggin
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.isUserLoggedIn(), "User should be logged");

        //Add product to cart
        homePage.selectProducts("Samsung Galaxy s6");

        ProductPage productPage = new ProductPage(driver);

        productPage.addToCart();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // go to the cart and prosed with the checkout
        homePage.goToCart();

        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.getCartItemsCount() > 0, "Cart should had products");

        cartPage.placeOrder();

        //completed checkout
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillCheckoutForm("Juan Perez", "Mexico", "CDMX", "4111111111111111", "12", "2025");

        //Verified success purchase
        checkoutPage.completePurchase();

       //Debug: check what's happening
        checkoutPage.debugPurchaseStatus();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean isSuccess = checkoutPage.isPurchaseSuccessful();
        System.out.println("Purchase successful (simple method): " + isSuccess);
        assertTrue(isSuccess, "Purchase should complete successful and show confirmation");

        checkoutPage.confirmPurchase();
    }
}
