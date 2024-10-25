Feature: Search Text box validation

  Background: Admin is on the batch page

  Scenario: Validate search box functionality
    When Admin enters the batch name in the serach text box
    Then Admin should see the filtered batches in the data table
