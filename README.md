# 🛒 nopCommerce Automation Testing (BDD with Selenium)

This project is an end-to-end automation test suite for [nopCommerce](https://demo.nopcommerce.com/) using Selenium WebDriver, Cucumber (BDD), TestNG, and the Page Object Model (POM) design pattern.

## 📌 Features Tested
- ✅ User Registration
- ✅ Login (Valid & Invalid Scenarios)
- ✅ Search (Product name & SKU)
- ✅ Wishlist
- ✅ Currency Selection
- ✅ Social Media Links (multi-tab)
- ✅ Home Page Sliders
- ✅ Category Navigation via Hover

## 🧰 Tech Stack
- Java
- Selenium WebDriver
- Cucumber (Gherkin)
- TestNG
- Maven
- Page Object Model (POM)
- ExtentReports / Cucumber HTML Reports

## 🏗️ Project Structure
src
├── main
│ └── resources
│ └── features (F01_Register.feature, etc.)
├── test
│ └── java
│ └── org.example
│ ├── pages (P01_Register.java, etc.)
│ ├── stepDefs (D01_registerStepDef.java, etc.)
│ └── runners
└── Hooks.java

## ✅ Key Highlights
- 40+ scenarios across 8 core features
- Soft assertions for multiple validations
- Explicit waits and dynamic element handling
- Multi-window/tab switching and color validation
- Maven reporting via Surefire + cucumber-reporting plugins

## ▶️ Run the Tests
```bash
mvn clean verify
