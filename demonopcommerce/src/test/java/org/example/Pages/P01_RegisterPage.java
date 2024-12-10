package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class P01_RegisterPage {
    WebDriver driver;

    // Locators
    private final By genderTypeF = By.cssSelector("input[value=\"F\"]");
    private final By genderTypeM = By.cssSelector("input[value=\"M\"]");
    private final By firstName = By.id("FirstName");
    private final By lastName = By.id("LastName");
    private final By dateOfBirthDayDropdown = By.cssSelector("select[name=\"DateOfBirthDay\"]");
    private final By dateOfBirthMonthDropdown = By.cssSelector("select[name=\"DateOfBirthMonth\"]");
    private final By dateOfBirthYearDropdown = By.cssSelector("select[name=\"DateOfBirthYear\"]");
    private final By email = By.id("Email");
    private final By password = By.id("Password");
    private final By confirmPassword = By.id("ConfirmPassword");
    private final By registerButton = By.cssSelector("button[name=\"register-button\"]");
    private final By successMsg = By.className("result");

    // Constructor
    public P01_RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Page Actions
    public void navigateToRegPage(){
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
    }

    public void selectGenderFemale() {
        driver.findElement(genderTypeF).click();
    }

    public void selectGenderMale() {
        driver.findElement(genderTypeM).click();
    }

    public void setFirstName(String firstNameValue) {
        driver.findElement(firstName).sendKeys(firstNameValue);
    }

    public void setLastName(String lastNameValue) {
        driver.findElement(lastName).sendKeys(lastNameValue);
    }

    public void selectDateOfBirthDay(String dayValue) {
        WebElement dayDropdown = driver.findElement(dateOfBirthDayDropdown);
        Select daySelect = new Select(dayDropdown);
        daySelect.selectByValue(dayValue);
    }

    public void selectDateOfBirthMonth(String monthValue) {
        WebElement monthDropdown = driver.findElement(dateOfBirthMonthDropdown);
        Select monthSelect = new Select(monthDropdown);
        monthSelect.selectByValue(monthValue);
    }

    public void selectDateOfBirthYear(String yearValue) {
        WebElement yearDropdown = driver.findElement(dateOfBirthYearDropdown);
        Select yearSelect = new Select(yearDropdown);
        yearSelect.selectByValue(yearValue);
    }

    public void setEmail(String emailValue) {
        driver.findElement(email).sendKeys(emailValue);
    }

    public void setPassword(String passwordValue) {
        driver.findElement(password).sendKeys(passwordValue);
    }

    public void setConfirmPassword(String confirmPasswordValue) {
        driver.findElement(confirmPassword).sendKeys(confirmPasswordValue);
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getSuccessMessageColor() {
        return driver.findElement(successMsg).getCssValue("color");
    }

    public String getSuccessMessageText() {
        return driver.findElement(successMsg).getText();
    }
}
