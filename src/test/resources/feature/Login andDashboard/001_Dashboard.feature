Feature: Dashboard Page

  Background: 
    Given Admin gives the correct LMS portal URL

  Scenario Outline: Verify after login Admin lands on dashboard page
    Given Admin is in loginPage
    When Admin enters valid credentials from excel "<Scenario>" and "<SheetName>" and clicks submit
    Then Admin should see dashboard
    
    Examples:
		| Scenario		|		SheetName	|
		|	ValidLogin	|		Login	|
    

  Scenario: Verify the response time
    Given Admin is in loginPage
    Then Maximum navigation time in milliseconds should default to 30 seconds

  Scenario: Verify broken link
    Given Admin is in loginPage
    When Admin enters valid credentials and clicks
    Then HTTP response should be >= 400 and the link is broken

  Scenario: Verify LMS title
    Given Admin is in loginPage
    When Admin enters valid credentials and clicks
    Then Admin should see LMS - Learning Management System as title
	
	  Scenario: Verify LMS title alignment
	    Given Admin is in loginPage
	    When Admin enters valid credentials and clicks
	    Then LMS title should be on the top left corner of page
	
  Scenario Outline: Validate navigation bar text
    Given Admin is in loginPage
    When Admin enters valid credentials and clicks
    Then Admin should see correct spelling for the "<Scenario>" in navigation bar text from "<SheetName>"
    
    Examples:
    | Scenario				|		SheetName	|
		|	VerifyHeaderText	|		DashBoard	|
 
  Scenario: Validate LMS title has correct spelling and space
    Given Admin is in loginPage
    When Admin enters valid credentials and clicks
    Then Admin should see correct spelling and space in LMS title

  Scenario: Validate alignment for navigation bar
    Given Admin is in loginPage
    When Admin enters valid credentials and clicks
    Then Admin should see the navigation bar text on the top right side

  Scenario: Validate navigation bar order 1st home
    Given Admin is in loginPage
    When Admin enters valid credentials and clicks
    Then Admin should see menu in the correct order