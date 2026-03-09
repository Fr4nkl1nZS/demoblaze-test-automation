# demoblaze-test-automation
![Java](https://img.shields.io/badge/Java-11-blue)
![Maven](https://img.shields.io/badge/Maven-3.8-red)
![TestNg](https://img.shields.io/badge/TestNG-7.5-green)
![Allure](https://img.shields.io/badge/Allure-Reports-orange)
![Selenium](https://img.shields.io/badge/Selenium-4.0-brightgreen)
![License](https://img.shields.io/badge/license-MIT-lightgrey)

Test automation framework for [Demoblaze](https://www.demoblaze.com/), an e-commerce web aplication. Built with **Java**, **Selenium WebDriver**, **TestNG**, and **Maven**, following the **Page Object Model (POM)** design pattern to ensure maintainability and scalability of tests.

 📋**Features**
   * **Framework:** Selenium WebDriver 4.15.0
   * **Language:** Java 11
   * **Testing:** JUnit 5
   * **Build Tools:** Maven
   * **Design Pattern:** Page Object Model (POM)
   * **Driver Management:** WebDriverManager (automatic driver setup)
   * **Reporting:** Surefire Reports


🚀**Quick Start**

**Prerequisites**
* Java 11 or higher
* Maven 3.6 or higher
* Chrome browser


**Installation & Execution**
1. Clone the repository

    git clone <repository-url>
    cd demoblaze-test-franklin

2. Run all tests

    mvn test

3. Run specific test classes

    # Run single test class
    mvn test -Dtest=LogingTest

    # Run multiple test classes
    mvn test -Dtest="LoginTest,CategoriesTest"

    # Run test specific category
    mvn test -Dtest="*Test"

📁  **Project structure**

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

🧪 **Test coverage**

**Essential Test Cases**
* ✅ **LoginTest:** Valid and invalid credential authentication
* ✅ **CategoriesTest:** Product categories validation (Phones, Laptops, Monitors)
* ✅ **CheckoutTest:** Complete purchase workflow
* ✅ **DynamicValidationTest:** Cart price calculations


**Extended Test Cases**
*✅ **NegativeTest:** Checkout attempts with empty cart


🔧 **Technical stack**

**Dependencies(pom.xml)**

<dependencies>
    <!-- Selenium WebDriver -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.15.0</version>
    </dependency>

    <!-- JUnit 5 -->
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.10.0</version>
        <scope>test</scope>
    </dependency>

    <!-- WebDriver Manager -->
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.6.0</version>
    </dependency>
</dependencies>

**Base Configuration**

WebDriver setup with automatic management:

java
WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

📊 **Test Execution**
**Maven Commands**

# Run all tests
mvn test

# Clean and run tests
mvn clean test

# skip tests during build
mvn package -DskipTests

**Test Reports**
* **Location:** target/surefire-reports/
* **Format:** XML and text reports
* **Content:** Detailed test results and execution times
