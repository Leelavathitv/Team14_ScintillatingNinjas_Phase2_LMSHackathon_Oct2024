@Program2
Feature: Manage Program - Search bar

  Background: Admin is on program module after reaching dashboard
    Given Admin is on Program module
    When Admin is logged in successfully and is in program module page

  Scenario: Verify Admin is able to search results found for program name
    When Admin enter the program to search By program name "LeelaLMSTwoDupDup"
    Then Admin should able to see Program name, description, and status for searched program name "LeelaLMSTwoDupDup"

  Scenario: Verify Admin is able to search results found for program description
    When Admin enter the program to search By program description "LeelaLMSTwoDupDup"
    Then Admin should able to see Program name, description, and status for searched program description "LeelaLMSTwoDupDup"

  Scenario: Verify Admin is able to search results not found
    When Admin enter the program to search By program name that does not exist "LeelaLMSOne"
    Then There should be zero results

  Scenario: Verify Admin is able to search with partial program name
    When Admin enter the program to search By partial name of program
    Then Admin should able to see Program name, description, and status for searched program description "LeelaLMSTwoDupDup"
