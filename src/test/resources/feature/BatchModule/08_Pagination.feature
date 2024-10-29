@BatchPagination
Feature: Pagination Validation

  Background: Admin is on the batch page
    Given The Admin is on the login page of the LMS Portal
    When Admin is on the Batch page after login successful
    
@BatchPaginationNextLink   @BatchPaginationTC_1001
  Scenario: Validate next page link
    When Admin clicks next page link on the data table
    Then Admin should see the Next enabled link

#@BatchPaginationlastpage   @BatchPaginationTC_1002
  #Scenario: Validate last page link
    #When Admin clicks last page link on the data table
    #Then Admin should see the last page link with next page link disabled on the table
#
  #Scenario: Validate the backward page link
    #When Admin clicks backward page link on the data table
    #Then Admin should see the previous page on the table
#
  #Scenario: Validate the first page link
    #When Admin clicks first page link on the data table
    #Then Admin should see the very first page on the data table
