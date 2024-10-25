
@ClassSort
Feature: Sort Class Details
  
  Background: Admin is on the Manage class page after login
	Given Admin is on the Manage class page
	
  
  Scenario: Sort class by Batch name
    When Admin clicks on the Batchname sort icon    
    Then Admin should see Class details are sorted by Batchname

 
  Scenario: Sort Class by Class topic
    When Admin clicks on the class topic sort icon
    Then Admin should see Class details are sorted by Class Topic

    
  Scenario: Sort Class by Class Description
    When  Admin clicks on the Class description sort icon   
    Then Admin should see Class details are sorted by Class description
    
   
  Scenario: Sort Class by Status
    When Admin clicks on the Status sort icon    
    Then Admin should see Class details are sorted by Status
    
    
  Scenario: Sort Class by Class date
    When  Admin clicks on the Class date sort icon   
    Then Admin should see class details are sorted by Class date
    
   
  Scenario: Sort Class by staff name
    When Admin clicks on the Staff Name sort icon    
    Then Admin should see class details are sorted by Staff name              
