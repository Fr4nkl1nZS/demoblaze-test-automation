package com.demoblaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(id = "country")
    private WebElement countryInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "card")
    private WebElement creditCardInput;

    @FindBy(id = "month")
    private WebElement monthInput;

    @FindBy(id = "year")
    private WebElement yearInput;

    @FindBy(xpath = "//button[text()='Purchase']")
    private WebElement purchaseButton;

    @FindBy(xpath = "//div[contains(@class,'sweet-alert')]")
    private WebElement confirmationAlert;

    @FindBy(xpath = "//h2[contains(text(), 'Thank you for your purchase!')]")
    private WebElement thankYouMessage;

    @FindBy(xpath = "//div[contains(@class,'sweet-alert'=]//h2")
    private WebElement alertTitle;

    @FindBy(xpath = "//button[text()='OK']")
    private WebElement okButton;

    @FindBy(xpath = "//p[@class='lead text-muted ']")
    private WebElement orderDetails;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void fillCheckoutForm(String name, String country, String city, String creditCard, String month, String year) {
        wait.until(ExpectedConditions.visibilityOf(nameInput));

        nameInput.clear();
        nameInput.sendKeys(name);

        countryInput.clear();
        countryInput.sendKeys(country);

        cityInput.clear();
        cityInput.sendKeys(city);

        creditCardInput.clear();
        creditCardInput.sendKeys(creditCard);

        monthInput.clear();
        monthInput.sendKeys(month);

        yearInput.clear();
        yearInput.sendKeys(year);
    }

    public void completePurchase() {
        wait.until(ExpectedConditions.elementToBeClickable(purchaseButton));
        purchaseButton.click();
    }

    public boolean isPurchaseSuccessful() {
        try {
            WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(15));

            try {
                longWait.until(ExpectedConditions.visibilityOf(thankYouMessage));
                System.out.println("Thank you message found: " + thankYouMessage.getText());
                return true;
            } catch (Exception e1) {
                System.out.println("Thank you message not found, trying alert title");
            }

            try {
                longWait.until(ExpectedConditions.visibilityOf(alertTitle));

                String titleText = alertTitle.getText();
                System.out.println("Alert title found: " + titleText);
                if (titleText.contains("Thank you") || titleText.contains("success")) {
                    return true;
                }
            } catch (Exception e2) {
                System.out.println("Alert title not found, trying confirmation alert...");
            }

            try {
                longWait.until(ExpectedConditions.visibilityOf(confirmationAlert));
                String alertText = confirmationAlert.getText();
                System.out.println("Confirmation alert text: " + alertText);
                if (alertText.contains("Thank you") || alertText.contains("success")) {
                    return true;
        }
    } catch (Exception e3) {
                System.out.println("Confirmation alert not found, checking page source...");
            }

            String pageSource = driver.getPageSource();
            boolean foundInSource = pageSource.contains("Thank you for your purchase");
            System.out.println("Found in page source: " + foundInSource);
            return foundInSource;
} catch(Exception e){
        System.out.println("Purchase success detection failed: "+e.getMessage());
        return false;
        }
    }

    public boolean isPurchaseSuccessfulSimple() {
        try {
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

            wait1.until(ExpectedConditions.visibilityOf(thankYouMessage));
            System.out.println("Purchase successful - Thank you message displayed");
            return true;
        } catch (Exception e) {
            System.out.println("Purchase confirmation not found: " + e.getMessage());
            return false;
        }
    }

    public String getConfirmationMessage() {
        try {
            if (thankYouMessage.isDisplayed()) {
                return thankYouMessage.getText();
            }
            if (alertTitle.isDisplayed()) {
                return alertTitle.getText();
            }
            return confirmationAlert.getText();
        } catch (Exception e) {
            return "No confirmation message found";
        }
    }

    public WebElement getConfirmationElement() {
        try {
            if (thankYouMessage.isDisplayed())
                return thankYouMessage;
            if (alertTitle.isDisplayed())
                return alertTitle;
            return confirmationAlert;
        } catch (Exception e) {
            return confirmationAlert;
        }
    }

    public void debugPurchaseStatus() {
        System.out.println("=== DEBUG PURCHASE STATUS ===");
        System.out.println("Current url: " + driver.getCurrentUrl());
        System.out.println("Page title: " + driver.getTitle());

        try {
            boolean thankYouVisible = thankYouMessage.isDisplayed();
            System.out.println("Thank you message displayed: " + thankYouVisible);
            if (thankYouVisible) {
                System.out.println("Thank you message text: " + thankYouMessage.getText());
            }
        } catch (Exception e) {
            System.out.println("Thank you message no found");
        }

        try {
            boolean alertTitleVisible = alertTitle.isDisplayed();
            System.out.println("Alert title displayed: " + alertTitleVisible);
            if (alertTitleVisible) {
                System.out.println("Alert title text: " + alertTitle.getText());
            }
        } catch (Exception e) {
            System.out.println("Alert title not found");
        }

        System.out.println("=== END DEBUG ===");
    }

    public void confirmPurchase() {
        okButton.click();
    }

    public String getOrderDetails() {
        return orderDetails.getText();
    }
}
