Feature: Login Page Verification
  The admin should be able to verify all elements of the login page are correct and functional.

  Background:
    Given Admin launches the browser
    When Admin gives the correct LMS portal URL

  #Scenario: Verify Admin is able to land on login page
    #When Admin gives the correct LMS portal URL
    #Then Admin should land on the login page

  #Scenario: Verify Admin is able to land on home page with invalid URL
    #When Admin gives the invalid LMS portal URL
    #Then Admin should receive 404 page not found error

  #Scenario: Verify for broken link
    #When Admin gives the correct LMS portal URL
    #Then HTTP response >= 400 and the link is broken

  Scenario Outline: Verify the text spelling in the page
    When Admin gives the correct LMS portal URL
    Then Admin should see correct spelling for the "<Scenario>" in login page from "<SheetName>"

	Examples:
	 | Scenario				|		SheetName	|
		|	VerifyPageText	|		Login	|

  #Scenario: Verify the company logo
    #When Admin gives the correct LMS portal URL
    #Then Admin should see the logo on the left side
#
  #Scenario: Verify application name
    #When Admin gives the correct LMS portal URL
    #Then Admin should see "LMS - Learning Management System"
#
  #Scenario: Verify company name
    #When Admin gives the correct LMS portal URL
    #Then Admin should see the company name below the app name
#
  #Scenario: Validate sign-in content
    #When Admin gives the correct LMS portal URL
    #Then Admin should see "Please login to LMS application"
#
  #Scenario: Verify text field is present
    #When Admin gives the correct LMS portal URL
    #Then Admin should see two text fields
#
  #Scenario: Verify text on the first text field
    #When Admin gives the correct LMS portal URL
    #Then Admin should see "User" in the first text field
#
  #Scenario: Verify asterisk next to Admin text
    #When Admin gives the correct LMS portal URL
    #Then Admin should see field mandatory aestrik symbol next to Admin text
#
  #Scenario: Verify text on the second text field
    #When Admin gives the correct LMS portal URL
    #Then Admin should see "Password" in the second text field
#
  #Scenario: Verify asterisk next to password text
    #When Admin gives the correct LMS portal URL
    #Then Admin should see aestrik symbol next to the password text
#
  #Scenario: Verify the alignment of the login input fields
    #When Admin gives the correct LMS portal URL
    #Then Admin should see the text fields aligned correctly
#
     #Scenario: verify Login button is present
    #When Admin gives the correct LMS portal URL
    #Then Admin should see login button 
    #
      #Scenario: Verify the alignment of the login button
    #When Admin gives the correct LMS portal URL
    #Then Admin should see login button on the centre of the page
   #
  #
  #Scenario Outline: Validate login credentials with null username
    #When Admin enter value only in password from sheet "<option>" and "<sheetName>" and clicks login button
    #Then Error message please enter username
#
    #Examples: 
      #| option              | sheetName |
      #| InValidNullUsername | Login |
#
 #
  #Scenario Outline: Validate login credentials with null password
    #When Admin enter value only in username from sheet "<option>" and "<sheetName>" and clicks login button
    #Then Error message please enter password
#
    #Examples: 
      #| option              | sheetName |
      #| InValidNullPassword | Login |
#
  #
  #Scenario Outline: Validate login credentials with password as numeric
    #When Admin enter value only only numeric value in password from sheet "<option>" and "<sheetName>" and clicks login button
    #Then Error message please check username/password
#
    #Examples: 
      #| option                    | sheetName |
      #| InValidPasswordAllNumeric | Login |
#
  #
  #Scenario: Validate login credentials when user click Login button directly without entering any details
    #When Admin enter no value only in input and password field and click on Loginbutton
    #Then Error message please enter username and password
#
#