@smoke
Feature: F05_hoverCategories | Hover on main category and click on sub-category
  Scenario: Hover on a main category and select a sub-category
    Given user is on the home page
    When user hovers over a random main category
    And user clicks on a random sub-category
    Then sub-category page title should match the selected sub-category
