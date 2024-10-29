@Program2
Feature: Manage Program - Delete Program

  Background: Admin is on program module after reaching dashboard
    Given Admin is on the Program module
    When Admin is logged in successfully and is in program module page

  @Program_1
  Scenario: Verify delete feature
    When Admin clicks on delete button for a program "LeelaLMSFifty"
    Then Admin will get confirm deletion popup

  @Program_2
  Scenario: Verify Admin is able to click 'Yes'
    Given Admin is on Confirm deletion form for program "LeelaLMSFifty"
    When Admin clicks on Yes button
    Then Admin can see 'Successful Program Deleted' message

  @Program_3
  Scenario: Verify Admin is able to find deleted program
    When Admin Searches for "LeelaLMSEighteen"
    Then There should be zero results for "LeelaLMSEighteen"

  @Program_4
  Scenario: Verify Admin is able to click 'No'
    Given Admin is on Program Confirm Deletion Page after selecting a program to delete "LeelaLMSSixteen"
    When Admin clicks on No button
    Then Admin can see Confirm Deletion form disappear

  @Program_5
  Scenario: Verify Admin is able to close the window with "X"
    Given Admin is on Program Confirm Deletion Page after selecting a program to delete "LeelaLMSSixteen"
    When Admin clicks on X button
    Then Admin can see Confirm Deletion form disappear
