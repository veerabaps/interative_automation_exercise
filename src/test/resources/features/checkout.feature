Feature: Checkout Process

  @regression
  Scenario Outline: Verify Cart from Checkout page
    Given I am on the Products page
    When I add the first available product to the cart
    And I view the cart
    And I click on proceed to checkout
    And I should see the Checkout popup with a "Continue On Cart" button
    And I click on Register / Login link
    And I login with email "<email>" and password "<password>"
    And I click the login button
    And I view the cart
    Then the product added earlier should be in the cart
    Examples:
      | email                     | password       |
      | naga12387@example.com     | Password123    |