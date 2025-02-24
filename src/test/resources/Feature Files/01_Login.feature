@Loginpage @LMS
Feature: Login page validation

Background: 
Given The browser is open
@loginpage
  Scenario: Verify Admin is able to land on login page
    When Admin gives the correct LMS portal URL
    Then Admin should land on the login page
@invalidurl
  Scenario: Verify Admin is able to land on home page with invalid URL
    When Admin gives the invalid LMS portal URL
    Then Admin should receive application error
@brokennlink
  Scenario: Verify for broken link
    When Admin gives the correct LMS portal URL
    Then If HTTP response less than or equals 400 then the link is broken
    
@textspelling
  Scenario: Verify the text spelling in the page
    When Admin gives the correct LMS portal URL
    Then Admin should see correct spellings in all fields
@applicationname
  Scenario: Verify application name
    When Admin gives the correct LMS portal URL
    Then Admin should see LMS - Learning Management System
@companyname
  Scenario: Verify company name
    When Admin gives the correct LMS portal URL
    Then Admin should see company name below the app name
@companylogo
  Scenario: Validate sign-in content
    When Admin gives the correct LMS portal URL
    Then Admin should see Please login to LMS application
@textfield
  Scenario: Verify text field is present
    When Admin gives the correct LMS portal URL
    Then Admin should see two text fields
@firstfield
  Scenario: Verify text on the first field
    When Admin gives the correct LMS portal URL
    Then Admin should see User in the first text field

  @dropdown
  Scenario: Verify dropdown is present
    When Admin gives the correct LMS portal URL
    Then Admin should see one dropdown
@asteriskusr
  Scenario: Verify asterisk next to USER text
    When Admin gives the correct LMS portal URL
    Then Admin should see asterisk mark symbol next to text for mandatory fields
@secondfieldtext
  Scenario: Verify text on the second field
    When Admin gives the correct LMS portal URL
    Then Admin should see Password in the second text field
@astrikmarkpswrd
  Scenario: Verify asterisk mark symbol next to password text
    When Admin gives the correct LMS portal URL
    Then Admin should see asterisk mark symbol next to password text
@placeholder
  Scenario: Verify placeholder in dropdown to select role
    When Admin gives the correct LMS portal URL
    Then Admin should see Select the role placeholder in dropdown

  @dropdownoption
  Scenario: Verify dropdown option to select role
    When Admin gives the correct LMS portal URL
    Then Admin should see Admin Staff Student options in dropdown
@alignmentofinput
  Scenario: Verify the alignment of input field for the login
    When Admin gives the correct LMS portal URL
    Then Admin should see input field in the center of the page
@loginbutton
  Scenario: Verify Login button is present
    When Admin gives the correct LMS portal URL
    Then Admin should see login button
@usercolor
  Scenario: Verify input descriptive text in user field
    When Admin gives the correct LMS portal URL
    Then Admin should see User in gray color
@paswrdcolor
  Scenario: Verify input descriptive text in password field
    When Admin gives the correct LMS portal URL
    Then Admin should see Password in gray color
@loginfunctionality
  Scenario Outline: Validate login functionality
    Given Admin is on login page
    When Admin enters  "<credentials>" and clicks login button
    Then Admin should "<expected_result>"

    Examples:
      | credentials    | expected_result                               |
      | valid          | land on home page                             |
      | invalid        | Invalid username and password Please try again|
      | invalidusername| Please enter your user name                   |
      | invalidpassword| Please enter your password                    |
@loginbtnkeybord
  Scenario: Verify login button action through keyboard
    Given Admin is on login page
    When Admin enters valid credentials and presses Enter key
    Then Admin should land on home page
@loginbtnmouse
  Scenario: Verify login button action through mouse
    Given Admin is on login page
    When Admin enters valid credentials and clicks login button through mouse
    Then Admin should land on home page login action through mouse