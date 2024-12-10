package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class P02_login {
    WebDriver driver;

    // Locators
    private final By emailField = By.cssSelector("input[class=\"email\"]");
    private final By passwordField = By.cssSelector("input[class=\"password\"]");
    private final By loginButton = By.cssSelector("button[class=\"button-1 login-button\"]");
    private final By successMessage = By.tagName("h2");
    private final By errorMessage = By.cssSelector("div[class=\"message-error validation-summary-errors\"]");
    private final By MyAccTab = By.cssSelector("a[class=\"ico-account\"]");

    // Constructor
    public P02_login(WebDriver driver) {
        this.driver = driver;
    }

    // Page Actions
    public void navigateToLoginPage() {
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isAccTabEnabled(){
        return driver.findElement(MyAccTab).isEnabled();
    }
    public String MSGColor() {
        return Color.fromString(driver.findElement(errorMessage).getCssValue("color")).asHex();
    }

    public String MSG() {
        return driver.findElement(errorMessage).getText();

    }
    public boolean isErrorMsgContains (String msg) {
        return MSG().contains(msg);
    }

}
