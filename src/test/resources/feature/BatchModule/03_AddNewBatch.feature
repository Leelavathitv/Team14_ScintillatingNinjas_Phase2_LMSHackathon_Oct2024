@AddNewBatch
Feature: Add New Batch

  Background: Admin is on the Batch page
    Given The Admin is on the login page of the LMS Portal
    When Admin is on the Batch page after login successful

  @AddBatchmenu @BatchAddNewTC_1001
  Scenario: Verify sub menu displayed in batch menu bar
    Given Admin is on the Batch page
    When Admin clicks Batch on the navigation bar
    Then Admin should see sub menu in menu bar as Add New Batch

  @NewBatchpopup @BatchAddNewTC_1002
  Scenario: Validate Admin able to click on the Add new Batch Option
    Given Admin is on the Batch page
    When Admin clicks on Add New batch under the batch menu bar
    Then Admin should see the Batch Details pop up window
