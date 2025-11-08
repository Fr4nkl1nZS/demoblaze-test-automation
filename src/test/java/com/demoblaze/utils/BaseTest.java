package com.demoblaze.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriver wait;

    @BeforeEach
    public void setUp() {
        // Setting chromeDriver automatic
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
}
