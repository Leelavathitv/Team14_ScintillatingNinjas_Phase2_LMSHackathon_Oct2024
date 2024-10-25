
@ClassPV
Feature: Class Page Validation

Background: Admin is on the Dashboard page after login
			Given Admin is on the Dashboard page after login
  
 
  Scenario: Validating the class manage page
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should land on the Manage class page
    
  
  Scenario: Validating the Title in the Manage class page
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the "LMS-Learning Management System" Title


  Scenario: Validating the Header in the Manage class page
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the "Manage Class" Header
    
	
  Scenario: Validating Search bar in class page
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the Searchbar in Manage class page
    
    
  Scenario: Validating the data table headers in the class page
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the datatable heading like Batchname, class topic, class description, status, classDate, staff name, Edit/Delete
    
    
  Scenario: Validating the text and pagination icon in the class page
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the "showing x to y of z entries" and enabled pagination controls under the data table

		
  Scenario: Validate the sort icon of all the field in datatable
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the Sort icon of all the field in the datatable
		
		
  Scenario: Validating the Delete button under the Manage class 
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the Delete button under the Manage class page header
		
		
  Scenario: Validate the total no of classes in manage class page
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see Total no of classes in below of the data table
		





    
