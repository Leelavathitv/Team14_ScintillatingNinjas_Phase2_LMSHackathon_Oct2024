@Login
Feature: LMS Portal Login Functionality

  @LoginCredentials @LoginTC_001
  Scenario: Validate the login with valid credentials
    Given The User is on the login page
    When The User enters the valid username and password "LoginCredentials"
    Then The User get navigated to home page and successfully logged in
