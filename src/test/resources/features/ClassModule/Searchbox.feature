
@tag
Feature: Search Box

Background: Admin is on the Manage Class page after login
   Given Admin is on the Manage class page
 

  @tag1
  Scenario: Search class by Batch Name
    Given Admin is on the Manage class page
    When Admin enter the Batch Name in search textbox
    Then Admin should see Class details are searched by Batch Name

  @tag2
  Scenario: Saerch class by Class topic
    Given Admin is on the Manage class page
    When Admin enter the Class topic in search textbox
    Then Admin should see Class details are searched by Class topic
    
    @tag3
  Scenario: Search class by Staff name
    Given Admin is on the Manage class page
    When Admin enter the Staff Name in search textbox
    Then Admin should see Class details are searched by Staff name

   