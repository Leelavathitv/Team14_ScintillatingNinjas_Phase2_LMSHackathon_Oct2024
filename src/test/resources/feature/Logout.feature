@Logout

Feature: Validation on Logout button

  Background: Admin is logged into the application
   Given The Admin is on the login page of the LMS Portal
    When Admin enters valid credentials and clicks Login
    

  Scenario: Verify logout function
  
    Given Admin is on the Dashboard Page after Login 
    When Admin clicks on the logout in the menu bar
    Then Admin should be redirected to login page
