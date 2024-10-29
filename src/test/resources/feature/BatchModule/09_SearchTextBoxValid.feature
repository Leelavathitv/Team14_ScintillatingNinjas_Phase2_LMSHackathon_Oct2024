@BatchSearchTextBox
Feature: Search Text box validation

  Background: Admin is on the Batch page
    Given The Admin is on the login page of the LMS Portal
    When Admin is on the Batch page after login successful
    
    
  Scenario: Validate search box functionality
   Given Admin is on the Batch page
    When Admin enters the batch name in the search text box
    Then Admin should see the filtered batches in the data table