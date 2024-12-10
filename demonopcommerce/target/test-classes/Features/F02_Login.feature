@smoke
Feature: Login Feature
  Scenario Outline: User success login
    Given user goes to the login page
    When user logs in with "<type>" email "<username>" and password "<password>"
    And user presses the login button
    Then user "<type>" login to the system

    Examples:
      | type    | username          | password    |
      | valid   | test@example.com  | P@ssw0rd    |
      | invalid | wrong@example.com | P@ssw0rd    |


