package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P03_homePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D08_WishlistStepDef {

    WebDriver driver = Hooks.getDriver();
    P03_homePage homePage = new P03_homePage(driver);
    SoftAssert softAssert = new SoftAssert();



    @When("user adds HTC to the wishlist")
    public void user_adds_HTC_to_the_wishlist() {
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
            homePage.clickOnHtcWishList();
    }

    @Then("success message {string} is displayed")
    public void success_message_is_displayed(String expectedMessage) {
        try {
            Thread.sleep(10000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actualMessage = homePage.showMsg();
        softAssert.assertTrue(actualMessage.contains(expectedMessage), "Success message is incorrect.");
    }

    @And("the background color of the message is green")
    public void the_background_color_of_the_message_is_green() {
        try {
            Thread.sleep(10000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        String backgroundColor = homePage.getColorMsg();
        System.out.println(backgroundColor);
        String hexColor = Color.fromString(backgroundColor).asHex();
        softAssert.assertEquals(hexColor, "rgba(255, 255, 255, 1)", "Background color is not green.");
        softAssert.assertAll();
    }

    @When("success message disappears")
    public void success_message_disappears() {
        try {
            Thread.sleep(10000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement msg = driver.findElement(homePage.getSuccessMessage());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(msg));
    }

    @And("user navigates to the Wishlist tab")
    public void user_navigates_to_the_wishlist_tab() {
        try {
            Thread.sleep(10000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.clickOnWishlistTab();
    }
    @Then("wishlist quantity is greater than 0")
    public void wishlist_quantity_is_greater_than_0() {
        try {
            Thread.sleep(10000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        int qty = homePage.getQuantity();
        softAssert.assertTrue(qty > 0, "Wishlist quantity is not greater than 0.");
        softAssert.assertAll();
    }

}
