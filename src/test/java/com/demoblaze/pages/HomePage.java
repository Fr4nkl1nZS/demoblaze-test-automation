package com.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "cat")
    private WebElement categoriesTitle;

    @FindBy(xpath = "//a[@id='itemc']")
    private List<WebElement> categories;

    @FindBy(id = "logout2")
    private WebElement logoutButton;

    @FindBy(id = "nameofuser")
    private WebElement userNameLabel;

    @FindBy(className = "card-title")
    private List<WebElement> productTitles;

    @FindBy(xpath = "//div[@class='card h-100']//a")
    private List<WebElement> productLinks;

    @FindBy(id = "cartur")
    private WebElement cartLink;

    @FindBy(id = "nava")
    private WebElement homeLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public boolean isCategoriesDisplayed() {
        return categoriesTitle.isDisplayed();
    }

    public boolean verifyCategoryExists(String categoryName) {
        return categories.stream()
                .anyMatch(category -> category.getText().equals(categoryName));
    }

    public List<String> getCategoryNames() {
        return categories.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public boolean isUserLoggedIn() {
        try {
            wait.until(ExpectedConditions.visibilityOf(userNameLabel));
            return userNameLabel.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getLoggedInUserName() {
        return userNameLabel.getText();
    }

    public void selectCategory(String categoryName) {
        for (WebElement category : categories) {
            if (category.getText().equalsIgnoreCase(categoryName)) {
                category.click();
                wait.until(ExpectedConditions.urlContains("#"));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                break;
            }
        }
    }

    public void selectProducts(String productName) {
        List<WebElement> currentProductLinks = productLinks;

        for (WebElement product : productLinks) {
            if (product.getText().equalsIgnoreCase(productName)) {
                product.click();
                break;
            }
        }
    }
    public boolean isProductDisplayed(String productName) {
        List<WebElement> currentProductLinks = productLinks;

        for (WebElement product : productTitles) {
            if (product.getText().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    public List<String> getProductTitles() {
        List<WebElement> currentProductLinks = productLinks;

        return productTitles.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void goToCart() {
        cartLink.click();
    }

    public void goToHome() {
        homeLink.click();
    }
}
