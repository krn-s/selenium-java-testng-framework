# Selenium Java TestNG Automation Framework

![Java](https://img.shields.io/badge/Java-11-orange)
![Selenium](https://img.shields.io/badge/Selenium-4.15.0-green)
![TestNG](https://img.shields.io/badge/TestNG-7.9.0-red)
![Maven](https://img.shields.io/badge/Maven-Build-blue)

## 📌 About
A scalable UI Automation Framework built with Java, Selenium WebDriver, 
TestNG, and Page Object Model (POM) — tested against SauceDemo e-commerce application.

## 🏗️ Framework Architecture
- **Design Pattern:** Page Object Model (POM)
- **Test Runner:** TestNG
- **Build Tool:** Maven
- **Reporting:** TestNG Surefire Reports
- **Browser Management:** WebDriverManager (auto driver setup)

## 📂 Project Structure
src/

├── main/java/com/karansharma/

│   ├── base/         → BaseDriver (WebDriver setup & teardown)

│   ├── pages/        → Page Object classes

│   └── utils/        → ConfigReader utility

└── test/

├── java/com/karansharma/tests/  → Test classes

└── resources/

├── config.properties        → Test configuration

└── testng.xml               → Test suite definition

## ✅ Test Coverage
| Test Class | Test Case | Status |
|---|---|---|
| LoginTest | Valid login redirects to dashboard | ✅ |
| LoginTest | Invalid credentials shows error | ✅ |
| LoginTest | Empty credentials shows error | ✅ |
| DashboardTest | Products title visible after login | ✅ |
| DashboardTest | Cart icon visible on dashboard | ✅ |
| DashboardTest | 6 inventory items displayed | ✅ |
| DashboardTest | Add to cart updates badge count | ✅ |

## 🚀 How to Run

### Prerequisites
- Java JDK 11+
- Maven 3.6+
- Chrome Browser

### Run all tests
```bash
mvn clean test
```

### View Report
```bash
start target/surefire-reports/index.html
```

## 🔧 Configuration
Edit `src/test/resources/config.properties` to change:
```properties
base.url=https://www.saucedemo.com
username=standard_user
password=secret_sauce
browser=chrome
```
