@ProgramExtra @LMS @Dash
Feature: Additional Program Functionality

 Background: Admin is on the Dashboard page after login
   Given Admin is on home page after Logs in

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

  @AddMandatoryMsg
  Scenario Outline: Verify field mandatory message
    Given The Admin is in Add New program pop window
    When Admin leaves "<field>" empty and clicks save
    Then Admin receives "<field>" mandatory error message

   Examples:
      | field       |
      | Name        |
      | Description |
      | Status      |

  @AddInvalidMsg
  Scenario Outline: Verify field invalid message
    Given The Admin is in Add New program pop window
    When Admin enters invalid "<field>" and clicks save
    Then Admin receives "<field>" invalid error message
   Examples:
      | field              |
      | NameSpcChar        |
      | NameStarts-SpcChar |
      | NameStarts-No      |
      | NamelessChar       |
      | DescStarts-No      |
      | DesclessChar       |

    @EditMandatoryMsg
  Scenario Outline: Verify field mandatory message
    Given The Admin is in Edit program pop window
    When Admin clears "<field>" and clicks save
    Then Admin receives "<field>" edit mandatory error message

   Examples:
      | field       |
      | Name        |
      | Description |

 @EditInvalidMsg
  Scenario Outline: Verify field invalid message
    Given The Admin is in Edit program pop window
    When Admin enters invalid "<field>" and clicks save
    Then Admin receives "<field>" invalid error message
   Examples:
 
      | field              |
      | NameSpcChar        |
      | NameStarts-SpcChar |
      | NameStarts-No      |
      | NamelessChar       |
      | DescStarts-No      |
      | DesclessChar       |

  @WarningSign
  Scenario Outline: Verify warning sign 
    Given Admin is on Manage Program page
    When Admin clicks on "<icon>" delete icon
    Then Admin should see warning sign in confirmation window

   Examples:
 
      | icon       |
      | Delete     |
      | DeleteAll  |


@PrgmNamDisplayed
  Scenario: Verify selected program name Delete message
    Given Admin is on Manage Program page
    When Admin clicks on delete icon for selected program entry
    Then Admin should see program name in the confirmation window
