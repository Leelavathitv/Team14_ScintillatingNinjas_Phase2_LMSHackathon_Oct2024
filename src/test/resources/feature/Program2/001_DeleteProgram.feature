@DeleteProgram
Feature: Manage Program - Delete Program

  Background: Admin is on program module after reaching dashboard
    Given Admin is on the Program module
    When Admin is logged in successfully and is in program module page 

  #@DeleteProgram @DeletePgTC_01
  #Scenario: Verify delete feature
    #When Admin clicks on delete button for a program "TeamFifteen"
    #Then Admin will get confirm deletion popup

  @DeleteProgram @DeletePgTC_02
  Scenario: Verify Admin is able to click 'Yes'
    Given Admin is on Confirm deletion form for program "ScintillatingFifty"
    When Admin clicks on Yes button
    Then Admin can see 'Successful Program Deleted' message

  @DeleteProgram @DeletePgTC_03
  Scenario: Verify Admin is able to find deleted program
    When Admin Searches for "ScintillatingFifty"
    Then There should be zero results for "ScintillatingFifty"

  @DeleteProgram @DeletePgTC_04
  Scenario: Verify Admin is able to click 'No'
    Given Admin is on Program Confirm Deletion Page after selecting a program to delete "TeamFifteen"
    When Admin clicks on No button
    Then Admin can see Confirm Deletion form disappear

  @DeleteProgram @DeletePgTC_05
  Scenario: Verify Admin is able to close the window with "X"
    Given Admin is on Program Confirm Deletion Page after selecting a program to delete "TeamFifteen"
    When Admin clicks on X button
    Then Admin can see Confirm Deletion form disappear
