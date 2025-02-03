package org.example.pages;



import org.example.utils.DriverManager;
import org.example.utils.SeleniumUtils;
import org.example.utils.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {
    private WebDriver driver;

    public HomePage() {
        this.driver = DriverManager.getDriver();
    }

    public void navigate() {
        driver.get("https://automationexercise.com");
        Utility.handleCookieConsent(driver);
    }
    public void goToLogin() {
        SeleniumUtils.clickElement(driver, By.linkText("Signup / Login"));
    }

    public void searchProduct(String product) {
        SeleniumUtils.enterText(driver, By.id("search_product"), product);
        SeleniumUtils.clickElement(driver, By.id("submit_search"));

    }

    public void goToContactUs() {

        SeleniumUtils.clickElement(driver, By.cssSelector("a[href='/contact_us']"));

    }

    public boolean isUserLoggedIn() {
        return driver.findElement(By.linkText("Logout")).isDisplayed();
    }
}
