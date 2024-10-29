@BatchPageValidation
Feature: Batch Page Validation Functionality

  Background: Admin successfully Logged on to the LMS Portal
    Given The Admin is on the login page of the LMS Portal
    When Admin enters valid credentials and clicks Login

  @BatchTitle @BatchvalidTC_1001
  Scenario: Validate Title in Batch Page
    Given Admin is on the Dashboard Page after Login
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the LMS Learning Management Systems Title

  @BatchManageValid @BatchvalidTC_1002
  Scenario: Validate heading in the Batch Page
    Given Admin is on the Dashboard Page after Login
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the Manage Batch Heading

  @BatchDeleteDisable @BatchvalidTC_1003
  Scenario: Validate disabled Delete Icon under the header in the Batch Page
    Given Admin is on the Dashboard Page after Login
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the disabled Delete Icon under the header

  @BatchPagination @BatchvalidTC_1004
  Scenario: Validate pagination in the Batch Page
    Given Admin is on the Dashboard Page after Login
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the enabled pagination controls under the data table

  @BatchEditIcon @BatchvalidTC_1005
  Scenario: Validate edit icon in each data rows
    Given Admin is on the Dashboard Page after Login
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the edit icon in each row

  @BatchDeleteIcon @BatchvalidTC_1006
  Scenario: Validate delete icon in each data rows
    Given Admin is on the Dashboard Page after Login
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the delete icon in each row

  @BatchRowCheckbox @BatchvalidTC_1007
  Scenario: Validate checkbox in each data rows
    Given Admin is on the Dashboard Page after Login
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the checkbox in each row

  @BatchHeaderNames @BatchvalidTC_1008
  Scenario: Validate Datatable headers
    Given Admin is on the Dashboard Page after Login
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the datatable headers Batch name, Batch Description,Batch Status, No Of classes, Program Name, Edit/Delete

  @BatchHeaderCheckbox @BatchvalidTC_1009
  Scenario: Validate "Checkbox" in the Datatable header row
    Given Admin is on the Dashboard Page after Login
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the checkbox in the datatable header row

  @BatchSortIcon @BatchvalidTC_1010
  Scenario: Validate "sort icon" next to all the datatable header
    Given Admin is on the Dashboard Page after Login
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the sort icon next to all Datatable headers

  

