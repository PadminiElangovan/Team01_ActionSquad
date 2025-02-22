@ProgramExtra @LMS 
Feature: Additional Program Functionality

 Background: Admin is on the Dashboard page after login
   Given Admin is on home page after Login

  @MngPrgmTitle
  Scenario: Verify Manage Program page title
    When Admin clicks Program on the navigation bar
    Then Admin should see Manage Program page title
    
  @PrgNavigation
  Scenario Outline: Verify navigation from Program page
    Given Admin is on Manage Program page
    When Admin clicks "<MenuTxt>" menu
    Then Admin is navigated to "<MenuTxt>" page

    Examples:
      |  MenuTxt |
      | Home     |
      | Batch    |
      | Class    |
      | Logout   | 

  @SearchDiffCase
  Scenario: Verify program search text with different case
    Given Admin is on Manage Program page
    When Admin enter valid program search in different case
    Then Admin should see all program data for the search
   