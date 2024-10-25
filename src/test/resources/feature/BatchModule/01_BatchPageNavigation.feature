Feature: Batch Page Navigation Functionality

  Background: Admin successfully Logged on to the LMS Portal

  #Given The User is on the login page
  #When The User enters the valid username and password "LoginCredentials"
  Scenario: Verify Admin Navigate to Batch page successfully
    Given Admin is on the Dashboard Page
    When Admin Clicks on the Batch menu from the header
    Then Admin should be in the Manage Batch Page
