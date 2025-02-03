package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.example.pages.CartPage;
import org.example.pages.HomePage;
import org.example.pages.ProductPage;
import org.testng.Assert;

public class CartSteps {
    private HomePage homePage = new HomePage();
    private ProductPage productPage = new ProductPage();
    private CartPage cartPage = new CartPage();

    @When("I search for {string}")
    public void searchProduct(String product) {
        homePage.searchProduct(product);
    }

    @When("I add the first product to the cart")
    public void addProductToCart() {
        productPage.i_add_the_first_available_product_to_the_cart();
    }

    @When("I view the cart")
    public void viewCart() {
        cartPage.viewCart();
    }

    @Then("the product should be added to the cart successfully")
    public void verifyProductAddedToCart() {
        Assert.assertTrue(cartPage.isAnyProductInCart(), "No products found in the cart.");
    }

    @Given("I am on the Products page")
    public void iAmOnTheProductsPage() {
        cartPage.navigateToProductsPage();
    }
}