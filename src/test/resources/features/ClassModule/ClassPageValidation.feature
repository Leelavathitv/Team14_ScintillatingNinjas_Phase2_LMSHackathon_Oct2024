
@tag
Feature: Class Page Validation

Background: Admin is on the Dashboard page after login
			Given Admin is on the Dashboard page after login
  
  @tag1
  Scenario: Validating the class manage page
    Given Admin is on the Dashboard Page
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should land on the Manage class page
    
  @tag2
  Scenario: Validating the Title in the Manage class page
    Given Admin is on the dashboard page after login
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the "LMS-Learning Management System" Title

@tag3
  Scenario: Validating the Header in the Manage class page
    Given Admin is on the dashboard page after login
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the "Manage Class" Header
    
	@tag4
  Scenario: Validating Search bar in class page
    Given Admin is on the dashboard page after login
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the Searchbar in Manage class page
    
    @tag5
  Scenario: Validating the data table headers in the class page
    Given Admin is on the dashboard page after login
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the datatable heading like Batchname, class topic, class description, status, classDate, staff name, Edit/Delete
    
    @tag6
  Scenario: Validating the text and pagination icon in the class page
    Given Admin is on the dashboard page after login
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the "showing x to y of z entries" and enabled pagination controls under the data table

		@tag7
  Scenario: Validate the sort icon of all the field in datatable
    Given Admin is on the dashboard page after login
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the Sort icon of all the field in the datatable
		
		@tag8
  Scenario: Validating the Delete button under the Manage class 
    Given Admin is on the dashboard page after login
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see the Delete button under the Manage class page header
		
		@tag9
  Scenario: Validate the total no of classes in manage class page
    Given Admin is on the dashboard page after login
    When Admin clicks the Class Navigation bar in the Header
    Then Admin should see Total no of classes in below of the data table
		





    
