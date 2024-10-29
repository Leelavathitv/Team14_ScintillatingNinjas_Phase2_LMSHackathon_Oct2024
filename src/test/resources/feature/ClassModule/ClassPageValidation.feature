
@ClassPV
Feature: Class Page Validation

Background: Admin is on the Dashboard page after login
		 	Given Admin launch the browser
  		When Admin enters valid credentials and clicks login
  		Then Admin clicks the Class Navigation bar in the Header
  		
 
 @ClassPV @CM-001
Scenario: Validating the class manage page
  	Given Admin is on the Dashboard page after login
    Then Admin should land on the Manage class page
    
  @ClassPV @CM-002
  Scenario: Validating the Title in the Manage class page
    Then Admin should see the LMS Learning Management System Title

@ClassPV @CM-003
  Scenario: Validating the Header in the Manage class page
    Then Admin should see the Manage Class Header
    
@ClassPV @CM-004
  Scenario: Validating Search bar in class page
    Then Admin should see the Searchbar in Manage class page
    
  @ClassPV @CM-005
  Scenario: Validating the data table headers in the class page
     Then Admin should see the datatable heading like Batchname, class topic, class description, status, classDate, staff name, Edit/Delete
    
    @ClassPV @CM-006
  Scenario: Validating the text and pagination icon in the class page    
    Then Admin should see the showing x to y of z entries and enabled pagination controls under the data table

@ClassPV @CM-007	
  Scenario: Validate the sort icon of all the field in datatable
    Then Admin should see the Sort icon of all the field in the datatable
	
@ClassPV @CM-008		
  Scenario: Validating the Delete button under the Manage class     
    Then Admin should see the Delete button under the Manage class page header
		
	@ClassPV @CM-009	
  Scenario: Validate the total no of classes in manage class page    
    Then Admin should see Total no of classes in below of the data table
	





    