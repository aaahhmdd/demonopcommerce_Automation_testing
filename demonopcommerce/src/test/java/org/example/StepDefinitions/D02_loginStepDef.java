package org.example.StepDefinitions;

import org.example.Pages.P02_login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.testng.asserts.SoftAssert;

public class D02_loginStepDef {

    P02_login loginPage;
    SoftAssert softAssert = new SoftAssert();

    @Given("user goes to the login page")
    public void user_goes_to_the_login_page() {
        loginPage = new P02_login(Hooks.getDriver());
        loginPage.navigateToLoginPage();
    }

    @When("user logs in with {string} email {string} and password {string}")
    public void user_logs_in_with_email_and_password(String ignoredType, String username, String password) {
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
    }

    @And("user presses the login button")
    public void user_presses_the_login_button() {
        try {
            Thread.sleep(1000); // Wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loginPage.clickLoginButton();
        try {
            Thread.sleep(1000); // Wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("user {string} login to the system")
    public void user_login_to_the_system(String type) {
        try {
            Thread.sleep(1000); // Wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (type.equalsIgnoreCase("valid")) {
            softAssert.assertEquals(loginPage.getCurrentUrl(),"https://demo.nopcommerce.com/");
            try {
                Thread.sleep(1000); // Wait for 5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            softAssert.assertTrue(loginPage.isAccTabEnabled());
        } else {
            softAssert.assertTrue(loginPage.isErrorMsgContains("Login was unsuccessful"));
            try {
                Thread.sleep(1000); // Wait for 5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            softAssert.assertEquals(loginPage.MSGColor(),"#e4434b");
        }
        softAssert.assertAll();
    }
}


