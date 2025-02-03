Feature: User Login

@regression @logout
  Scenario Outline: Successful login with valid credentials
    Given I am on the login page
    When I login with email "<email>" and password "<password>"
    And I click the login button
    Then I should be logged in successfully
    And I click logout
    Examples:
      | email                     | password       |
      | naga12387@example.com     | Password123    |

@regression
  Scenario Outline: Unsuccessful login with invalid credentials
    Given I am on the login page
    When I login with email "<email>" and password "<password>"
    And I click the login button
    Then I should see an error message
    Examples:
      | email                     | password       |
      | invaliduser@example.com    | WrongPassword    |