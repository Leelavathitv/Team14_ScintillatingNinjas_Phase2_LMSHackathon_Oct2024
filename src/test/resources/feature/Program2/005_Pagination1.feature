@ProgramPagination
Feature: Manage Program - Pagination

  Background: Admin is on program module after reaching dashboard
    Given Admin is on Program module
    When Admin is logged in successfully and is in program module page

  @ProgramPagination @PaginationTC_01
  Scenario: Verify Admin is able to click Next page link
    When Admin clicks Next page link on the program table
    Then Admin should see the Pagination has "Next" active link

  @ProgramPagination @PaginationTC_02
  Scenario: Verify Admin is able to click  Last page link
    When Admin clicks Last page link
    Then Admin should see the last page record on the table with Next page link are disabled

  @ProgramPagination @PaginationTC_03
  Scenario: Verify Admin is able to click Previous page link
    Given Admin is on last page of Program module table
    When Admin clicks Previous page link
    Then Admin should see previous page record of the table with pagination has previous page link

  @ProgramPagination @PaginationTC_04
  Scenario: Verify Admin is able to click  First page link
    Given Admin is on Previous Program page
    When Admin clicks First Program page
    Then Admin should see the very first page record of the table with Previous page link are disabled
