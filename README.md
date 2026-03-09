# demoblaze-test-automation
![Java](https://img.shields.io/badge/Java-11-blue)
![Maven](https://img.shields.io/badge/Maven-3.8-red)
![TestNg](https://img.shields.io/badge/TestNG-7.5-green)
![Allure](https://img.shields.io/badge/Allure-Reports-orange)
![Selenium](https://img.shields.io/badge/Selenium-4.0-brightgreen)
![License](https://img.shields.io/badge/license-MIT-lightgrey)

Test automation framework for [Demoblaze](https://www.demoblaze.com/), an e-commerce web aplication. Built with **Java**, **Selenium WebDriver**, **TestNG**, and **Maven**, following the **Page Object Model (POM)** design pattern to ensure maintainability and scalability of tests.

## 📋 Table of Contents
- [Tech Stack](#-tech-stack)
- [Key Features](#-key-features)
- [Prerequisites](#-prerequisites)
- [Installation](#-installation)
- [Project Structure](#-project-structure)
- [Configuration](#-configuration)
- [Running Tests](#-running-tests)
- [Reporting](#-reporting)
- [CI/CD Integration](#-cicd-integration)
- [Docker Support](#-docker-support)
- [Best Practices Implemented](#-best-practices-implemented)
- [Troubleshooting](#-troubleshooting)
- [Contributing](#-contributing)
- [Contact](#-contact)

## 🛠️ Tech Stack

| Technology | Purpose |
|------------|---------|
| **Java 11** | Core programming language |
| **Selenium WebDriver 4** | Browser automation |
| **TestNG** | Test framework and parallel execution |
| **Maven** | Build and dependency management |
| **Allure** | Advanced test reporting |
| **Log4j2** | Logging framework |
| **WebDriverManager** | Automatic driver management |
| **GitHub Actions** | CI/CD integration |

## ✨ Key Features

- ✅ **Page Object Model (POM)** - Clean separation between test logic and page elements
- ✅ **Parallel Execution** - Run tests in parallel using TestNG
- ✅ **Data-Driven Testing** - External test data from JSON/Excel
- ✅ **Automatic Screenshots** - Capture screenshots on test failure
- ✅ **Comprehensive Logging** - Detailed logs with Log4j2
- ✅ **Cross-Browser Testing** - Chrome, Firefox, Edge support
- ✅ **Allure Reports** - Beautiful and interactive test reports
- ✅ **CI/CD Ready** - GitHub Actions integration
- ✅ **Docker Support** - Containerized test execution

## 📋 Prerequisites

- **Java JDK 11** or higher
- **Maven 3.8** or higher
- **Git**
- **Chrome** / **Firefox** / **Edge** browser (for local execution)
- **Docker** (optional, for containerized execution)

## 🔧 Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/Fr4nkl1nZS/demoblaze-test-automation.git
   cd demoblaze-test-automation
Install dependencies

bash
mvn clean install
Verify installation

bash
mvn --version
java --version
📁 Project Structure
text
demoblaze-test-automation/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── demoblaze/
│   │               ├── pages/           # Page Object classes
│   │               │   ├── HomePage.java
│   │               │   ├── LoginPage.java
│   │               │   ├── ProductPage.java
│   │               │   └── CartPage.java
│   │               └── utils/           # Utility classes
│   │                   ├── ConfigReader.java
│   │                   ├── ExcelReader.java
│   │                   └── ScreenshotUtil.java
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── demoblaze/
│       │           ├── tests/           # Test classes
│       │           │   ├── LoginTest.java
│       │           │   ├── ProductTest.java
│       │           │   └── CartTest.java
│       │           └── base/             # Base test class
│       │               └── BaseTest.java
│       └── resources/
│           ├── testdata/                  # Test data files
│           │   └── test-data.json
│           ├── log4j2.xml                  # Logging configuration
│           └── allure.properties           # Allure configuration
├── test-output/                             # Test reports
├── screenshots/                             # Failure screenshots
├── logs/                                     # Application logs
├── pom.xml                                   # Maven configuration
├── testng.xml                                # TestNG suite configuration
└── README.md                                 # This file
⚙️ Configuration
TestNG Configuration (testng.xml)
xml
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Demoblaze Test Suite" parallel="tests" thread-count="3">
    <test name="Chrome Tests">
        <parameter name="browser" value="chrome"/>
        <classes>
            <class name="com.demoblaze.tests.LoginTest"/>
            <class name="com.demoblaze.tests.ProductTest"/>
        </classes>
    </test>
    <test name="Firefox Tests">
        <parameter name="browser" value="firefox"/>
        <classes>
            <class name="com.demoblaze.tests.CartTest"/>
        </classes>
    </test>
</suite>
Maven Configuration (pom.xml - key dependencies)
xml
<dependencies>
    <!-- Selenium -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.15.0</version>
    </dependency>
    
    <!-- TestNG -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.8.0</version>
    </dependency>
    
    <!-- WebDriverManager -->
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.6.2</version>
    </dependency>
    
    <!-- Allure -->
    <dependency>
        <groupId>io.qameta.allure</groupId>
        <artifactId>allure-testng</artifactId>
        <version>2.24.0</version>
    </dependency>
</dependencies>
🏃 Running Tests
Run all tests
bash
mvn clean test
Run specific test class
bash
mvn -Dtest=LoginTest test
Run tests by groups
bash
mvn -Dgroups="smoke" test
Run tests in specific browser
bash
# Chrome (default)
mvn test -Dbrowser=chrome

# Firefox
mvn test -Dbrowser=firefox

# Edge
mvn test -Dbrowser=edge
Run tests in headless mode
bash
mvn test -Dheadless=true
Run tests with specific TestNG suite
bash
mvn test -DsuiteXmlFile=testng.xml
📝 Test Example
Page Object Example (src/main/java/com/demoblaze/pages/LoginPage.java)
java
package com.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    
    // Locators
    private By usernameField = By.id("loginusername");
    private By passwordField = By.id("loginpassword");
    private By loginButton = By.xpath("//button[text()='Log in']");
    private By closeButton = By.xpath("//div[@id='logInModal']//button[text()='Close']");
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
    }
    
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
    
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
    
    public void closeModal() {
        driver.findElement(closeButton).click();
    }
}
Test Example (src/test/java/com/demoblaze/tests/LoginTest.java)
java
package com.demoblaze.tests;

import com.demoblaze.base.BaseTest;
import com.demoblaze.pages.LoginPage;
import org.testng.annotations.Test;
import org.testng.Assert;

public class LoginTest extends BaseTest {
    
    @Test(description = "Verify login with valid credentials")
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        
        // Navigate to login
        homePage.clickLogin();
        
        // Perform login
        loginPage.login("testuser", "password123");
        
        // Wait for alert and accept
        waitForAlertAndAccept();
        
        // Verify login success (check if user name appears)
        Assert.assertTrue(homePage.isUserLoggedIn(), "User should be logged in");
    }
    
    @Test(description = "Verify login with invalid credentials")
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        
        homePage.clickLogin();
        loginPage.login("invalid", "invalid");
        
        String alertText = getAlertText();
        Assert.assertTrue(alertText.contains("Wrong password"), 
            "Error message should indicate wrong password");
        acceptAlert();
    }
}
📊 Reporting
Allure Reports
Generate and serve Allure reports:

bash
# Run tests and generate Allure results
mvn clean test

# Serve Allure report (requires Allure CLI)
allure serve target/allure-results

# Or generate HTML report
allure generate target/allure-results --clean -o target/allure-report
Allure Report Features
✅ Test steps with detailed logs

✅ Screenshots on failure

✅ Execution timeline

✅ Categories and severity levels

✅ Environment information

✅ Flaky test detection

Logging with Log4j2
Logs are generated in the logs/ directory with different levels:

INFO: Test execution steps

DEBUG: Detailed debugging information

ERROR: Test failures and exceptions

🔄 CI/CD Integration
GitHub Actions Example
Create .github/workflows/selenium-tests.yml:

yaml
name: Selenium Tests

on:
  push:
    branches: [ main, develop ]
  pull_request:
    branches: [ main ]
  schedule:
    - cron: '0 2 * * *'  # Run daily at 2 AM

jobs:
  test:
    runs-on: ubuntu-latest
    
    strategy:
      matrix:
        browser: [chrome, firefox]
        java-version: [11, 17]
    
    steps:
    - name: Checkout code
      uses: actions/checkout@v3
    
    - name: Setup Java
      uses: actions/setup-java@v3
      with:
        distribution: 'temurin'
        java-version: ${{ matrix.java-version }}
        cache: maven
    
    - name: Setup Chrome
      if: matrix.browser == 'chrome'
      uses: browser-actions/setup-chrome@v1
    
    - name: Setup Firefox
      if: matrix.browser == 'firefox'
      uses: browser-actions/setup-firefox@v1
    
    - name: Run Selenium tests
      run: mvn clean test -Dbrowser=${{ matrix.browser }} -Dheadless=true
    
    - name: Upload Allure results
      if: always()
      uses: actions/upload-artifact@v3
      with:
        name: allure-results-${{ matrix.browser }}-java${{ matrix.java-version }}
        path: target/allure-results/
    
    - name: Upload screenshots on failure
      if: failure()
      uses: actions/upload-artifact@v3
      with:
        name: screenshots-${{ matrix.browser }}
        path: screenshots/
Jenkins Pipeline Example
groovy
pipeline {
    agent any
    
    tools {
        maven 'Maven-3.8'
        jdk 'JDK-11'
    }
    
    parameters {
        choice(
            name: 'BROWSER',
            choices: ['chrome', 'firefox', 'edge'],
            description: 'Browser to run tests on'
        )
        choice(
            name: 'SUITE',
            choices: ['testng.xml', 'smoke-tests.xml', 'regression-tests.xml'],
            description: 'Test suite to execute'
        )
    }
    
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        
        stage('Run Tests') {
            steps {
                sh "mvn clean test -Dbrowser=${params.BROWSER} -DsuiteXmlFile=${params.SUITE}"
            }
            post {
                always {
                    allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'target/allure-results']]
                    ])
                }
            }
        }
    }
    
    post {
        always {
            junit 'target/surefire-reports/*.xml'
            cleanWs()
        }
    }
}
🐳 Docker Support
Dockerfile
dockerfile
FROM maven:3.8-openjdk-11

# Install Chrome
RUN apt-get update && apt-get install -y \
    wget \
    gnupg \
    && wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - \
    && echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list \
    && apt-get update && apt-get install -y google-chrome-stable \
    && rm -rf /var/lib/apt/lists/*

# Install Firefox
RUN apt-get install -y firefox-esr

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
COPY testng.xml .

CMD ["mvn", "clean", "test"]
Docker Compose Example (docker-compose.yml)
yaml
version: '3.8'
services:
  selenium-tests:
    build: .
    environment:
      - BROWSER=chrome
      - HEADLESS=true
    volumes:
      - ./screenshots:/app/screenshots
      - ./target/allure-results:/app/target/allure-results
      - ./logs:/app/logs
    command: mvn clean test -Dbrowser=chrome -Dheadless=true
Docker commands
bash
# Build Docker image
docker build -t demoblaze-tests .

# Run tests in container
docker run --rm \
  -v $(pwd)/screenshots:/app/screenshots \
  -v $(pwd)/target/allure-results:/app/target/allure-results \
  demoblaze-tests

# Run with specific browser
docker run --rm -e BROWSER=firefox demoblaze-tests

# Using docker-compose
docker-compose up --build
🏆 Best Practices Implemented
1. Page Object Model (POM)
Each web page has its own class

Page classes contain locators and methods

Tests only contain business logic

2. Smart Waits
java
// ❌ Avoid
Thread.sleep(3000);

// ✅ Use explicit waits
WebDriverWait wait = new WebDriverWait(driver, 10);
wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
3. Separation of Concerns
Locators → Page Objects

Test Logic → Test Classes

Test Data → External files (JSON/Excel)

Configuration → Properties files

Utilities → Helper classes

4. Robust Selectors
java
// ❌ Avoid brittle XPaths
driver.findElement(By.xpath("//div[2]/div[3]/button"));

// ✅ Use stable selectors
driver.findElement(By.id("login-button"));
driver.findElement(By.cssSelector("[data-testid='submit']"));
5. Automatic Screenshots on Failure
java
@AfterMethod
public void takeScreenshotOnFailure(ITestResult result) {
    if (result.getStatus() == ITestResult.FAILURE) {
        ScreenshotUtil.capture(driver, result.getName());
    }
}
🔍 Troubleshooting
Common Issues and Solutions
Issue: WebDriver version mismatch

bash
# WebDriverManager automatically handles this, but if issues persist:
mvn clean install -U
Issue: Tests failing in headless mode

java
// Add these options in your driver setup
ChromeOptions options = new ChromeOptions();
options.addArguments("--headless");
options.addArguments("--no-sandbox");
options.addArguments("--disable-dev-shm-usage");
options.addArguments("--window-size=1920,1080");
Issue: Element not clickable

java
// Use JavaScript executor as fallback
WebElement element = driver.findElement(By.id("submit"));
JavascriptExecutor executor = (JavascriptExecutor)driver;
executor.executeScript("arguments[0].click();", element);
Issue: Allure report not generating

bash
# Check Java installation
java -version

# Clear previous results
rm -rf target/allure-results

# Regenerate
mvn clean test
allure generate target/allure-results --clean
Issue: Maven dependencies not downloading

bash
# Clear Maven cache
rm -rf ~/.m2/repository

# Rebuild with fresh dependencies
mvn clean install -U
🤝 Contributing
Contributions are welcome! Please follow these steps:

Fork the repository

Create a feature branch

bash
git checkout -b feature/AmazingFeature
Commit your changes

bash
git commit -m 'Add some AmazingFeature'
Push to the branch

bash
git push origin feature/AmazingFeature
Open a Pull Request

Coding Standards
Follow Java naming conventions

Add comments for complex logic

Write descriptive test names

Keep methods short and focused

Use meaningful variable names

Add JavaDoc for public methods

📄 License
Distributed under the MIT License. See LICENSE file for more information.

📧 Contact
Franklin Gonzalez Torres

GitHub: @Fr4nkl1nZS

LinkedIn: Franklin Gonzalez

Email: apostolfranklin1@gmail.com