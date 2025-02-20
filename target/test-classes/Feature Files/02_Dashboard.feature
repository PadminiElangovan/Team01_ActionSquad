@Dashboard @LMS 
Feature: Dashboard Functionality

  @Title
  Scenario: Verify LMS title
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see LMS -Learning management system as title

  @TitleAlign
  Scenario: Verify LMS title alignment
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then LMS title should be on the top left corner of page
    
  @MenuBarText
  Scenario: Validate navigation bar text
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see correct spelling in navigation bar text
    
  @TitleSpell
  Scenario: Validate LMS title has correct spelling and space
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see correct spelling and space in LMS title
    
  @MenuBarAlign
  Scenario: Validate alignment for navigation bar
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see the navigation bar text on the top right side
    
  @MenuOrder
  Scenario Outline: Validate navigation bar order
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see "<Menu>" in the "<Order>"

    Examples: 
      |  Menu    | Order |
      | Home     |   1   |
      | Program  |   2   |
      | Batch    |   3   |
      | Class    |   4   |
      | Logout   |   5   | 
      
  @PieChart
  Scenario: verify pie-chart presence
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see piechart
    
  @UsrDetail
  Scenario: Verify user details
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see welcome message with user name and role 
       
  @BarChart
  Scenario: Verify bar chart
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see bar chart for Active and inactive user
    
  @LMSCount
  Scenario Outline: Verify section count
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see "<Section>" count

    Examples: 

      |   Section  | 
      |   User     |
      |   Staff    |
      |   Batch    |
      |   Program  |
      
  @PaginationIcon
  Scenario: Verify staff table pagination
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see staff table with pagination icons
    
  @Staff5Data
  Scenario: Verify staff data page split
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see five staff data in a page
    
  @LMSCount
  Scenario Outline: verify page icon disable
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see "<PageArrow>" page icon disabled

    Examples: 

      |   PageArrow  | 
      |   Previous   |
      |   FirstPage  |  
      
    

