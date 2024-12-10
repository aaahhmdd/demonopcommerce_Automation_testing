package org.example.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P03_homePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class D03_currenciesStepDef {

    WebDriver driver = Hooks.getDriver();
    P03_homePage homePage = new P03_homePage(driver);

    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
        driver.get("https://demo.nopcommerce.com");
    }
    @When("user selects {string} currency from the dropdown")
    public void user_selects_currency_from_the_dropdown(String currency) {
        try {
            Thread.sleep(1000); // Wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.selectCurrency(currency);
    }
    @Then("all products should display prices in Euro")
    public void all_products_should_display_prices_in_Euro() {
        List<WebElement> prices = homePage.getProductPrices();

        for (WebElement price : prices) {
            String priceText = price.getText();
            System.out.println("Product Price: " + priceText);
            Assert.assertTrue(priceText.contains("€"), "Price does not contain Euro symbol!");
        }
    }
}
