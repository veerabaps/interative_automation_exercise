package org.example.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.FeatureWrapper;
import org.example.pages.LoginPage;
import org.example.utils.DriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.example.stepDefinitions", "org.example.hooks"}, // Include hooks package
        tags = "@logout or @regression", // Specify the tag to run
        plugin = {
                "pretty",
                "html:test-output/cucumber-reports/cucumber-pretty",
                "json:test-output/cucumber-reports/CucumberTestReport.json"
        }
)


public class RunnerTest extends AbstractTestNGCucumberTests {
    private static final Logger logger = LoggerFactory.getLogger(RunnerTest.class);

    @BeforeSuite
    public void setUpSuite() {
        logger.info("Starting test suite...");
    }

    @AfterSuite
    public void tearDownSuite() {
        logger.info("Test suite finished!");
        DriverManager.quitDriver(); // Quit WebDriver after all tests are executed
    }

    @Override
    @Test(dataProvider = "scenarios")
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        // Log the feature and scenario name
        logger.info("Running feature: " + featureWrapper.toString());
        logger.info("Running scenario: " + pickleWrapper.getPickle().getName());
        // Run the scenario
        super.runScenario(pickleWrapper, featureWrapper);
    }
}