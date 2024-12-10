@smoke
Feature: F03_Currencies | users can change the currency and verify it on the homepage

  Scenario: Verify that Euro currency is displayed on all products
    Given user is on the home page
    When user selects "Euro" currency from the dropdown
    Then all products should display prices in Euro
