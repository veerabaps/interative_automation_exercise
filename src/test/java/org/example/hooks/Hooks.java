package org.example.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.example.pages.LoginPage;
import org.example.utils.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    private LoginPage loginPage;

    public Hooks() {
        this.loginPage = new LoginPage();
    }

    @Before
    public void setUp() {
        // Code to run before each scenario
        System.out.println("Setting up the test environment...");
        DriverManager.getDriver().manage().deleteAllCookies(); // Clear cookies
        DriverManager.getDriver().get("https://automationexercise.com"); // Navigate to the homepage
    }

    @After
    public void tearDown(Scenario scenario) {
        // Code to run after each scenario
        if (scenario.isFailed()) {
            // Capture screenshot
            byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            // Embed screenshot in Cucumber report
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        System.out.println("Tearing down the test environment...");
//        if (loginPage.isUserLoggedIn()) {
//            loginPage.clickLogoutButton(); // Log out if the user is logged in
//        }
    }
}