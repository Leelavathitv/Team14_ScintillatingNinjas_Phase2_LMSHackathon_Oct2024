@Program2
Feature: Manage Program - Delete Program

  Background: Admin is on program module after reaching dashboard
    Given Admin is on the Program module
    When Admin is logged in successfully and is in program module page
@1
  Scenario: Verify delete feature
  
    When Admin clicks on delete button for a program
    Then Admin will get confirm deletion popup

  Scenario: Verify Admin is able to click 'Yes'
    Given Admin is on Confirm deletion form
    When Admin clicks on "Yes" button
    Then Admin can see 'Successful Program Deleted' message

  Scenario: Verify Admin is able to deleted program
    When Admin Searches for "Deleted Program name"
    Then There should be zero results

  Scenario: Verify Admin is able to click 'No'
    Given Admin is on Program Confirm Deletion Page after selecting a program to delete
    When Admin clicks on "No" button
    Then Admin can see Confirm Deletion form disappear

  Scenario: Verify Admin is able to close the window with "X"
    Given Admin is on Program Confirm Deletion Page after selecting a program to delete
    When Admin click on "X" button
    Then Admin can see Confirm Deletion form disappear
