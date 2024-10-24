

@tag
Feature: Delete Class

Background: Admin is on the Manage class page after login
  Given Admin is on Manage Class page

  @tag1
  Scenario: Validate row level delete icon
    Given Admin is on Manage class page
    When Admin clicks the delete icon
    Then Admin should see a alert open with heading "Confirm" along with <YES> and <NO> button for deletion
    
    @tag2
  Scenario: Click Yes on deletion window
    Given Admin is on Confirm Deletion alert
    When Admin clicks Yes option
    Then Admin gets a message "Successful Class Deleted" alert and do not see that Class in the datatable
    
    @tag3
  Scenario: Click No on deletion window
    Given Admin is on Confirm Deletion alert
    When Admin clicks No option
    Then Admin can see the deletion alert disappears without deleting
    
    @tag4
  Scenario: Validate Close(X) icon on Confirm Deletion alert
    Given Admin is on Confirm Deletion alert
    When Admin clicks on Close button
    Then Admin can see the deletion alert disappears without any changes

  
