# Automation Test Framework for AutomationExercise.com

This repository contains an automation test framework for the website AutomationExercise.com. 
The framework is built using Java, Selenium WebDriver, and Cucumber to facilitate Behavior-Driven Development (BDD). 
It includes automated test scripts for four critical user journeys on the website.

## Table of Contents ##

1. [ ] Project Overview
2. [ ] User Journeys Selected
3. [ ] Framework and Tools
4. [ ] Getting Started
5. [ ] Prerequisites
6. [ ] Setup Instructions
7. [ ] Test Execution
8. [ ] GitHub Repository
9. [ ] Contact

## Project Overview

The goal of this project is to create an automated regression testing framework for the website AutomationExercise.com. 
The framework is designed to test critical user journeys and ensure the website's functionality is working as expected.

### User Journeys Selected

After reviewing the website, the following six user journeys were identified as the most important:

1. User Registration
2. User Login
3. Add Product to Cart Using Search
4. Add Products to Cart Without Signing In
5. Validate Products in Cart
6. Contact Us Form

#### 1. User Registration

Reason: Ensures new users can successfully create an account.

Test Coverage: Validates the registration form, error messages, and successful account creation.

#### 2. User Login
   
Reason: Validates the login functionality for existing users.

Test Coverage: Tests login with valid and invalid credentials.

#### 3. Add Product to Cart Using Search

Reason: Ensures users can search for products and add them to the cart.

Test Coverage: Validates the search functionality and cart updates.

#### 4. Contact Us Form

Reason: Ensures users can submit inquiries through the contact form.

Test Coverage: Tests form submission and validation.


# Framework and Tools

The following tools and frameworks were chosen for this project:

#### Programming Language

Java

Reason: Widely used in test automation, strong community support, and extensive libraries.

#### Test Framework

Selenium WebDriver

Reason: Industry-standard tool for web automation, supports multiple browsers, and integrates well with Java.

#### BDD Framework

Cucumber

Reason: Facilitates Behavior-Driven Development (BDD), making tests readable and maintainable.

#### Build Tool

Maven

Reason: Simplifies dependency management and project builds.

#### Reporting

Cucumber HTML Reports


# Getting Started

Follow the instructions below to set up and run the project locally.

### Prerequisites

1. Java Development Kit (JDK) 11 or higher
2. Maven 3.x
3. Google Chrome (or any other browser supported by Selenium)

Git (for cloning the repository)

Reason: Provides detailed and visually appealing test execution reports.

## Project Structure

- **src/main/java**: Contains the main Java code.
    - `org.example.pages`: Page Object Models representing the web application's pages.
    - `org.example.utils`: Utility classes, including the `DriverManager` for WebDriver management.

- **src/test/java**: Contains the test code.
    - `org.example.stepDefinitions`: Step definitions linking Gherkin steps to Java methods.
    - `org.example.runners`: Test runners configured to execute Cucumber tests.
    - `org.example.hooks`: Hooks for setup and teardown operations.

- **src/test/resources**: Contains test resources.
    - `features`: Directory for `.feature` files written in Gherkin syntax.

## Prerequisites

Ensure the following are installed:

- **Java Development Kit (JDK) 1.8 or higher**: [Download JDK](https://www.oracle.com/java/technologies/javase-downloads.html)
- **Apache Maven**: [Download Maven](https://maven.apache.org/download.cgi)
- **WebDriver Executables**: Place the appropriate WebDriver executables (e.g., `chromedriver`, `geckodriver`) in your system's PATH.

## Generating Reports

After test execution, reports are generated in the test-output/cucumber-reports directory:

HTML Report: cucumber-pretty/index.html
JSON Report: CucumberTestReport.json 

## Running the Tests

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/Cucumber_Project.git
   cd Cucumber_Project
2. **Execute Tests Using Maven**:
```bash
    mvn clean test


