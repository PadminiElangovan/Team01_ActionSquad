@Classpage @LMSs
Feature: Class page validation

Background: Admin Is on the Dashboard page after login
  Given Admin is on login Page
  When Admin enter valid data in all field and clicks login button 

 
 @ValManage
  Scenario: validating the class manage page
    
    When admin clicks the Class Navigation bar in the Header
    Then land on the Manage class page

  @ValTitle
  Scenario: Validating the Title in the Manage class page
  When admin clicks the Class Navigation bar in the Header
    Then see the LMS-Learning Management System Title

  @ValHeader
  Scenario: Validating the Header in the Manage class page
  When admin clicks the Class Navigation bar in the Header
    Then see the Manage Class Header

  @ValSearch
  Scenario: Validating Search bar in class page
  When admin clicks the Class Navigation bar in the Header
    Then Admin should see the Search Bar in Manage class page

  @ValTableHeader
  Scenario Outline: Validating the headers in the class page
  When admin clicks the Class Navigation bar in the Header
    Then Admin should see the headers heading like "<headers>"

    Examples: 
      | headers                          |
      | BatchName                        |
      | ClassTopic                       |
      | ClassDescription                 |
      | Status                           |
      | ClassDate                        |
      | StaffName                        |
      | Edit/Del                         |

  @ValDelete
  Scenario: Validating the Delete button under the Manage class
  When admin clicks the Class Navigation bar in the Header
    Then see the Delete button under the Manage class page header.

  @valNoClasses
  Scenario: Validate the total no of classes in manage class page
  When admin clicks the Class Navigation bar in the Header
    Then see Total no of classes in below of the data table

  @ValPageControls
  Scenario: Validating the text and pagination icon in the classpage
  When admin clicks the Class Navigation bar in the Header
    Then see the pagination controls under the data table

  @ValSortIcon
  Scenario: Validate the sort icon of all the field in datatable
  When admin clicks the Class Navigation bar in the Header
    Then see the Sort icon of all the field in the datatable.
    
    
  #Add New Class

 Scenario Outline:  Validate Class Details Popup window
    
    When Admin clicks Add New Class under class navigation bar
    Then Admin should see the Class Details pop up window "<menu>"

    Examples: 
      | menu                      |
      | Title                     |
      | BatchName                 |
      | ClassTopic                |
      | ClassDescription          |
      | ClassDate                 |
      | NoOfClasses               |
      | StaffName               	|
      | Status             				|
      | Comments                  |
      | Notes                    	|
      | Recording                 |
      | Save                      |
      | Cancel                    |

 
#Add New Class POP UP


Scenario Outline: Check if class is created when only mandatory fields are entered with valid data
When Admin clicks Add New Class under class navigation bar
And 		Admin enters mandatory fields from SheetName and <RowNo> and clicks on save button
Then  	Admin gets message Class added Successfully
Examples:
 |RowNo|
 |0|


 
#Edit Class

Scenario: Validate row level edit icon
Given 		Admin is on the Manage Class page
When 			Admin clicks on the edit icon
Then  		A new pop up with class details appears

Scenario: Check disabled batch name
Given 		Admin is on the Manage Class page
When 		Admin clicks on the edit icon
Then  		Admin should see batch name field is disabled

Scenario: Check disabled class topic
Given 		Admin is on the Manage Class page
When 		Admin clicks on the edit icon
Then  		Admin should see class topic field is disabled
 

Scenario Outline: Check if the fields are updated with valid data
    Given Admin is on the Edit Class Popup window
    When Update Edit Class fields with valid data "<Class>" and click save
    Then Admin gets message Successful and see the updated class values in data table

    Examples: 
      | Class |
      | Java  |
      
      
Scenario Outline: Check if the fields are updated with invalid values
Given 		Admin is on the Edit Class Popup window
When 			Update the fields with invalid value "<Class>" and click save
Then  		Admin should get Error message
Examples: 
      | Class |
      | 2323232  |
      
Scenario: Validate Cancel button on Edit popup
    Given Admin is on the Edit Class Popup window
    When Admin clicks Cancel button on edit popup
    Then Admin can see the class details popup disappears and can see nothing changed for particular Class

#Cancel 

Scenario: Validate Cancel button on AddNew popup
    Given Admin clicks Add New Class under class navigation bar
    When Admin clicks Cancel button on AddNew popup
    Then Admin can see the class details popup disappears and can see nothing changed for particular Class
    
    Scenario: Validate cross button on AddNew popup
    Given Admin clicks Add New Class under class navigation bar
    When Admin clicks cross button on AddNew popup
    Then Admin can see the class details popup disappears and can see nothing changed for particular Class
    

       
Scenario: Validate Cancel button on Edit popup
    Given Admin is on the Edit Class Popup window
    When Admin clicks Cancel button on edit popup
    Then Admin can see the class details popup disappears and can see nothing changed for particular Class
    
   
Scenario: Validate cross button on Edit popup
    Given Admin is on the Edit Class Popup window
    When Admin clicks cross button on edit popup
    Then Admin can see the class details popup disappears and can see nothing changed for particular Class
    


#Search

Scenario: Search class by Batch Name
Given 		Admin is on the Manage Class page
When      Admin enter the BatchName in search textbox and Enter
Then  		Admin should see Class details are searched by Batch Name


Scenario: Search class by Class topic
Given 		Admin is on the Manage Class page
When 		Admin enter the Class topic in search textbox and Enter
Then  		Admin should see Class details are searched by Class topic

Scenario: Search class by Staff Name
Given 		Admin is on the Manage Class page
When 		Admin enter the Staff Name in search textbox and Enter
Then  		Admin should see Class details are searched by Staff name

#Delete

Scenario: Validate multiple class deletion by selecting Single checkbox
Given     Admin is on the Manage Class page
And 			Admin is on Confirm Deletion alert
When      Admin clicks YES button on the alert
Then  		Admin should land on Manage class page and can see the selected class is deleted from the data table


Scenario: Validate multiple class deletion by selecting Single checkbox
Given     Admin is on the Manage Class page
And 			Admin is on Confirm Deletion alert
When      Admin clicks No button on the alert 		
Then  		Admin should land on Manage class page and can see the selected class is not deleted from the data table

Scenario: Validate multiple class deletion by selecting multiple check boxes
Given     Admin is on the Manage Class page
And 		Admin is on Confirm Deletion alert
When 			 Admin clicks YES button on the alert
Then  		Admin should land on Manage class page and can see the selected class is deleted from the data table

Scenario: Validate multiple class deletion by selecting multiple check boxes
Given     Admin is on the Manage Class page
And 		Admin is on Confirm Deletion alert
When      Admin clicks No button on the alert
Then  		Admin should land on Manage class page and can see the selected class is not deleted from the data table



#Sort Class Details

Scenario: Verify sorting of Batch name in Ascending order
		Given Admin is on the Manage Class page
    When Admin clicks on Arrow next to Batch Name of Class module page for sort
    Then Admin See the Batch Name is sorted Ascending order in Class module page for sort

 
  Scenario: Verify sorting of Batch name in Descending order
  Given Admin is on the Manage Class page
    When Admin clicks on Arrow next to Batch Name of Class module page for sort descend
    Then Admin See the Batch Name is sorted Descending order in Class module page 

 
  Scenario: Verify sorting of Class Topic in Ascending order
  Given Admin is on the Manage Class page
    When Admin clicks on Arrow next to Class Topic of Class module page for sort 
    Then Admin See the Class Topic is sorted Ascending order in Class module page 

  
  Scenario: Verify sorting of Class Topic in Descending order
  Given Admin is on the Manage Class page
    When Admin clicks on Arrow next to Class Topic of Class module page for sort descend
    Then Admin See the Class Topic is sorted Descending order in Class module page

  
  Scenario: Verify sorting of Class Description in Ascending order
  Given Admin is on the Manage Class page
    When Admin clicks on Arrow next to Class Description of Class module page for sort
    Then Admin See the Class Description is sorted Ascending order in Class module page

  
  Scenario: Verify sorting of Class Description in Descending order
  Given Admin is on the Manage Class page
    When Admin clicks on Arrow next to Class Description of Class module page for sor descend
    Then Admin See the Class Description is sorted Descending order in Class module page
  
  
  Scenario: Verify sorting of Status in Ascending order
  Given Admin is on the Manage Class page
    When Admin clicks on Arrow next to Status of Class module page for sort
    Then Admin See the Status is sorted Ascending order in Class module page

  
  Scenario: Verify sorting of Status in Descending order
  Given Admin is on the Manage Class page
    When Admin clicks on Arrow next to Status of Class module page for sor descend
    Then Admin See the Status is sorted Descending order in Class module page
  
  Scenario: Verify sorting of ClassDate in Ascending order
  Given Admin is on the Manage Class page
    When Admin clicks on Arrow next to ClassDate of Class module page for sort
    Then Admin See the ClassDate is sorted Ascending order in Class module page

	Scenario: Verify sorting of ClassDate in Descending order
  Given Admin is on the Manage Class page
    When Admin clicks on Arrow next to ClassDate of Class module page for sor descend
    Then Admin See the ClassDate is sorted Descending order in Class module page
  
  
  Scenario: Verify sorting of StaffName in Descending order
  Given Admin is on the Manage Class page
    When Admin clicks on Arrow next to StaffName of Class module page for sor descend
    Then Admin See the StaffName is sorted Descending order in Class module page
  
  
Scenario: Verify sorting of StaffName in Ascending order
  Given Admin is on the Manage Class page
    When Admin clicks on Arrow next to StaffName of Class module page for sort
    Then Admin See the StaffName is sorted Ascending order in Class module page


  #Pagination

 Scenario Outline: Validate pagination links for Class page
 		Given  Admin is on the Manage Class page
    When Admin clicks the "<pageLink>" link on the data table in class page
    Then Admin should see the "<results>" on the data table in class module

  Examples:
      | pageLink   | results                  |
      | Next       | Next enabled link        |
      | Last       | last page link with Next disabled |
      | Previous   | previous page            |
      | First      | very first page          |
   
 





