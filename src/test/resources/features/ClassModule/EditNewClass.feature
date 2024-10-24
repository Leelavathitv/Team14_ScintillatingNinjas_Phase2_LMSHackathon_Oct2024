@tag
Feature: Edit New Class

Background: Admin is on the Manage Class page after login
  Given Admin is on the Manage class page

 @tag1 
  Scenario: Validate row level edit icon
    Given Admin is on the Manage class page
    When Admin clicks on the edit icon
    Then A new popup with class detail appears


  @tag2
  Scenario: Check disabled batch name
    Given Admin is on the Manage class page
    When Admin clicks on the edit icon
    Then Admin should see batch name field is disabled
    
    @tag3
  Scenario: Check disabled class topic
    Given Admin is on the Manage class page
    When Admin clicks on the edit icon
    Then Admin should see class topic field is disabled
    
    @tag4
  Scenario: Check if the fields are updated with valid data
    Given Admin is on the Edit class popup window
    When Update the fields with valid data and click save
    Then Admin gets message "class details updated Successfully" and see the updated values in data table
    
    @tag5
  Scenario: Check if the fields are updated with invalid values
    Given Admin is on the Edit class popup window
    When Update the fields with invalid values and click save
    Then Admin should get Error message
    
    @tag6
  Scenario: Check if the mandatory fields are updated with valid data
    Given Admin is on the Edit class popup window
    When Update the mandatory fields with valid values and click save
    Then Admin gets message "Class details updated Successfully" and see the updated values in data table
    
    @tag7
  Scenario: Check if the optional fields are updated with valid data
    Given Admin is on the Edit class popup window
    When Update the optional fields with valid values and click save
    Then Admin gets message "Class details updated Successfully" and see the updated values in data table
    
    @tag8
  Scenario: Validate invalid values in the text fields
    Given Admin is on the Edit class popup window
    When Admin enters only numbers or special char in the text fields
    Then Admin should get Error message
    
    @tag9
  Scenario: Validate Cancel button on edit popup
    Given Admin is on the Edit class popup window
    When Admin clicks Cancel button on edit popup in class module
    Then Admin can see the class details popup disappears and can see nothing changed for particular class
    
     

   