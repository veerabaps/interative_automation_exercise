package org.example.pages;

import org.example.utils.DriverManager;
import org.example.utils.SeleniumUtils;
import org.example.utils.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.support.ui.Select;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    public LoginPage() {
        this.driver = DriverManager.getDriver();
    }

    // Navigate to the login page
    public void navigateToLoginPage() {
        driver.get("https://automationexercise.com/login");
        Utility.handleCookieConsent(driver);
    }

    // Navigate to the Signup/Login page
    public void navigateToSignupPage() {
        driver.get("https://automationexercise.com/signup");
    }

    // Fill out the registration form
    public void fillRegistrationForm(String name, String email, String password, String title, String dobDay, String dobMonth, String dobYear,
                                     String firstName, String lastName, String company, String address, String country, String state,
                                     String city, String zipcode, String mobileNumber) {
        // Enter name and email
        SeleniumUtils.enterText(driver, By.name("name"), name);
        SeleniumUtils.enterText(driver,By.cssSelector("input[data-qa='signup-email']"),email);
        SeleniumUtils.clickElement(driver,By.cssSelector("button[data-qa='signup-button']"));
        Utility.waitForElement(driver,By.id("uniform-id_gender1"),3);

        // Select title (Mr or Mrs)
        if (title.equalsIgnoreCase("Mr")) {
            SeleniumUtils.clickElement(driver,By.id("id_gender1"));

        } else if (title.equalsIgnoreCase("Mrs")) {
            SeleniumUtils.clickElement(driver,By.id("id_gender2"));

        }

        // Enter password
        SeleniumUtils.enterText(driver,By.id("password"),password);

        SeleniumUtils.selectOption(driver,By.id("days"),"value", dobDay);
        SeleniumUtils.selectOption(driver,By.id("months"),"visibletext", dobMonth);
        SeleniumUtils.selectOption(driver,By.id("years"),"value", dobYear);

        // Enter first name and last name
        SeleniumUtils.enterText(driver,By.id("first_name"),firstName);
        SeleniumUtils.enterText(driver,By.id("last_name"),lastName);

        // Enter company
        SeleniumUtils.enterText(driver,By.id("company"),company);

        // Enter address
        SeleniumUtils.enterText(driver,By.id("address1"),address);

        // Select country
        SeleniumUtils.selectOption(driver,By.id("country"),"visibletext", country);

        // Enter state, city, and zipcode
        SeleniumUtils.enterText(driver,By.id("state"),state);
        SeleniumUtils.enterText(driver,By.id("city"),city);
        SeleniumUtils.enterText(driver,By.id("zipcode"),zipcode);
        // Enter mobile number
        SeleniumUtils.enterText(driver,By.id("mobile_number"),mobileNumber);
    }

    // Submit the registration form
    public void submitRegistrationForm() {

        Utility.scrollBy(driver,200);
        WebElement createAccountButton = Utility.waitForElementToBeClickable(driver,By.cssSelector("button[data-qa='create-account']"),10);

// Click the button
        createAccountButton.click();


    }

    // Check if account creation is successful
    public boolean isAccountCreated() {

        WebElement message = Utility.waitForElement(driver,By.xpath("//h2[@data-qa='account-created']"),20);
        System.out.println(message.getText());
        // Verify the success message
        if (message.getText().contains("ACCOUNT CREATED!")) {
            System.out.println("Account creation confirmed.");
        } else {
            System.out.println("Account creation message not found.");
        }
        return message.getText().contains("ACCOUNT CREATED!");

    }
    // Enter username
    public void enterUsername(String username) {
        WebElement usernameField = driver.findElement(By.name("email"));
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    // Enter password
    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    // Click the login button
    public void clickLoginButton() {
        SeleniumUtils.clickElement(driver,By.cssSelector("button[data-qa='login-button']"));
    }

    // Click the login button
    public void clickLogoutButton() {
        SeleniumUtils.clickElement(driver,By.linkText("Logout"));

    }

    // Register a new user
    public void registerUser(String email, String name, String password) {
        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys(email);
        driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();
    }


    // Login with valid credentials
    public void login(String email, String password) {
        SeleniumUtils.enterText(driver,By.cssSelector("input[data-qa='login-email']"),email);
        SeleniumUtils.enterText(driver,By.cssSelector("input[data-qa='login-password']"),password);

        //driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();
    }

    // Check if the user is logged in
    public boolean isUserLoggedIn() {
        return driver.findElement(By.linkText("Logout")).isDisplayed();
    }

    // Check if an error message is displayed
    public boolean isErrorMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p[style='color: red;']")));
        return errorMessage.isDisplayed();
    }
}