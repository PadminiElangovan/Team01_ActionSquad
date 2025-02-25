@BatchExtra @LMS @Dash
Feature: Additional Batch Functionality

 Background: Admin is on the Batch page after login
   Given Admin is on home page after Logs in

  @MngBatchTitle
  Scenario: Verify Manage batch page title
    When Admin clicks Batch on the navigation bar
    Then Admin should see Manage batch page title

  @SearchBox
  Scenario: Verify batch search is displayed
    When Admin clicks Batch on the navigation bar
    Then Admin should see search box

  @Footer
  Scenario: Verify batch footer is displayed
    When Admin clicks Batch on the navigation bar
    Then Admin should see footer message

  @MenuBar
  Scenario: Verify menu bar is displayed
    When Admin clicks Batch on the navigation bar
    Then Admin should see menus

  @BatchNavigation
  Scenario Outline: Verify navigation from batch page
    Given Admin is on Manage Batch page
    When Admin clicks "<MenuTxt>" menubar
    Then Admin is navigated to "<MenuTxt>" pages

    Examples:
      |  MenuTxt |
      | Home     |
      | Program  |
      | Class    |

  @BatchWarningSign
  Scenario Outline: Verify warning sign 
    Given Admin is on Manage Batch page
    When Admin clicks on "<icon>" delete icon
    Then Admin should see warning sign in confirmation window

   Examples:
      | icon       |
      | Delete     |
      | DeleteAll  |
      
      
  @BatchNamDisplayed
  Scenario: Verify selected batch name Delete message
    Given Admin is on Manage Batch page
    When Admin clicks on delete icon for selected batch entry
    Then Admin should see batch name in the confirmation window
    
  @EmptyErrBatch
  Scenario: Verify all field empty error message
    Given The Admin is in Add New batch pop window
    When Admin clicks save button
    Then Admin should see error messages 
    
  @DescEmptyBatch
  Scenario: Verify desc mandatory error message
    Given The Admin is in Edit New batch pop window
    When Admin clears Description and clicks save
    Then Admin should description mandatory error message

  @AddInvalidMsgBatch
  Scenario Outline: Verify field invalid message
    Given The Admin is in Add New batch pop window
    When Admin enters invalid "<field>" data and clicks save
    Then Admin receives "<field>" invalid error messages
   Examples:
      | field              |
      | DescSpcChar        |
      | DescStarts-No      |
      | DesclessChar       |
   