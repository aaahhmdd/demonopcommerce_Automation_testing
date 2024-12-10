package org.example.Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/Features",
        glue = "org/example/StepDefinitions",
        tags = "@smoke",
        plugin = {"pretty",  "html:target/cucumber-reports.html"}
)

public class testRunner extends AbstractTestNGCucumberTests {
}
