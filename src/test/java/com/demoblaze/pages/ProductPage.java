package com.demoblaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(className = "name")
    private WebElement productName;

    @FindBy(className = "price-container")
    private WebElement productPrice;

    @FindBy(linkText = "Add to cart")
    private WebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public String getProductName() {
        wait.until(ExpectedConditions.visibilityOf(productName));
        return productName.getText();
    }

    public double getProductPrice() {
        String priceText = productPrice.getText();
        String numericPart = priceText.replace("$", "").split(" ")[0].trim();
        return Double.parseDouble(numericPart);
    }

    public void addToCart() {
        addToCartButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
}
