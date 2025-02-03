Feature: Contact Us Form Submission
  @regression
  Scenario: Submit the Contact Us form
    Given I am on the Automation Exercise homepage
    When I navigate to the Contact Us page
    And I submit the form with name "Test User", email "testuser@example.com", and message "This is a test message"
    Then I should see a success message