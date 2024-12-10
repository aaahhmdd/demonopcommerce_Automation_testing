@smoke
Feature: Search functionality on the website

  Scenario Outline: User could search using product name
    Given user is on the home page
    When user searches for "<product>"
    Then the URL should contain
    And the search results should show relevant results

    Examples:
      | product     |
      | book        |
      | laptop      |
      | nike        |

  Scenario Outline: User could search using SKU
    Given user is on the home page
    When user searches for SKU "<sku>"
    And user clicks on the product in the search results
    Then the product SKU should match the search SKU "<sku>"

    Examples:
      | sku          |
      | SCI_FAITH    |
      | APPLE_CAM    |
      | SF_PRO_11    |
