@tag
Feature: Pagination Class 
  
  Background: Admin is on the Manage Class page after login
   Given Admin is on Manage class page

  @tag1
  Scenario: Verify Next page link(>)
    Given Admin is on Manage class page
    When Admin clicks Next page link on the class table
    Then Admin should see the next page record on the table with Pagination has next active link enabled

  @tag2
  Scenario: Verify Last Page link(>>)
    Given Admin is on Manage class page
    When Admin clicks Last page link
    Then Admin should see the last page record on the table with Next page link are disabled
    
    @tag3
  Scenario: Verify First Page link(<)
    Given Admin is on last page of class table
    When Admin clicks First page link
    Then Admin should see the previous page record on the table with pagination has previous page link enabled
    
    @tag4
  Scenario: Verify Start Page link(<<)
    Given Admin is on Previous class page
    When Admin clicks Start page link
    Then Admin should see the very first page record on the table with Previous page link are disabled

   