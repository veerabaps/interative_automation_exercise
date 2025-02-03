Feature: Adding Products to Cart

@regression
Scenario Outline: Add a product to the cart
    Given I am on the Products page
    When I search for "<productName>"
    And I add the first product to the cart
    And I view the cart
    Then the product should be added to the cart successfully
  Examples:
    | productName                    |
    | Dress                        |
