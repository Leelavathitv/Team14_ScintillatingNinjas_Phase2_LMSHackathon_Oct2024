
@Program2
Feature: Manage Program - Pagination2

  Background: Admin is logged in to LMS Portal with no records in program list
    Given Admin is on dashboard page after Login
    When Admin is logged in to LMS Portal with no records in program list

  Scenario: Verify pagination when there are no records
    When Admin clicks Program on the navigation bar
    Then Admin should not see any pagination icons and message "No records found"
