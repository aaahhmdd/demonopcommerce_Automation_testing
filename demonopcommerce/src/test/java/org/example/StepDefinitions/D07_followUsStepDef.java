package org.example.StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P03_homePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class D07_followUsStepDef {

    WebDriver driver = Hooks.getDriver();
    P03_homePage homePage = new P03_homePage(driver);

    @When("user clicks on the Facebook link")
    public void user_clicks_on_the_facebook_link() {
        homePage.clickOnFaceBook();
    }

    @When("user clicks on the Twitter link")
    public void user_clicks_on_the_twitter_link() {
        homePage.clickOnTwitter();
    }

    @When("user clicks on the RSS link")
    public void user_clicks_on_the_rss_link() {
        homePage.clickOnRss();
    }

    @When("user clicks on the YouTube link")
    public void user_clicks_on_the_you_tube_link() {
        homePage.clickOnYoutube();
    }

    @Then("{string} is opened in a new tab")
    public void is_opened_in_a_new_tab(String string) {
        // Wait for 2 seconds for new tab to open
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(windowHandles);

        // Switch to the second tab
        driver.switchTo().window(tabs.get(1));

        // Verify the URL
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, string, "URL did not match the expected value!");

        // Close the new tab and switch back to the first tab
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }
    
}
