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
  
      

     
   
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
