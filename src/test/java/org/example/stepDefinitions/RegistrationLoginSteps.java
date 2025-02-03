package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.testng.Assert;

public class RegistrationLoginSteps {
    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();

    @Given("I am on the Automation Exercise homepage")
    public void navigateToHomepage() {
        homePage.navigate();
    }


    @When("I navigate to the Signup or login page")
    public void navigateToLoginPage() {
        homePage.goToLogin();
    }




    @When("I register with email {string} and name {string}")
    public void registerUser(String email, String name) {
        // Fill out the registration form
        loginPage.fillRegistrationForm(
                name, email, "Password123", "Mr", "10", "May", "1990",
                "Veer", "Bap", "Example Company", "123 Main St", "United States",
                "California", "Los Angeles", "90001", "1234567890"
        );

        // Submit the form
        loginPage.submitRegistrationForm();
    }

    @Then("I should see the account creation success message")
    public void verifyAccountCreation() {

        Assert.assertTrue(loginPage.isAccountCreated(), "Account creation failed");
    }

    @When("I login with email {string} and password {string}")
    public void login(String email, String password) {
        loginPage.login(email, password);
    }

    @Then("I should be logged in successfully")
    public void verifyLogin() {
        Assert.assertTrue(homePage.isUserLoggedIn(), "Login failed");
    }

}