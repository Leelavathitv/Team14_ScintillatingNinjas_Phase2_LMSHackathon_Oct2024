@BatchLogOut
Feature: LogOut of the application from the batch page

  Background: Admin is on the batch page
    Given The Admin is on the login page of the LMS Portal
    When Admin is on the Batch page after login successful

  Scenario: Validate logout option in the header is visible and enabled from the batch page
   #Admin clicks on the logout in the menu bar
  
  
   When Admin clicks on the logout button
   Then Admin should see the Login screen Page
