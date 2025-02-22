Feature: Manage Page Validation

 Background: Admin Is on the Dashboard page after login
  Given Admin is on login Page
  When Admin enter valid data in all field and clicks login button    

  #Scenario: Validate headers in the program page
  #When Admin clicks on Program 
  #Then Admin should see all fields and headers on Manage Program page
  #
   #Scenario: Validating the text and pagination icon in the programpage
 #When Admin clicks on Program 
 #Then Admin should see footer and enabled pagination controls under the data table
  #
 #Scenario: Verify checkbox default state beside Program Name column header
 #When Admin clicks on Program 
 #Then Admin should see the checkbox default state
#
  #Scenario: Validate the sort icon of all the field in datatable
  #When Admin clicks on Program 
  #Then Admin should see the Sort icon of all the field in the datatable.
#
  #Scenario: Validating the Delete button under the Manage program
  #When Admin clicks on Program 
  #Then Admin should see the Delete button under the Manage program page header
#
  #Scenario: Validate the total no of programs in manage program page
  #When Admin clicks on Program 
  #Then Admin should see Total no of programs in below of the data table
  
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
      #
    #Scenario Outline: Empty form submission
    #When Admin clicks on save button without entering data 
    #Then Admin should see error message below the test field and the field will be highlighed in red color "<ProgramNameIsRequired>" "<DescriptionIsRequired>" "<StatusIsRequired>" 
     #Examples: 
      #| ProgramNameIsRequired       | DescriptionIsRequired  | StatusIsRequired    |
      #| Program name is required | Description is required. | Status is required. |       
      #
    #Scenario Outline: Check if program is created 
    #When Admin enters mandatory fields "<Name>" "<Description>" "<Status>" "<SuccessMsg>" in the form and clicks on save button
    #Then Admin gets message Class added Successfully
#
    #Examples: 
      #| Name    || Description    || Status || SuccessMsg  |        
      #|TestLNGL || okkkkjh        || Active || Successful  |     
      #
     #Scenario Outline: Verify added Program is created 
    #When Admin searches with newly created "<Program Name>" 
    #Then Records of the newly created "<Program name>" is displayed and match the data entered
    #Examples:
    #|Program Name|
    #|TestLNGL|
    #
    #Scenario: Validate Cancel/Close(X) icon on program Details form
    #When Admin clicks Cancel Icon on program Details form
    #Then Program Details popup window should be closed
#----------------------------------- Pagination -----------------------------------------------------------
#
  #Scenario Outline: Validate pagination links
   #When Admin clicks the <pageLink> link on the data table
   #Then Admin should see the <pageLink> results on the data table
#
  #Examples:
     #| pageLink   | results         |
     #| Next       |Next enabled link|
     #| Last       |last page link with Next disabled|
     #| Previous   |previous page|
     #| First      |very first page|
     #
   
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
   