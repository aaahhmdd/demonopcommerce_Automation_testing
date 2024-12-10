package org.example.StepDefinitions;

import org.example.Pages.P01_RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;


public class D01_Registration {

    P01_RegisterPage RegisterPage;
    SoftAssert softAssert = new SoftAssert();

    @Given("user open register page")
    public void user_open_register_page() {
        RegisterPage = new P01_RegisterPage(Hooks.getDriver());
        RegisterPage.navigateToRegPage();
        
    }
    @When("user select gender type")
    public void user_select_gender_type() {
        RegisterPage.selectGenderFemale();
        
    }
    @When("user enter first name and last name")
    public void user_enter_first_name_and_last_name() {
        RegisterPage.setFirstName("automation");
        try {
            Thread.sleep(1000); // Wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RegisterPage.setLastName("tester");
        try {
            Thread.sleep(1000); // Wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @When("user enter date of birth")
    public void user_enter_date_of_birth() {
        try {
            Thread.sleep(1000); // Wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RegisterPage.selectDateOfBirthDay("1");
        try {
            Thread.sleep(1000); // Wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RegisterPage.selectDateOfBirthMonth("1");
        try {
            Thread.sleep(1000); // Wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RegisterPage.selectDateOfBirthYear("2000");
        try {
            Thread.sleep(1000); // Wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @When("user enter email field")
    public void user_enter_email_field() {
        RegisterPage.setEmail("test@example.com");
        try {
            Thread.sleep(1000); // Wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @When("user fills Password fields")
    public void user_fills_password_fields() {
        RegisterPage.setPassword("P@ssw0rd");
        try {
            Thread.sleep(1000); // Wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RegisterPage.setConfirmPassword("P@ssw0rd");
        try {
            Thread.sleep(1000); // Wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @When("user clicks on register button")
    public void user_clicks_on_register_button() {
        RegisterPage.clickRegisterButton();
        try {
            Thread.sleep(1000); // Wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("success message is displayed")
    public void success_message_is_displayed() {
        

        softAssert.assertEquals(RegisterPage.getCurrentUrl(),"https://demo.nopcommerce.com/registerresult/1?returnUrl=/");

        softAssert.assertEquals(RegisterPage.getSuccessMessageText(),"Your registration completed");
        String expectedColor = "rgba(76, 177, 124, 1)";
        softAssert.assertEquals(RegisterPage.getSuccessMessageColor(), expectedColor, "Success message color does not match!");
        softAssert.assertAll();
    }


}

