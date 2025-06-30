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
![image](https://github.com/user-attachments/assets/a4a538da-7cd9-40da-beee-c793e289e1c0)


## ✅ Key Highlights
- 40+ scenarios across 8 core features
- Soft assertions for multiple validations
- Explicit waits and dynamic element handling
- Multi-window/tab switching and color validation
- Maven reporting via Surefire + cucumber-reporting plugins

## ▶️ Run the Tests
```bash
mvn clean verify
