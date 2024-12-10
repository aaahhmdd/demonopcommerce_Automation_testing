@smoke
Feature: F07_followUs | Users could open followUs links

  Scenario: User opens Facebook link
    Given user is on the home page
    When user clicks on the Facebook link
    Then "https://www.facebook.com/nopCommerce" is opened in a new tab

  Scenario: User opens Twitter link
    Given user is on the home page
    When user clicks on the Twitter link
    Then "https://x.com/nopCommerce" is opened in a new tab

  Scenario: User opens RSS link
    Given user is on the home page
    When user clicks on the RSS link
    Then "https://demo.nopcommerce.com/new-online-store-is-open" is opened in a new tab

  Scenario: User opens YouTube link
    Given user is on the home page
    When user clicks on the YouTube link
    Then "https://www.youtube.com/user/nopCommerce" is opened in a new tab
