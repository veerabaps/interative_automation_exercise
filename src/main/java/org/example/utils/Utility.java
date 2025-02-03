package org.example.utils;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Utility {

    public static void handleCookieConsent(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Wait up to 5 seconds
            WebElement consentButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.fc-button-label")));
            consentButton.click();
            System.out.println("Cookie consent popup accepted.");
        } catch (Exception e) {
            // Popup is not present, continue
            System.out.println("Cookie consent popup not found. Proceeding...");
        }
    }

    public static WebElement waitForElement(WebDriver driver, By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForFixedTime(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds); // Wait for the specified number of seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore the interrupted status
            throw new RuntimeException("Thread was interrupted during sleep", e);
        }
    }

    public static void scrollBy(WebDriver driver, int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, arguments[0]);", pixels);
    }

    public static void scrollUsingArrowKeys(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).perform(); // Scroll down slightly


    }
}