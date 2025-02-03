package org.example.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumUtils {

    // Click an element using By locator
    public static void clickElement(WebDriver driver, By by) {
        try {
            WebElement element = driver.findElement(by);
            clickElement(driver, element);
        } catch (NoSuchElementException e) {
            System.err.println("Element not found: " + by.toString());
        }
    }

    // Click an element using WebElement reference
    public static void clickElement(WebDriver driver, WebElement element) {
        try {
            if (element.isDisplayed() && element.isEnabled()) {
                element.click();
            } else {
                System.out.println("Element not clickable, using JavaScript click");
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            }
        } catch (Exception e) {
            System.err.println("Click failed: " + e.getMessage());
        }
    }

    public static void selectOption(WebDriver driver, By by, String selectionType, String value) {
        WebElement element = driver.findElement(by);
        if (element.getTagName().equals("select")) {
            Select dropdown = new Select(element);
            switch (selectionType.toLowerCase()) {
                case "value":
                    dropdown.selectByValue(value);
                    break;
                case "visibletext":
                    dropdown.selectByVisibleText(value);
                    break;
                case "index":
                    dropdown.selectByIndex(Integer.parseInt(value));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid selection type: " + selectionType);
            }
        } else {
            throw new IllegalArgumentException("Element is not a select dropdown.");
        }
    }

    // Enter text into a field using By locator
    public static void enterText(WebDriver driver, By by, String text) {
        try {
            WebElement element = driver.findElement(by);
            enterText(driver, element, text);
        } catch (NoSuchElementException e) {
            System.err.println("Text field not found: " + by.toString());
        }
    }

    // Enter text into a field using WebElement reference
    public static void enterText(WebDriver driver, WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            System.err.println("Failed to enter text: " + e.getMessage());
        }
    }

    // Scroll to an element
    public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Wait for an element to be visible
    public static WebElement waitForElement(WebDriver driver, By by, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    // Check if an element is visible
    public static boolean isElementVisible(WebDriver driver, By by, int seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
