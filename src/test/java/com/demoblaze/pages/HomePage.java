package com.demoblaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage {

    private WebDriver driver;

    @FindBy(id = "cat")
    private WebElement categoriesTitle;

    @FindBy(xpath = "//a[@id='itemc']")
    private List<WebElement> categories;

    public HomePage(WebDriver driver) {
        this.driver = driver;
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
}
