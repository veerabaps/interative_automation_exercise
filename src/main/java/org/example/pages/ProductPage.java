package org.example.pages;

import org.example.utils.DriverManager;
import org.example.utils.Utility;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class ProductPage {
    private WebDriver driver;
    private Map<String, String> productDetails;

    public ProductPage() {
        this.driver = DriverManager.getDriver();
        this.productDetails = new HashMap<>(); // Initialize the map
    }

    public void i_add_the_first_available_product_to_the_cart() {

        WebElement firstProduct = Utility.waitForElement(driver,By.cssSelector("div.single-products:first-child div.productinfo"),3);

        // Fetch product details (name and price)
        String productName = firstProduct.findElement(By.cssSelector("p")).getText(); // Product name
        String productPrice = firstProduct.findElement(By.cssSelector("h2")).getText(); // Product price
        System.out.println("Expected Product Name: " + productName);
        System.out.println("Expected Product Price: " + productPrice);

        // Store product details for later verification
        productDetails.put("name", productName);
        productDetails.put("price", productPrice);

        // Add the product to the cart
        WebElement addToCartButton = firstProduct.findElement(By.cssSelector("a.add-to-cart"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButton);

        WebElement cartModal = Utility.waitForElement(driver,By.id("cartModal"),10);

       // Click on the 'View Cart' button within the modal
        WebElement viewCartButton = cartModal.findElement(By.cssSelector("a[href='/view_cart']"));
        viewCartButton.click();
    }
    // Method to get the stored product details
    public Map<String, String> getProductDetails() {

        return productDetails;
    }
    public Map<String, String> verifyProductInCart(Map<String, String> expectedProductDetails) {
        Map<String, String> productDetails = new HashMap<>();

        try {
            // Locate the product name in the cart
            WebElement cartProductNameElement = driver.findElement(By.xpath("//td[@class='cart_description']//a[contains(text(), '" + expectedProductDetails.get("name") + "')]"));
            String cartProductName = cartProductNameElement.getText();
            productDetails.put("name", cartProductName);

            // Locate the product price in the cart
            WebElement cartProductPriceElement = driver.findElement(By.xpath("//td[@class='cart_description']//a[contains(text(), '" + expectedProductDetails.get("name") + "')]/../../following-sibling::td[@class='cart_price']//p"));
            String cartProductPrice = cartProductPriceElement.getText();
            productDetails.put("price", cartProductPrice);

        } catch (NoSuchElementException e) {
            // If the product is not found, print the error for debugging
            System.out.println("Error: Product not found in the cart.");
        }

        return productDetails;
    }

}
