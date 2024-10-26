Feature: Login Page Verification
  The admin should be able to verify all elements of the login page are correct and functional.

  Background:
    Given Admin launches the browser
    And Admin gives the correct LMS portal URL

  Scenario: Verify Admin is able to land on login page
    When Admin gives the correct LMS portal URL
    Then Admin should land on the login page

  Scenario: Verify Admin is able to land on home page with invalid URL
    When Admin gives the invalid LMS portal URL
    Then Admin should receive 404 page not found error

  Scenario: Verify for broken link
    When Admin gives the correct LMS portal URL
    Then HTTP response >= 400. Then the link is broken

  Scenario: Verify the text spelling in the page
    When Admin gives the correct LMS portal URL
    Then Admin should see correct spellings in all fields

  Scenario: Verify the company logo
    When Admin gives the correct LMS portal URL
    Then Admin should see the logo on the left side

  Scenario: Verify application name
    When Admin gives the correct LMS portal URL
    Then Admin should see "LMS - Learning Management System"

  Scenario: Verify company name
    When Admin gives the correct LMS portal URL
    Then Admin should see the company name below the app name

  Scenario: Validate sign-in content
    When Admin gives the correct LMS portal URL
    Then Admin should see "Please login to LMS application"

  Scenario: Verify text field is present
    When Admin gives the correct LMS portal URL
    Then Admin should see two text fields

  Scenario: Verify text on the first text field
    When Admin gives the correct LMS portal URL
    Then Admin should see "User" in the first text field

  Scenario: Verify asterisk next to Admin text
    When Admin gives the correct LMS portal URL
    Then Admin should see field mandatory aestrik symbol next to Admin text

  Scenario: Verify text on the second text field
    When Admin gives the correct LMS portal URL
    Then Admin should see "Password" in the second text field

  Scenario: Verify asterisk next to password text
    When Admin gives the correct LMS portal URL
    Then Admin should see aestrik symbol next to the password text

  Scenario: Verify the alignment of the login input fields
    When Admin gives the correct LMS portal URL
    Then Admin should see the text fields aligned correctly

     Scenario: verify Login button is present
    When Admin gives the correct LMS portal URL
    Then Admin should see login button 
    
      Scenario: Verify the alignment of the login button
    When Admin gives the correct LMS portal URL
    Then Admin should see login button on the centre of the page
    
     Scenario: Verify input descriptive test in Admin field
    When Admin gives the correct LMS portal URL
    Then Admin should see Admin in gray color
    
    Scenario: Verify input descriptive test in password field
    When Admin gives the correct LMS portal URL
    Then Admin should see password in gray color
    
     Scenario: Validate login with valid credentials
    When Admin enter valid credentials  and clicks login button 
    Then Admin should land on dashboard page ( centre of the page will be empty , menu bar is present).  
    
      Scenario: Validate login with invalid credentials
    When Admin enter invalid credentials  and clicks login button 
    Then Error message please check Adminname/password
    
         Scenario: Validate login credentials with null Adminname
    When Admin enter value only in password and clicks login button 
    Then Error message please check Adminname/password
    
        Scenario: Validate login credentials with null password
    When Admin enter value only in Adminname and clicks login button  
    Then Error message please check Adminname/password
    
       Scenario: Validate login credentials with null password
    When Admin enter valid credentials  and clicks login button through keyboard 
    Then Admin should land on dashboard page
    
     Scenario: verify login button action through mouse
    When Admin enter valid credentials  and clicks login button through mouse 
    Then Admin should land on dashboard page
    
    
    