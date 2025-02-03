package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.example.pages.CartPage;
import org.example.pages.CheckoutPage;
import org.example.pages.ProductPage;
import org.testng.Assert;

import java.util.Map;

public class CheckoutSteps {
    private CartPage cartPage = new CartPage();
    private CheckoutPage checkoutPage = new CheckoutPage();
    private ProductPage productPage = new ProductPage();


    @When("I click on proceed to checkout")
    public void proceedToCheckout() {
        cartPage.proceedToCheckout();
    }


    @Then("I should see the Checkout popup with a {string} button")
    public void verifyCheckoutPopup(String buttonText) {
        boolean isPresent = checkoutPage.isButtonPresent(buttonText);
        Assert.assertTrue(isPresent, "The '" + buttonText + "' button is not displayed in the Checkout popup.");
    }

    @And("I click on Register \\/ Login link")
    public void navigateToLoginPagefromCheckout() {
        checkoutPage.navigateToLoginPagefromCheckout();
    }

    @When("I add the first available product to the cart")
    public void i_add_the_first_available_product_to_the_cart() {
        productPage.i_add_the_first_available_product_to_the_cart();
    }
    @Then("the product added earlier should be in the cart")
    public void the_product_added_earlier_should_be_in_the_cart() {
        // Retrieve the product details that were added earlier to the cart
        Map<String, String> expectedProductDetails = productPage.getProductDetails();
        // Verify product details in the cart
        Map<String, String> actualProductDetails = productPage.verifyProductInCart(expectedProductDetails);
        // Assert that the product is present in the cart
        Assert.assertNotNull(actualProductDetails.get("name"), "The product is not present in the cart.");

        // Assert that the product price matches
        Assert.assertEquals(actualProductDetails.get("price"), expectedProductDetails.get("price"),
                "The product price in the cart does not match the expected price.");
    }
}
