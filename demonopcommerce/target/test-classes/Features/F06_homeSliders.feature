Feature: Home Sliders
  Test the clickable functionality of the home page sliders.

  @smoke
  Scenario: First slider is clickable on home page
    Given user is on the home page
    When user clicks on the first slider
    Then user should be directed to "https://demo.nopcommerce.com/nokia-lumia-1020"

  @smoke
  Scenario: Second slider is clickable on home page
    Given user is on the home page
    When user clicks on the second slider
    Then user should be directed to "https://demo.nopcommerce.com/iphone-6"
