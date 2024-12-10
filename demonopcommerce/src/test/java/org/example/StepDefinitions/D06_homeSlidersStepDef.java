package org.example.StepDefinitions;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P03_homePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D06_homeSlidersStepDef {


    WebDriver driver = Hooks.getDriver();
    P03_homePage homePage = new P03_homePage(driver);


    @When("user clicks on the first slider")
    public void user_clicks_on_the_first_slider() {
        homePage.clickFirstSlider();
    }
    @Then("user should be directed to {string}")
    public void user_should_be_directed_to(String string) {
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean urlChanged = wait.until(ExpectedConditions.urlContains(string));
        Assert.assertTrue(urlChanged, "Expected URL to be: " + string + ", but was: " + driver.getCurrentUrl());

        //softAssert.assertEquals(homePage.getCurrentURL(),string);
    }
    @When("user clicks on the second slider")
    public void user_clicks_on_the_second_slider() {
        homePage.clickSecondSlider();
    }
}
