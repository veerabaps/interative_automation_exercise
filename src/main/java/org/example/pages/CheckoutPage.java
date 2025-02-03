package org.example.pages;

import org.example.utils.DriverManager;
import org.example.utils.SeleniumUtils;
import org.example.utils.Utility;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage() {
        this.driver = DriverManager.getDriver();

    }
    public boolean isButtonPresent(String buttonText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.modal-content")));
            WebElement continueButton = popup.findElement(By.xpath(".//button[contains(text(), '" + buttonText + "')]"));
            return continueButton.isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }
    public void navigateToLoginPagefromCheckout(){
        SeleniumUtils.clickElement(driver, By.linkText("Register / Login"));
    }


}
