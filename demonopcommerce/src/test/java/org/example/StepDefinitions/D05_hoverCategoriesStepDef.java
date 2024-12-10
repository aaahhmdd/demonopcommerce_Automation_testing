package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class D05_hoverCategoriesStepDef {

    WebDriver driver = Hooks.getDriver();
    P03_homePage homePage = new P03_homePage(driver);
    SoftAssert softAssert = new SoftAssert();
    String selectedSubCategoryText;

    @When("user hovers over a random main category")
    public void user_hovers_over_a_random_main_category() {
        selectedSubCategoryText=homePage.hoverOnMainCategory();
    }
    @And("user clicks on a random sub-category")
    public void user_clicks_on_a_random_sub_category() {
        List<WebElement>subCategoryLinks=homePage.storeSubCategoriesForCategory();
        // minimize implicit wait to not waste time if it's empty
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        selectedSubCategoryText=homePage.selectRandomSubCategory(subCategoryLinks);
    }
    @Then("sub-category page title should match the selected sub-category")
    public void sub_category_page_title_should_match_the_selected_sub_category() {
        // Get the page title
        String pageTitle = homePage.getPageTitle();

        // Assert the page title matches the selected sub-category
        Assert.assertTrue(pageTitle.toLowerCase().trim().contains(selectedSubCategoryText.toLowerCase().trim()),
                "Page title does not match selected sub-category. Expected: " + selectedSubCategoryText + ", but got: " + pageTitle);
    }


}
