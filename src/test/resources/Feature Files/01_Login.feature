@Loginpage @LMS
Feature: Login page validation

  Background:
    Given Admin launch the browser and Admin is in login Page

  @Logincredentials
  Scenario Outline: Validate login with valid and invalid credentials
    When Admin enter valid "<credentials>"  and selects "Admin" from the dropdown  
  And clicks the login button  
    Then Admin should see the "<result>"
    Examples:
    | credentials              | result                  |
    | valid credentials        | Admin should land on dashboard page             |
    |invalid credentials        | Invalid username and password Please try again |
    | onlypassword                 | Please enter your user name |
    | onlyusername                 | Please enter your password  |
    
    @keyboardLogin
 Scenario: verify login button action through keyboard
   When Admin enter valid credentials  and clicks login button through keyboard
   Then Admin should land on dashboard page

  @mouseLogin
 Scenario: verify login button action through mouse
   When Admin enter valid credentials  and clicks login button through mouse
   Then Admin should land on dashboard page

    @spellcheck
  Scenario: Verify the text spelling in the page
    Then Admin should see correct spellings in all fields

@LogoValidate
  Scenario: Verify the company logo
    Then Admin should see logo on the left  side

  @AppNameValidate
  Scenario:Verify application name
    Then Admin should see  LMS - Learning Management System

  @CompanyNameValidate
  Scenario: Verify company name
    Then Admin should see company name below the app name

  @LoginLMSContent
  Scenario: Validate sign in content
    Then Admin should see "Please login to LMS application"

  @CountTextField
  Scenario: Verify text field is present
    Then Admin should see two text field

    @UserFirst
  Scenario: Verify text on the first text field
    Then Admin should "User" in the first text field

    @asteriskUser
  Scenario: Verify asterisk next to Admin text
    Then Admin should see field mandatory asterisk symbol next to Admin text

  @PasswordSecond
  Scenario: Verify text on the second text field
    Then Admin should "Password" in the second text field
    
    @Dropdown
    Scenario: Verify dropdown is present
  Then Admin should see one dropdown
  
    Scenario: Verify placeholder in dropdown to select role
    
    Then Admin should see "select the role" placeholder in the dropdown

  Scenario: Verify dropdown option to select role
    
    Then Admin should see "Admin, Staff, Student" options in the dropdown

  
    @asteriskPassword
  Scenario: Verify asterisk next to password text
    Then Admin should see * symbol next to password text

  Scenario: Verify the alignment input field for the login
    Then Admin should see input field on the centre of the page

    @loginButtonAvailable
  Scenario: verify Login button is present
    Then Admin should see login button

  Scenario: Verify the alignment of the login button
    Then Admin should see login button on the centre of the page

    @userColor
  Scenario:Verify input descriptive test in Admin field
    Then Admin should see Admin in gray color

  @passwordColor
  Scenario: Verify input descriptive test in password field
    Then Admin should see password in gray color