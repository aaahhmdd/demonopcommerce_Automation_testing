package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P03_homePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Objects;

public class D04_searchStepDef {

    WebDriver driver = Hooks.getDriver();
    P03_homePage homePage = new P03_homePage(driver);
    SoftAssert softAssert = new SoftAssert();

//    @Given("user is on the home page")
//    public void user_is_on_the_home_page() {
//        driver.get("https://demo.nopcommerce.com");
//    }

    @When("user searches for {string}")
    public void user_searches_for(String product) {
        homePage.searchForProduct(product);
    }

    @Then("the URL should contain")
    public void the_URL_should_contain() {
        softAssert.assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("https://demo.nopcommerce.com/search?q="), "URL does not contain search query");
    }

    @Then("the search results should show relevant results")
    public void the_search_results_should_show_relevant_results() {
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> searchResults = homePage.getSearchResults();
        System.out.println("Number of search results found: " + searchResults.size());
        softAssert.assertTrue(!searchResults.isEmpty(), "No search results found");

        for (WebElement result : searchResults) {
            softAssert.assertTrue(result.getText().toLowerCase().contains(homePage.getSearchKeyword().toLowerCase()), "Result does not contain search keyword");
        }
        softAssert.assertAll();  // Verify soft assertions
    }

    @When("user searches for SKU {string}")
    public void user_searches_for_sku(String sku) {
        homePage.searchForSKU(sku);
    }

    @And("user clicks on the product in the search results")
    public void user_clicks_on_the_product_in_the_search_results() {
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.clickOnFirstSearchResult();
    }

    @Then("the product SKU should match the search SKU {string}")
    public void the_product_sku_should_match_the_search_sku(String sku) {
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        String displayedSku = homePage.getProductSKU();
        softAssert.assertTrue(displayedSku.contains(sku), "Displayed SKU does not match the searched SKU");
        softAssert.assertAll();
    }
}

