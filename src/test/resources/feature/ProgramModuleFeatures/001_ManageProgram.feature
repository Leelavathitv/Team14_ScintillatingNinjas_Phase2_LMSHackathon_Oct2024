Feature: LMS application login and program module

	Background: 
	Given Admin is logged in to LMS Portal

@ProgramPageNavigation @ProgramTC_001
	Scenario Outline: Verify that Admin is able to navigate to Program module
		
		When Admin clicks "<module>" on the navigation bar
		Then Admin should be navigated to "<module>" module	
		
	Examples:
	|module|
	|Program|
	
@ProgramPageMenuBar	@ProgramTC_001
	Scenario Outline: Verify any broken links on program page  
	When Admin clicks "<module>" on the navigation bar
	Then Admin should not have any broken links for Program module
	
	Examples:
	|module|
	|Program|
	
@ProgramPageMenuBar	@ProgramTC_002
	Scenario Outline: Verify heading in menu bar
		Given Admin is on dashboard page after Login
		When Admin clicks "<module>" on the navigation bar
		Then Admin should see the heading "LMS - Learning Management System"
		
	Examples:
	|module|
	|Program|
	
@ProgramPageMenuBar	@ProgramTC_003	
	Scenario Outline: Verify other module's name displayed in menu bar
		Given Admin is on dashboard page after Login
		When Admin clicks "<module>" on the navigation bar
		Then Admin should see the module names as in order "<expectedModules>"
		
	Examples:
      | module  | expectedModules                                   |
      | Program | Home, Program, Batch, Class, Admin, Assignment, Attendance |
      
   @ProgramPageMenuBar	@ProgramTC_004
	Scenario Outline: Verify Logout displayed in menu bar
		Given Admin is on dashboard page after Login
		When Admin clicks "<module>" on the navigation bar
		Then Admin should see "Logout" in menu bar
		
Examples:
	|module|
	|Program|
	
@ProgramPageMenuBar	@ProgramTC_005
	Scenario Outline: Verify sub menu displayed in program menu bar
		Given Admin is on program page
		When Admin clicks "<module>" on the navigation bar
		Then Admin should see sub menu in menu bars as "Add New Program"	
Examples:
	|module|
	|Program|
	
	
@ManageProgramPageValidation @ProgramTC_006	
	Scenario Outline: Verify heading in manage program
		Given Admin is on dashboard page after Login
		When Admin clicks "<module>" on the navigation bar
		Then Admin should see the heading "Manage Program" inside "<module>"
		
Examples:
	|module|
	|Program|
	
@VerifyProgramDetails	@ProgramTC_007		
Scenario Outline: Verify view details of programs
		Given Admin is on dashboard page after Login
		When Admin clicks "<module>" on the navigation bar
		Then Admin should able to see Program name, description, and status for each "<module>"
Examples:
	|module|
	|Program|	
	
@VerifyMultipleDelete	@ProgramTC_008	
Scenario Outline: Verify the Multiple Delete button state 
		Given Admin is on dashboard page after Login
		When Admin clicks "<module>" on the navigation bar
		Then Admin should see a Delete button in left top is disabled
		
	Examples:
	|module|
	|Program|
	
		
	
