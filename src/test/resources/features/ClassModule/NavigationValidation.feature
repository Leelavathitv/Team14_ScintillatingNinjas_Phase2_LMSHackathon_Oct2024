
@tag
Feature: Navigation Validation from Manage Class to other pages

Background: Admin is on dashboard page after login and clicks Class on the navigation bar
   Given Admin is on Manage class page
   
  @tag1
  Scenario: Class link on navigation bar
    Given Admin is on Manage class page
    When Admin clicks on Class link on Manage class page
    Then Admin is re-directed to class page

  @tag2
  Scenario: Class link to other module on navigation bar
    Given Admin is on Manage class page
    When Admin clicks on any module link on Manage Class Page
    Then Admin is re-directed to which module link been clicked
    
    @tag3
  Scenario: Logout link on navigation bar
    Given Admin is on Manage class page
    When Admin clicks on Logout link on Manage class page
    Then Admin is re-directed to Login page

    