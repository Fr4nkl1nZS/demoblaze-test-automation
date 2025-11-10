package com.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//tbody/tr[@class='success']")
    private List<WebElement> cartItems;

    @FindBy(xpath = "//button[text()='Place Order']")
    private WebElement placeOrderButton;

    @FindBy(id = "totalp")
    private WebElement totalPrice;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public int getCartItemsCount() {
        return cartItems.size();
    }

    public boolean isCartEmpty() {
        try {
            return getCartItemsCount() == 0;
        } catch (Exception e) {
            return true;
        }
    }

    public void placeOrder() {
        placeOrderButton.click();
    }

    public double getTotalPrice() {
        try {
            return Double.parseDouble(totalPrice.getText());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    public boolean isPlaceOrderButtonVisible() {
        try {
            return placeOrderButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
