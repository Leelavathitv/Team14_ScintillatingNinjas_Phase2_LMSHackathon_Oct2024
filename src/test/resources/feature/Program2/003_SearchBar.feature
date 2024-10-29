@Program2
Feature: Manage Program - Search bar

  Background: Admin is on program module after reaching dashboard
    Given Admin is on Program module
    When Admin is logged in successfully and is in program module page

  @Program2 @SearchBarTC_1
  Scenario Outline: Verify Admin is able to search results found for program name
    When Admin enter the program to search By program name from sheet "<option>" and "<sheetName>"
    Then Admin should able to see Program name, description, and status for searched program name "LeelaLMSOneName"

    Examples: 
      | option           | sheetName   |
      | ValidProgramData | ProgramPage |

  #@Program2 @SearchBarTC_2
  #Scenario: Verify Admin is able to search results found for program description
    #When Admin enter the program to search By program description "LeelaLMSOneDesc"
    #Then Admin should able to see Program name, description, and status for searched program description "LeelaLMSOneDesc"
#
  #@Program2 @SearchBarTC_3
  #Scenario: Verify Admin is able to search results not found
    #When Admin enter the program to search By program name that does not exist "LeelaLMSNotFound"
    #Then There should be zero results for "LeelaLMSNotFound"
#
  #@Program2 @SearchBarTC_4
  #Scenario: Verify Admin is able to search with partial program name
    #When Admin enter the program to search By partial name of program "LeelaLMS"
    #Then Admin should able to see Program name, description, and status for searched program name "LeelaLMS"
