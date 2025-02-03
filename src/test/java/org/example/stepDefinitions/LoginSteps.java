package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.example.pages.LoginPage;
import org.testng.Assert;

public class LoginSteps {
    private LoginPage loginPage = new LoginPage();

    @Given("I am on the login page")
    public void navigateToLoginPage() {
        loginPage.navigateToLoginPage();
    }

    @When("I enter username {string} and password {string}")
    public void enterCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("I click the login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should see the welcome message")
    public void verifyWelcomeMessage() {
        Assert.assertTrue(loginPage.isUserLoggedIn(), "Login failed");
    }

    @Then("I should see an error message")
    public void verifyErrorMessage() {
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed");
    }

    @And("I click logout")
    public void clickLogoutButton() {
        loginPage.clickLogoutButton();
    }
}