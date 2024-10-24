
@tag
Feature: Sort Class Details
  
  Background: Admin is on the Manage class page after login
	Given Admin is on the Manage class page
	
  @tag1
  Scenario: Sort class by Batch name
    Given Admin is on the Manage class page	
    When Admin clicks on the Batchname sort icon    
    Then Admin should see Class details are sorted by Batchname


  @tag2
  Scenario: Sort Class by Class topic
    Given Admin is on the Manage class page	
    When Admin clicks on the class topic sort icon
    Then Admin should see Class details are sorted by Class Topic

    @tag3
  Scenario: Sort Class by Class Description
    Given Admin is on the Manage class page	
    When  Admin clicks on the Class description sort icon   
    Then Admin should see Class details are sorted by Class description
    
    @tag4
  Scenario: Sort Class by Status
    Given Admin is on the Manage class page	
    When Admin clicks on the Status sort icon    
    Then Admin should see Class details are sorted by Status
    
    @tag5
  Scenario: Sort Class by Class date
    Given Admin is on the Manage class page	
    When  Admin clicks on the Class date sort icon   
    Then Admin should see class details are sorted by Class date
    
    @tag6
  Scenario: Sort Class by staff name
    Given Admin is on the Manage class page	
    When Admin clicks on the Staff Name sort icon    
    Then Admin should see class details are sorted by Staff name              
