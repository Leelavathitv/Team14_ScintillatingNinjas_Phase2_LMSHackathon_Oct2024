@Program2
Feature: Manage Program - Delete Program

  Background: Admin is on program module after reaching dashboard
    Given Admin is on the Program module
    When Admin is logged in successfully and is in program module page

  Scenario: Verify delete feature
  
    When Admin clicks on delete button for a program "LeelaLMSSeventeen"
    Then Admin will get confirm deletion popup

  Scenario: Verify Admin is able to click 'Yes'
    Given Admin is on Confirm deletion form for program "LeelaLMSSeventeen"
    When Admin clicks on Yes button
    Then Admin can see 'Successful Program Deleted' message

  Scenario: Verify Admin is able to find deleted program
    When Admin Searches for "LeelaLMSSeventeen"
    Then There should be zero results for "LeelaLMSSeventeen"

  Scenario: Verify Admin is able to click 'No'
    Given Admin is on Program Confirm Deletion Page after selecting a program to delete "LeelaLMSSixteen" 
    When Admin clicks on No button
    Then Admin can see Confirm Deletion form disappear

  Scenario: Verify Admin is able to close the window with "X"
    Given Admin is on Program Confirm Deletion Page after selecting a program to delete "LeelaLMSSixteen" 
    When Admin clicks on X button
    Then Admin can see Confirm Deletion form disappear