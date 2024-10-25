@DeleteBatch
Feature: Delete batch validation

  Background: Admin is on the batch page

  Scenario: Validate delete Icon on any row
    When Admin clicks the delete Icon on any row
    Then Admin should see the confirm alert box with yes and no button

  Scenario: Validate yes button on the confirm alert box
    Given Admin is on the batch confirm popup page
    When Admin clicks on the delete icon and click yes buttton
    Then Admin should see the successfull message and the batch should be deleted

  Scenario: Validate no button on the confirm alert box
    Given Admin is on the batch confirm popup page
    When Admin clicks on the delete icon and click no buttton
    Then Admin should see the alert box closed and the batch is not deleted

  Scenario: Validate close Icon on the alert box
    Given Admin is on the batch confirm popup page
    When Admin clicks on the close icon
    Then Admin should see the alert box closed
