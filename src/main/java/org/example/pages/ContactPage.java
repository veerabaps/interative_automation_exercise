package org.example.pages;


import org.example.utils.DriverManager;
import org.example.utils.SeleniumUtils;
import org.example.utils.Utility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactPage {
    private WebDriver driver;

    public ContactPage() {
        this.driver = DriverManager.getDriver();
    }

    public void submitForm(String name, String email, String message) {
        SeleniumUtils.enterText(driver, By.name("name"), name);
        SeleniumUtils.enterText(driver, By.name("email"), email);
        SeleniumUtils.enterText(driver, By.name("subject"), "test");
        SeleniumUtils.enterText(driver, By.name("message"), message);
        Utility.scrollBy(driver,100);
        SeleniumUtils.clickElement(driver, By.xpath("//input[@data-qa='submit-button']"));
        Alert alert = driver.switchTo().alert();
        // Accept the alert (click "OK")
        alert.accept();
    }

    public boolean isSuccessMessageDisplayed() {
        WebElement message = Utility.waitForElement(driver,By.cssSelector("div.status.alert.alert-success"),10);
        return message.getText().contains("Success! Your details have been submitted successfully.");
    }
}
