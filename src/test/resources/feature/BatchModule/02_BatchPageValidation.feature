@BatchPageValidation
Feature: Batch Page Validation Functionality

  Background: Admin successfully Logged on to the LMS Portal
    Given The Admin is on the login page of the LMS Portal 
    When Admin enters valid credentials and clicks

  @BatchPageValidation @BatchvalidTC_1001
  Scenario: Validate "Title" in Batch Page
     Given Admin is on the Dashboard Page after Login
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the LMS Learning Management Systems Title

  
  
    @BatchPageValidation @BatchvalidTC_1002
  Scenario: Validate "heading" in the Batch Page
    Given Admin is on the Dashboard Page after Login
    When Admin Clicks on the Batch menu from the header
   Then Admin should see the Manage Batch Heading

  @BatchPageValidation @BatchvalidTC_1003
  Scenario: Validate disabled "Delete Icon" under the header in the Batch Page
    Given Admin is on the Dashboard Page after Login
    When Admin Clicks on the Batch menu from the header
     Then Admin should see the disabled Delete Icon under the header
#
  #@BatchPageValidation @BatchvalidTC_004
  #Scenario: Validate pagination in the Batch Page
  #  Given Admin is on the Dashboard Page after Login
    #When Admin Clicks on the Batch menu from the header
    #Then Admin should see the enabled pagination controls under the data table

  #@BatchPageValidation @BatchvalidTC_005
  #Scenario: Validate edit icon in each data rows
    #Given Admin is on the Dashboard Page after Login
    #When Admin Clicks on the Batch menu from the header
    #Then Admin should see the edit icon in each row
#
  #@BatchPageValidation @BatchvalidTC_006
  #Scenario: Validate delete icon in each data rows
    #Given Admin is on the Dashboard Page after Login
    #When Admin Clicks on the Batch menu from the header
    #Then Admin should see the delete icon in each row
#
  #@BatchPageValidation @BatchvalidTC_007
  #Scenario: Validate checkbox in each data rows
    #Given Admin is on the Dashboard Page after Login
    #When Admin Clicks on the Batch menu from the header
    #Then Admin should the checkbox in each row
#
  #@BatchPageValidation @BatchvalidTC_008
  #Scenario: Validate Datatable headers
    #Given Admin is on the Dashboard Page after Login
    #When Admin Clicks on the Batch menu from the header
    #Then Admin should see the datatable headers Batch name, Batch Description,Batch Status, No Of classes, Program Name, Edit/Delete
#
  #@BatchPageValidation @BatchvalidTC_009
  #Scenario: Validate "Checkbox" in the Datatable header row
    #Given Admin is on the Dashboard Page after Login
    #When Admin Clicks on the Batch menu from the header
    #Then Admin should see the checkbox  in the datatable header row
#
  #@BatchPageValidation @BatchvalidTC_001
  #Scenario: Validate "sort icon" next to all the datatable header
    #Given Admin is on the Dashboard Page after Login
    #When Admin Clicks on the Batch menu from the header
    #Then Admin should see the sort icon next to all Datatable headers
