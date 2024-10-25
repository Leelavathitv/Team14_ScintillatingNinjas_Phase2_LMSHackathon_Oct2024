@Program2
Feature: Manage Program - Pagination3

Background: Admin is logged in to LMS Portal with >=5 records in program list
Given: Admin is logged in to LMS Portal
When: Admin is logged in to LMS Portal with >=5 records in program list
  
  Scenario: Verify pagination when there are no records
    Given Admin is on dashboard page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see pagination icons disabled
 
