@Loginpage @LMS

 Feature: Login page validation
  
  @Loginpage
  Scenario: Verify Admin is able to land on login page
    When Admin gives the correct LMS portal URL
    Then Admin should land on the login page

  @Invalidurl
  Scenario: Verify Admin is not able to land on home page with invalid URL
    When Admin gives the invalid LMS portal URL
    Then Admin should receive application error
    
  @BrokenLink
  Scenario: Verify for broken link
    When Admin gives the correct LMS portal URL
    Then If HTTP response less than or equals 400 then the link is broken
    
  @FieldSpelling
  Scenario: Verify the text spelling in the page
    When Admin gives the correct LMS portal URL
    Then Admin should see correct spellings in all fields
    
  @AppName
  Scenario: Verify application name
    When Admin gives the correct LMS portal URL
    Then Admin should see LMS - Learning Management System
    
  @CompanyName
  Scenario: Verify company name
    When Admin gives the correct LMS portal URL
    Then Admin should see company name below the app name
    
  @SignInContent
  Scenario: Validate sign-in content
    When Admin gives the correct LMS portal URL
    Then Admin should see Please login to LMS application
    
  @2InputField
  Scenario: Verify text field is present
    When Admin gives the correct LMS portal URL
    Then Admin should see two text fields
    
  @UsrField1st
  Scenario: Verify text on the first field
    When Admin gives the correct LMS portal URL
    Then Admin should see User in the first text field
    
  @PswdFeild2nd
  Scenario: Verify text on the second field
    When Admin gives the correct LMS portal URL
    Then Admin should see Password in the second text field 
    
  @AstrickSignPswd
  Scenario: Verify asterisk mark symbol next to Password text
    When Admin gives the correct LMS portal URL
    Then Admin should see asterisk mark symbol next to password text
   
  @AstrickSignUser
  Scenario: Verify asterisk next to USER text
    When Admin gives the correct LMS portal URL
    Then Admin should see asterisk mark symbol next to text for mandatory fields 
    
  @Dropdown
  Scenario: Verify dropdown is present
    When Admin gives the correct LMS portal URL
    Then Admin should see one dropdown
    
  @RoleLable
  Scenario: Verify placeholder in dropdown to select role
    When Admin gives the correct LMS portal URL
    Then Admin should see Select the role placeholder in dropdown 
    
  @DropdownOption
  Scenario: Verify dropdown option to select role
  	Given Admin is on login page
    When Admin click role dropdown
    Then Admin should see Admin Staff Student options in dropdown 
       
  @AlignInput
  Scenario: Verify the alignment of input field for the login
    When Admin gives the correct LMS portal URL
    Then Admin should see input field in the center of the page

  @LoginButton
  Scenario: Verify Login button is present
    When Admin gives the correct LMS portal URL
    Then Admin should see login button

  @UserFont
  Scenario: Verify input descriptive text in user field
    When Admin gives the correct LMS portal URL
    Then Admin should see User in gray color

  @PswdFont
  Scenario: Verify input descriptive text in password field
    When Admin gives the correct LMS portal URL
    Then Admin should see Password in gray color

	@LoginScn
  Scenario Outline: Validate login functionality
    Given Admin is on login page
    When Admin enters  "<Credentials>" and clicks login button
    Then Admin should "<Credentials>"

    Examples:
      | Credentials    | Expected_result                       |
      | valid          | land on home page                     |
      | invalid        | Invalid username and password    		 |
      | Emptyusername  | Please enter your user name           |
      | Emptypassword  | Please enter your password            |

  @LoginKeys
  Scenario: Verify login button action through keyboard
    Given Admin is on login page
    When Admin enters valid credentials and presses Enter key
    Then Admin should land on home page
    
  @LoginAction
  Scenario: Verify login button action through mouse
    Given Admin is on login page
    When Admin enters valid credentials and clicks login button through mouse
    Then Admin should land on home page

