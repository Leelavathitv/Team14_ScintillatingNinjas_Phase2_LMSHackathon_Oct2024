@DeleteMulBatch
Feature: Delete multiple batches with check box

  Background: Admin is on the batch page

  Scenario: Validate single row delete with checkbox
    When Admin clicks on the delete icon under the Manage batch header
    Then The respective row in the table should be deleted

  Scenario: Validate multiple row delete with checkbox
    When Admin clicks on the delete icon under the Manage batch header
    Then The respective row in the table should be deleted
