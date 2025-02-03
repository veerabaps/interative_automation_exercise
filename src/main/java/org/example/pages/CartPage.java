package org.example.pages;

import org.example.utils.DriverManager;
import org.example.utils.SeleniumUtils;
import org.example.utils.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CartPage {
    private WebDriver driver;

    public CartPage() {
        this.driver = DriverManager.getDriver();
    }
    public void navigateToProductsPage(){
        driver.get("https://automationexercise.com/products");
        Utility.handleCookieConsent(driver);
    }

    // Proceed to checkout
    public void proceedToCheckout() {
        SeleniumUtils.clickElement(driver, By.cssSelector("a.btn.btn-default.check_out"));

    }

    public boolean isAnyProductInCart() {
        // Locate all product rows in the cart table
        List<WebElement> productRows = driver.findElements(By.cssSelector("tr[id^='product-']"));

        // Check if the list is not empty
        if (!productRows.isEmpty()) {
            System.out.println("Product(s) found in the cart.");
            return true;
        } else {
            System.out.println("No products found in the cart.");
            return false;
        }
    }

    // View the cart
    public void viewCart() {
        Utility.waitForFixedTime(1);
        SeleniumUtils.clickElement(driver, By.linkText("Cart"));
    }
}