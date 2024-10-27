@BatchPageNavigation
Feature: Batch Page Navigation Functionality

  Background: Admin successfully Logged on to the LMS Portal
 Given Admin launch the browser
 # Given The Admin is on the login page of the LMS Portal
   When Admin enters valid credentials and clicks

  @BatchPageNavigation @BatchNavTC_001
  Scenario: Verify Admin Navigate to Batch page successfully
   #Given Admin is on the Dashboard Pages
    When Admin Clicks on the Batch menu from the header
   Then Admin should be in the Manage Batch Page
