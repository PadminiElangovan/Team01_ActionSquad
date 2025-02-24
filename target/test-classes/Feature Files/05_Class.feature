@Classpage @LMS
Feature: Class page validation

Background: Admin Is on the Dashboard page after login
  Given Admin is on login Page
  When Admin enter valid data in all field and clicks login button 

 
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




Scenario: Verify Next page link(>)
Given 		Admin is on the Manage Class page
When 		Admin clicks Next page link on the class table 
Then  		Admin should see the next page record on the table with Pagination has next active link enabled

Scenario: Verify Last page link(>>)
Given 		Admin is on the Manage Class page
When 		Admin clicks Last page link
Then  		Admin should see the last page record on the table with Next page link are disabled

Scenario: Verify First page link(<)
Given 		Admin is on last page of class table
When 		Admin clicks First page link
Then  		Admin should see the previous page record on the table with pagination has previous page link enabled

Scenario: Verify Start page link(<<)
Given 		Admin is on Previous class page 
When 		Admin clicks Start page link
Then  		Admin should see the very first page record on the table with Previous page link are disabled




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




  
  