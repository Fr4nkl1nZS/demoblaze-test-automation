# demoblaze-test-automation
Test automation framework for Demoblaze using Java + Selenium and JYnit 5

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

demoblaze-test-Franklin/
├── src/test/java/com/demoblaze/
│   ├── pages/               # Page Object Classes
│   │   ├── HomePage.java
│   │   ├── LoginPage.java
│   │   ├── ProductPage.java
│   │   ├── CartPage.java
│   │   └── CheckoutPage.java
│   ├── tests/               # Test Classes
│   │   ├── LoginTest.java
│   │   ├── CategoriesTest.java
│   │   ├── CheckoutTest.java
│   │   ├── NegativeTest.java
│   │   └── DynamicValidationTest.java
│   └── utils/
│       └── BaseTest.java    # Test Configuration
├── target/
│   └── surefire-reports/    # Test Reports
├── pom.xml                  # Maven Configuration
└── README.md

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
mcn test

# Clean and run tests
mvn clean test

# skip tests during build
mvn package -DskipTests

**Test Reports**
* **Location:** target/surefire-reports/
* **Format:** XML and text reports
* **Content:** Detailed test results and execution times
