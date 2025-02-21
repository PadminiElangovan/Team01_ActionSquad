@LoginExtra @LMS 
Feature: Additional Login Functionality

  @AllEmpty
  Scenario: Verify all field empty error message
    Given Admin is on login Page
    When The Admin clicks Login button
    Then Admin receives mandatory fields error message

  @RoleEmpty
  Scenario: Verify Admin role mandatory error
    Given Admin is on login Page
    When Admin enter valid credentials with role unselected and clicks login
    Then Admin should see Please select your Role error message
    
  @PswdMasked
  Scenario: Verify Password masking
    Given Admin is on login Page
    When Admin enters password in password field
    Then Admin should see masked password
    
  @Admin2StaffRole
  Scenario: Verify admin selects staff role
    Given Admin is on login Page
    When Admin enter valid credentials with staff role selection and clicks login
    Then Admin should not be navigated to LMS portal
  
  @Admin2StudentRole
  Scenario: Verify admin selects staff role
    Given Admin is on login Page
    When Admin enter valid credentials with student role selection and clicks login
    Then Admin should not be navigated to LMS portal  
    
 	@LoginPgTitle
  Scenario: Verify LMS Login page title
    When Admin gives the correct LMS portal URL
    Then Admin should see LMS Login page title 
    
  @ForgotPswdLink
  Scenario: Verify Forgot Password Link
    When Admin gives the correct LMS portal URL
    Then Admin should see Forgot Password Link