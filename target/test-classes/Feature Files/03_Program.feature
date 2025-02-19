Feature: Manage Page Validation

  #These all steps are from login Module
Background: Admin is logged in to LMS Portal
Given Admin is in login Page to test Program module
When Admin enter valid credentials  and clicks login button through keyboard for Program module
Then Admin should land on dashboard page On Program module

  #This step is common in class module Given Admin is on dashboard page after Login
Scenario: Verify that Admin is able to navigate to Program module
    When  Admin clicks "Program" on the navigation bar in program module
    Then Admin should be navigated to Program module
   #---------------------------------------------------------------------------------- 
    Scenario: Verify heading in menu bar  
    When  Admin clicks "Program" on the navigation bar in program module
    Then Admin should see the heading "LMS - Learning Management System" for program
    
Scenario: Verify other modules name displayed in menu bar
    #Given Admin is on dashboard page after Login
    When  Admin clicks "Program" on the navigation bar in program module
    Then Admin should see the module names as in order "Program Batch Class " for program
    
Scenario: Verify Logout displayed in menu bar
    #Given Admin is on dashboard page after Login
    When  Admin clicks "Program" on the navigation bar in program module
    Then Admin should see "Logout" in menu bar for program
    
Scenario: Verify sub menu displayed in program menu bar
   # Given Admin is on program page
    When  Admin clicks "Program" on the navigation bar in program module
    Then Admin should see sub menu in menu bar as "Add New Program" for program
    #--------------------------------------------------------------------------------------
    Scenario: Verify heading in manage program
    #Given Admin is on dashboard page after Login
    When  Admin clicks "Program" on the navigation bar in program module
    Then Admin should see the heading  "Manage Program" for each program
    
   #2 
Scenario: Verify view details of programs
    #Given Admin is on dashboard page after Login
   When  Admin clicks "Program" on the navigation bar in program module
    Then Admin should able to see Program name, description, and status for each program
  
  #3  
Scenario: Verify the Multiple Delete button state 
    #Given Admin is on dashboard page after Login
   When  Admin clicks "Program" on the navigation bar in program module
    Then Admin should see a Delete button in left top is disabled
 
  #4  
Scenario: Verify the Search button  
    #Given Admin is on dashboard page after Login
   When  Admin clicks "Program" on the navigation bar in program module
    Then Admin should see Search bar with text as "Search..."
 
 #5   
#Scenario: Verify column header name of data table  
    #Given Admin is on dashboard page after Login
  # When  Admin clicks "Program" on the navigation bar in program module
    #Then Admin should see data table with column header on the Manage Program Page as  Program Name, Program Description, Program Status, Edit/Delete
 
 #6   
Scenario: Verify checkbox default state beside Program Name column header
   # Given Admin is on dashboard page after Login
   When  Admin clicks "Program" on the navigation bar in program module
    Then Admin should see checkbox default state as unchecked beside Program Name column header
 #7    
Scenario: Verify checkboxes default state beside each Program names in the data table
   # Given Admin is on dashboard page after Login
    When  Admin clicks "Program" on the navigation bar in program module
    Then Admin should see check box default state as unchecked on the left side in all rows against program name 
 
 #8   
Scenario: Verify Sort icon in manage program
    #Given Admin is on dashboard page after Login
    When  Admin clicks "Program" on the navigation bar in program module
    Then Admin should see the sort arrow icon beside to each column header except Edit and Delete 
 #9    
Scenario: Verify edit and delete icon in manage program
    #Given Admin is on dashboard page after Login
    When  Admin clicks "Program" on the navigation bar in program module
    Then Admin should see the Edit and Delete buttons on each row of the data table 
 #10    
Scenario: Verify pagination icons below data table in manage program
   # Given Admin is on dashboard page after Login
    When  Admin clicks "Program" on the navigation bar in program module
    Then Admin should see the text as "Showing x to y of z entries" along with Pagination icon below the table.
#11     
Scenario: Verify footer message in manage program
    #Given Admin is on dashboard page after Login
    When  Admin clicks "Program" on the navigation bar in program module
    Then Admin should see the footer as "In total there are z programs".
    
    #--------------------------------------------------------------------------------------------------------
    
    Scenario: Verify add New Program
   # Given  Admin is on Program module
    When Admin clicks on "New Program" under the "Program" menu bar
    Then Admin should see pop up window for program details
    
  #2
  Scenario: Verify title of the pop up window
    #Given  Admin is on Program module
    When Admin clicks on "New Program" under the "Program" menu bar
    Then Admin should see window title as "Program Details" for popup
    
  #3
   Scenario: Verify mandatory fields with red "*" mark 
    #Given  Admin is on Program module
    When Admin clicks on "New Program" under the "Program" menu bar
    Then Admin should see red "*" mark beside mandatory field "Name" in popup
    
  #4
  
  Scenario: Verify empty form submission
    #Given  Admin is on Program details form
    Given Admin clicks on "New Program" under the "Program" menu bar
    When  Admin clicks save button without entering mandatory fiels in add new program form
    Then Admin gets message '<field> is required' in popup
    
   Scenario: Verify cancel button
    #Given  Admin is on Program details form
    Given Admin clicks on "New Program" under the "Program" menu bar
    When  Admin clicks Cancel button in new program form
    Then Admin can see Program Details form disappears
    
    Scenario: Verify enter program name
    Given Admin clicks on "New Program" under the "Program" menu bar
    When  Admin enters the Name in the text box
    Then Admin can see the program name entered
    
    Scenario: Verify enter description
    Given Admin clicks on "New Program" under the "Program" menu bar
    When  Admin enters the Description in text box
    Then Admin can see the text entered in description box
    
    Scenario: Verify select Status
   Given Admin clicks on "New Program" under the "Program" menu bar
    When  Admin selects the status of the program by clicking on the radio button "(Active/InActive)"
    Then Admin can see 'Active/Inactive' status selected
    
    Scenario: Verify Admin is able to save the program details
    Given Admin clicks on "New Program" under the "Program" menu bar
    When  Admin enter valid details for mandatory fields and Click on save button
    Then Admin gets message ' Program Created Successfully'
    
    Scenario: Verify cancel program details
   Given Admin clicks on "New Program" under the "Program" menu bar
    When  Admin Click on cancel button
    Then Admin can see program details form disappear after click on cancel
    
    Scenario: Verify added Program is created
   Given Admin clicks on "New Program" under the "Program" menu bar
    When  Admin searches with newly created "Program Name"
    Then Records of the newly created  "Program Name" is displayed and match the data entered
    
    Scenario: Verify close window with "X" 
    Given Admin clicks on "New Program" under the "Program" menu bar
    When  Admin Click on "X" button
    Then Admin can see program details form disappear
    
  #------------------------Edit Program--------------------------------------------------
  
    Scenario: Verify Edit option 
    Given Admin is on Program page
    When  Admin clicks on Edit option for particular program
    Then Admin lands on Program details form
    
    Scenario: Verify title of the pop up window
    Given Admin is on Program page
    When  Admin clicks on Edit option for particular program
    Then Admin should see window title as "Program Details"
    
    Scenario: Verify mandatory fields with red asterisk mark 
    Given Admin is on Program page
    When  Admin clicks on Edit option for particular program
    Then Admin should see red asterisk mark beside mandatory field "Name"
    
    Scenario: Verify edit Program Name 
    Given Admin is on Program page
    When  Admin edits the program name and click on save button
    Then Updated program name is seen by the Admin
    
    Scenario: Verify edit Description
    Given Admin is on Program page
    When  Admin edits the description text and click on save button
    Then Admin can see the description is updated
    
    Scenario: Verify edit Status
    Given Admin is on Program page
    When  Admin can change the status of the program and click on save button
    Then Status updated can be viewed by the Admin
    
    Scenario: Verify Admin is able to click Save 
    Given Admin is on Program page
    When  Admin click on save button
    Then Admin can see the updated program details
    
    
     Scenario: Verify Admin is able to click Cancel
    Given Admin is on Program page
    When  Admin click on cancel button
    Then Admin can see the Program details form disappears
    
    Scenario: Verify edited Program details
    Given Admin is on Program page
    When  Admin searches with newly updated "Program Name"
    Then Admin verifies that the details are correctly updated.
    
    Scenario: Verify close the window with "X" 
    Given Admin is on Program page
    When  Admin Click on "X" button
    Then Admin can see program details form disappear
    
    
    
   # --------------------------------------DELETEProgram------------------------------------------------------------------
    
    Scenario: Admin checks Succes delete operation with single program delete
    Given  Admin clicks "Program" on the navigation bar in program module for delete and sort
    When Admin clicks on the delete icon on program module page
    Then Admin able to delete by clicking yes to confirmation pop up
    
     Scenario: Admin checks delete operation unsucces with single program delete
     Given  Admin clicks "Program" on the navigation bar in program module for delete and sort
    When Admin clicks on the delete icon on program module page
    Then Admin able to delete by clicking No to confirmation pop up
    
    Scenario: Admin validate delete by deleting multiple programs
    Given  Admin clicks "Program" on the navigation bar in program module for delete and sort
    When Admin clicks on the multiple checkboxes on program module page
    And Admin clicks  on the left delete button on program module page
    Then Admin able to delete multiple program by clicking yes to confirm
    
  #----------------------------------Search Program -----------------------------------------  
  
  Scenario: Verify Admin is able to search results found for program name
   Given  Admin is on Program page
    When Admin enter the program to search By program name
    Then Admin should able to see Program name, description, and status for searched program name
    
    Scenario: Verify Admin is able to search results found for program description
   Given  Admin is on Program page
    When Admin enter the program to search By program description
    Then Admin should able to see Program name, description, and status for searched program description
        
   Scenario: Verify Admin is able to search results not found
   Given  Admin is on Program page
    When Admin enter the program to search By program name that does not exist
    Then There should be zero results
    
     Scenario: Verify Admin is able to search with partial program name
   Given  Admin is on Program page
    When Admin enter the program to search By partial name of program
    Then Admin should able to see Program name, description, and status for searched program name
    
    
    #-------------------------Sort-------------------------------------
    
  Scenario: Verify sorting of Program name in Ascending order
   Given  Admin clicks "Program" on the navigation bar in program module for delete and sort
    When Admin clicks on Arrow next to program Name of Program module page for sort
    Then Admin See the Program Name is sorted Ascending order in Program module page for sort

  Scenario: Verify sorting of Program name in Descending order
   Given  Admin clicks "Program" on the navigation bar in program module for delete and sort
    When Admin clicks on Arrow next to program Name of Program module page for sort descend
    Then Admin See the Program Name is sorted Descending order in Program module page 

  Scenario: Verify sorting of Program description in Ascending order
   Given  Admin clicks "Program" on the navigation bar in program module for delete and sort
    When Admin clicks on Arrow next to program description of Program module page for sort 
    Then Admin See the Program description is sorted Ascending order in Program module page 
    
  Scenario: Verify sorting of Program description in Descending order
    Given  Admin clicks "Program" on the navigation bar in program module for delete and sort
    When Admin clicks on Arrow next to program description of Program module page for sort descend
    Then Admin See the Program description is sorted Descending order in Program module page

  Scenario: Verify sorting of Program status in Ascending order
    Given  Admin clicks "Program" on the navigation bar in program module for delete and sort
    When Admin clicks on Arrow next to program status of Program module page for sort
    Then Admin See the Program status is sorted Ascending order in Program module page

  Scenario: Verify sorting of Program status in Descending order
    Given  Admin clicks "Program" on the navigation bar in program module for delete and sort
    When Admin clicks on Arrow next to program status of Program module page for sor descend
     Then Admin See the Program status is sorted Descending order in Program module page
    
    #----------------------------pagination--------------------------------
    Scenario Outline: Validate pagination links for program page
    When Admin clicks the <pageLink> link on the data table in program page
    Then Admin should see the <pageLink> results on the data table in program module

  Examples:
      | pageLink   | results                  |
      | Next       | Next enabled link        |
      | Last       | last page link with Next disabled |
      | Previous   | previous page            |
      | First      | very first page          |
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
