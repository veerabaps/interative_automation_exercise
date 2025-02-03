package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class ExampleSteps {

    @Given("I have a working Cucumber setup")
    public void i_have_a_working_cucumber_setup() {
        System.out.println("Step 1: Cucumber setup is working.");
    }

    @When("I run the test")
    public void i_run_the_test() {
        System.out.println("Step 2: Running the test...");
    }

    @Then("I should not see a success message")
    public void i_should_see_a_success_message() {
        System.out.println("Step 3: Test executed successfully!");
    }
}