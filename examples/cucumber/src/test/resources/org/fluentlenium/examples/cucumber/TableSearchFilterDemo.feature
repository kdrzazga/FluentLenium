Feature: 1. Table Search Filter Demo

  Background: Open Select Dropdown List site
    Given I navigate to Table Search Filter Demo site

  Scenario Outline: <"TC id"> Choosing all weekdays in Select List Demo

    When I enter <filter value> to filter textbox
    Then I expect table to contain rows with numbers: <displayed rows>

    Examples:

      | TC id | filter value | displayed rows |
      | 1.1   | in progress  | 1,4,7          |
      | 1.2   | John         | 1,4            |
