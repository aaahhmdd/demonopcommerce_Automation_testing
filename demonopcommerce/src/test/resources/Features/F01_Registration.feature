@smoke
Feature: Registration Feature users could register with new accounts
  Scenario: Success registration
    Given user open register page
    When user select gender type
    And user enter first name and last name
    And user enter date of birth
    And user enter email field
    And user fills Password fields
    And user clicks on register button
    Then success message is displayed
