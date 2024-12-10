package org.example.StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Hooks {

    // Declare WebDriver instance
    private static WebDriver driver;

    @Before
    public void setup() {
        System.out.println("User opens browser");
        System.setProperty("webdriver.edge.driver", "E:\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Quit the browser after each scenario
            driver = null; // Ensure driver instance is cleared
        }
    }

    // Provide a way for step definition classes to access the WebDriver
    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver not initialized. Make sure the setup method runs before using the driver.");
        }
        return driver;
    }
}
