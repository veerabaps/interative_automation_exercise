package org.example.stepDefinitions;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.example.pages.HomePage;
import org.example.pages.ContactPage;
import org.testng.Assert;

public class ContactUsSteps {
    private HomePage homePage = new HomePage();
    private ContactPage contactPage = new ContactPage();

    @When("I navigate to the Contact Us page")
    public void navigateToContactPage() {
        homePage.goToContactUs();
    }

    @When("I submit the form with name {string}, email {string}, and message {string}")
    public void submitContactForm(String name, String email, String message) {
        contactPage.submitForm(name, email, message);
    }

    @Then("I should see a success message")
    public void verifySuccessMessage() {
        Assert.assertTrue(contactPage.isSuccessMessageDisplayed(), "Form submission failed");
    }
}