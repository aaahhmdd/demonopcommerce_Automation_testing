@smoke
Feature: F08_Wishlist | Users can add products to wishlist

  Scenario: Verify success message and green background color after adding to wishlist
    Given user is on the home page
    When user adds HTC to the wishlist
    Then success message "The product has been added to your wishlist" is displayed
    And the background color of the message is green

  Scenario: Verify wishlist quantity after adding a product
    Given user is on the home page
    When user adds HTC to the wishlist
    And success message disappears
    And user navigates to the Wishlist tab
    Then wishlist quantity is greater than 0
