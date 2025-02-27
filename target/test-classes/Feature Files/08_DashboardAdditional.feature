@DashboardExtra @LMS @Dash
Feature: Additional Dashboard Functionality

 @LMSTitle
  Scenario: Verify LMS Dashboard page title
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see LMS Dashboard page title

  @HomeSection
  Scenario: Verify Dashboard Section
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see Dashboard section header

  @Welcome
  Scenario: Verify Welcome Text
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see Welcome text

  @ProfileIcon
  Scenario: Verify User profile icon
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see Profile icon

  @TextIcon
  Scenario Outline: Verify section text and icon
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see "<section>" text and icon

    Examples: 
      |  section |
      | User     |
      | Staff    |
      | Batches  |
      | Programs |

  @TableHeader
  Scenario: Verify Staff data table header
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see Staff Data header

  @ColumnHeader
  Scenario Outline: Verify Staff data table column
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see "<section>" column header

    Examples: 
      | section    |
      | UserID     |
      | First Name |
      | Last Name  |
      | Phone      |
      
  @Home2Home
  Scenario: Verify Home Link
    Given Admin is on home page after Login
    When Admin clicks Home menu
    Then Admin should remain in the home page

  @IconLink
  Scenario Outline: Verify page navigation with icon
    Given Admin is on home page after Login
    When Admin clicks "<module>" icon
    Then Admin should be in "<module>" page

    Examples: 
      |  module  |
      | User     |
      | Staff    |
      | Batches  |
      | Programs |
      
  @BatchCount
  Scenario: Validate batch count 
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see exact total count of active and inactive batch
  
  @PrgmCount
  Scenario: Validate program count
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see exact total count of active and inactive program
    
   @UsrCount
  Scenario: Validate user count
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see exact total count of active and inactive user