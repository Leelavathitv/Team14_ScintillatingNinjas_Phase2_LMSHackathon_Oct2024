Feature: Add New Program Functionality

 	Background: 
 		Given Admin is on program module after reaching dashboard

 	Scenario: Verify add New Program 	
 	 When Admin clicks on "New Program" under the "Program" menu bar
 	 Then Admin should see pop up window for program details
	 
 	Scenario: Verify title of the pop up window 		
 		When Admin clicks on "New Program" under the "Program" menu bar
 		Then Admin should see window title as "Program Details"
		
 	Scenario: Verify mandatory fields with red "*" mark 
 		When Admin clicks on "New Program" under the "Program" menu bar
 		Then Admin should see red "*" mark beside mandatory field "Name"
 		
 	Scenario: Verify empty form submission
 		Given Admin is on Program details form
 		When Admin clicks save button without entering mandatory 
 		Then Admin gets message '<field> is required'
 	
 	Scenario: Verify cancel button
 		Given Admin is on Program details form
 		When Admin clicks Cancel button
 		Then Admin can see the Program details form disappears 
 		
 	Scenario: Verify enter program name
 		Given Admin is on Program details form
 		When Admin enters the Name in the text box
 		Then Admin can see the text entered
 		
 	Scenario: Verify enter description
 		Given Admin is on Program details form
 		When Admin enters the Description in text box
 		Then Admin can see the text entered in description box
 		
 	Scenario: Verify select Status
 		Given Admin is on Program details form
 		When Admin selects the status of the program by clicking on the radio button "(Active/InActive)"
 		Then Admin can see 'Active/Inactive' status selected
 		
 	Scenario: Verify Admin is able to save the program details
 		Given Admin is on Program details form
 		When Admin enter valid details for mandatory fields and Click on save button
 		Then Admin gets message 'Successful Program created'
 		
 	Scenario: Verify cancel program details
 		Given Admin is on Program details form
 		When Admin Click on cancel button
 		Then Admin can see the Program details form disappears
 		
 	Scenario: Verify added Program is created
 		When Admin searches with newly created "Program Name"
 		Then Records of the newly created "Program Name" is displayed and match the data entered
 		
 	Scenario: Verify close window with "X" 
 		Given Admin is on Program details form
 		When Admin Click on "X" button
 		Then Admin can see the Program details form disappears
 		
 	@EditProgram
 	Scenario: Verify Edit option 		
 		When Admin clicks on Edit option for particular program
 		Then Admin can see the Program details form disappears
 		
 		
 	Scenario: Verify title of the pop up window
 		When Admin clicks on Edit option for particular program
 		Then Admin should see window title as "Program Details"
 		
 	Scenario: Verify mandatory fields with red "*" mark 
 		When Admin clicks on Edit option for particular program
 		Then Admin should see red "*" mark beside mandatory field "Name"
 	
 	Scenario: Verify edit Program Name
 		When Admin edits the program name and click on save button
 		Then Updated program name is seen by the Admin
 		
 	Scenario: Verify edit Description
 		When Admin edits the description text and click on save button
 		Then Admin can see the description is updated
 		
 	Scenario: Verify edit Status
 		When Admin can change the status of the program and click on save button
 		Then Status updated can be viewed by the Admin
 		
 	Scenario: Verify Admin is able to click Save
 		When Admin click on save button
 		Then Admin can see the updated program details
		
 	Scenario: Verify Admin is able to click Cancel
 		When Admin Click on cancel button
 		Then Admin can see the Program details form disappears
 		
 	Scenario: Verify edited Program details
 		When Admin searches with newly updated "Program Name"
 		Then Admin verifies that the details are correctly updated.
	
 	Scenario: Verify close the window with "X" 
 		When Admin Click on "X" button
 		Then Admin can see the Program details form disappears
 		
 		
 		
 		
 		
 		
 		
 		
 		










 