@Logout @LMS
Feature: Logout Page
@logout
 Scenario: Verify logout function
    Given Admin is in home page
    When Admin clicks on the logout in the menu bar
    Then Admin should be redirected to login page 
@logoutbackbutton
  Scenario: Verify back button function
    Given Admin is in login page
    When Admin clicks browser back button
    Then Admin should receive error message for back button