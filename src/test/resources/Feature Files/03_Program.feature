Feature: Manage Page Validation

 Background: Admin Is on the Dashboard page after login
  Given Admin is on login Page
  When Admin enter valid data in all field and clicks login button    

  Scenario: Validate headers in the program page
  When Admin clicks on Program 
  Then Admin should see all fields and headers on Manage Program page
  
   Scenario: Validating the text and pagination icon in the programpage
 When Admin clicks on Program 
 Then Admin should see footer and enabled pagination controls under the data table
  
 Scenario: Verify checkbox default state beside Program Name column header
 When Admin clicks on Program 
 Then Admin should see the checkbox default state

  Scenario: Validate the sort icon of all the field in datatable
  When Admin clicks on Program 
  Then Admin should see the Sort icon of all the field in the datatable.

  Scenario: Validating the Delete button under the Manage program
  When Admin clicks on Program 
  Then Admin should see the Delete button under the Manage program page header

  Scenario: Validate the total no of programs in manage program page
  When Admin clicks on Program 
  Then Admin should see Total no of programs in below of the data table
  
 #------------------------------------------Add New Program-----------------------------------------------
 
  Scenario Outline:  Validate Program Details Popup window
    
    When Admin clicks Add New Program under program navigation bar
    Then Admin should see the Program Details pop up window "<menu>"

    Examples: 
      | menu   |
      | Name   |
      | Description|
      | Status |
      |ProgramDetails|
      
    Scenario Outline: Empty form submission
    When Admin clicks on save button without entering data 
    Then Admin should see error message below the test field and the field will be highlighed in red color "<ProgramNameIsRequired>" "<DescriptionIsRequired>" "<StatusIsRequired>" 
     Examples: 
      | ProgramNameIsRequired       | DescriptionIsRequired  | StatusIsRequired    |
      | Program name is required | Description is required. | Status is required. |       
      
    Scenario Outline: Check if program is created 
    When Admin enters mandatory fields "<Name>" "<Description>" "<Status>" "<SuccessMsg>" in the form and clicks on save button
    Then Admin gets message Class added Successfully

    Examples: 
      | Name    || Description    || Status || SuccessMsg  |        
      |CSharp || okkkkjh        || Active || Successful  |     
      
     Scenario Outline: Verify added Program is created 
    When Admin searches with newly created "<Program Name>" 
    Then Records of the newly created "<Program name>" is displayed and match the data entered
    Examples:
    |Program Name|
    |CSha|
    
    Scenario: Validate Cancel/Close(X) icon on program Details form
    When Admin clicks Cancel Icon on program Details form
    Then Program Details popup window should be closed
    
 #------------------------------------Edit Program -----------------------------------------------
 
 Scenario Outline:  Validate Edit Program Details Popup window
    
    When Admin clicks Edit New Program under program navigation bar
    Then Admin should see the Program Details pop up window "<menu>"

    Examples: 
      | menu   |
      | Name   |
      | Description|
      | Status |
      |ProgramDetails|
 
 
  Scenario: Validate Edit icon feature
    When Admin should see the Program details pop-up window by clicking the edit icon for any program
    Then Admin should see the Program name field
    
    Scenario Outline: Check if the fields are updated with valid data
    When Update the fields with valid data "<Description>" and click save
    Then Admin gets message "Updated program Successfully" and see the updated values in data table

    Examples: 
      | Description |
      | Saps |
      
    Scenario: Validate Cancel button on Edit popup
    When Admin clicks Cancel Icon on program Details form
    Then Program Details popup window should be closed
    
     
  
    
    
# --------------------------------------------Delete-------------------------------------------------  

  Scenario: Validate single row delete with checkbox
    Given Admin is on the program page
    When Admin clicks on the delete icon under the Manage program header
    Then Admin should see the box is disabled
    
 Scenario: Validate single row delete with checkbox
    Given Admin is on the program page
    When Admin Should click the Enabled Delete icon on the datatable
    Then Admin should see the Delete confirmation popup box in program page
    
 Scenario: Validate single row delete with checkbox
    Given Admin is on the program page
    When Admin clicks on the yes button on popup
    Then The respective row in the table should be deleted on program page

  Scenario: Validate multiple row delete with checkbox
    Given Admin is on the program page
    When Admin clicks on the delete icon under the Manage program header multiple delete
    Then The respective row in the table should be deleted in program module
    
    
    
 #-----------------------------------------------------Search-----------------------------------------------
 
 
 Scenario Outline: Search Program by Program Name
 Given Admin is on the program page
When Admin enter the "<field>" "<value>" in search textbox
Then Admin should see Program details are searched by given fields
Examples: 
|field||value|
|Name||usa|
|Description||india|

 
 Scenario: Verify Admin is able to search results not found
 Given Admin is on the program page
 When Admin enter the program to search By program name that does not exist
 Then There should be zero results.
 
 Scenario: Verify Admin is able to search with partial program name
 Given Admin is on the program page
 When Admin enter the program to search By partial name of program
 Then Admin should able to see Program name, description, and status for searched program name
 
    
    
    
#----------------------------------- Pagination -----------------------------------------------------------

  Scenario Outline: Validate pagination links
   When Admin clicks the <pageLink> link on the data table
   Then Admin should see the <pageLink> results on the data table

  Examples:
     | pageLink   | results         |
     | Next       |Next enabled link|
     | Last       |last page link with Next disabled|
     | Previous   |previous page|
     | First      |very first page|
     
   
    
    

    
    
   
  
