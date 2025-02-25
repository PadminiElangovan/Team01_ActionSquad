@ClassExtra @LMS @Dash
Feature: Additional Class Functionality

 Background: Admin is signed into LMS
   Given Admin is on home page after Logs in

  @MngClassTitle
  Scenario: Verify Manage class page title
    When Admin clicks class on the navigation bar
    Then Admin should see Manage class page title

  @MenuBar
  Scenario: Verify menu bar is displayed
    When Admin clicks class on the navigation bar
    Then Admin should see menus

  @ClassNavigation
  Scenario Outline: Verify navigation from batch page
    Given Admin is on Manage Class page
    When Admin clicks "<MenuTxt>" menubar
    Then Admin is navigated to "<MenuTxt>" pages

    Examples:
      |  MenuTxt |
      | Home     |
      | Program  |
      | Class    |

  @ClassWarningSign
  Scenario Outline: Verify warning sign 
    Given Admin is on Manage Class page
    When Admin clicks on "<icon>" delete icon
    Then Admin should see warning sign in confirmation window

   Examples:
      | icon       |
      | Delete     |
      | DeleteAll  |
          
  @ClassNamDisplayed
  Scenario: Verify selected class name Delete message
    Given Admin is on Manage Class page
    When Admin clicks on delete icon for selected class entry
    Then Admin should see class name in the confirmation window
   