Feature: User Registration and Login

  @registration
  Scenario Outline: Register a new user
    Given I am on the Automation Exercise homepage
    When I navigate to the Signup or login page
    And I register with email "<email>" and name "<name>"
    Then I should see the account creation success message

    Examples:
      | email                     | name       |
      | veer128490@example.com     | TestUser  |


  @regression
  Scenario Outline: Login with valid credentials
    Given I am on the Automation Exercise homepage
    When I navigate to the Signup or login page
    And I login with email "<email>" and password "<password>"
    And I click the login button
    Then I should be logged in successfully
    Examples:
      | email                     | password        |
      | naga12387@example.com     | Password123     |
      | veer12849@example.com     | Password123     |

