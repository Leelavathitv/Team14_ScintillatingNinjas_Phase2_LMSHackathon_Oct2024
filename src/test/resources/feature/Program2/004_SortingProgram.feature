@Program2
Feature: Manage Program - Sorting Program

  Background: Admin is on program module after reaching dashboard
    Given Admin is on Program module
    When Admin is logged in successfully and is in program module page

  Scenario: Verify sorting of  Program name in Ascending order/Descending order
    When Admin clicks on Arrow next to program Name
    Then Admin See the Program Name is sorted in Ascending order/Descending order

  Scenario: Verify sorting of  Program Description in Ascending order/Descending order
    When Admin clicks on Arrow next to Program Description
    Then Admin See the program Description is sorted in Ascending order/Descending order

  Scenario: Verify sorting of   Program status in Ascending order/Descending order
    When Admin clicks on Arrow next to Program status
    Then Use See the Program Status is sorted in Ascending order/Descending order
