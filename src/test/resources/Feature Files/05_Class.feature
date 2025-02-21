@Classpage @LMS
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

# This can be scenario outline
Scenario: Check if class is created when only mandatory fields are entered with valid data
Given: 		admin is on the home Page
When: 		Admin enters mandatory fields in the form and clicks on save button
Then:  		Admin gets message Class added Successfully

Scenario: Check no classes value added when selecting class dates
Given: 		admin is on the home Page
When: 		Admin selects class date in date picker
Then:  		Admin should see no of class value is added automatically

Scenario: Check weekend dates are disabled in calendar
Given: 		Admin is on the Class Popup window
When: 		Admin clicks date picker
Then:  		Admin should see weekends dates are disabled to select





  
  