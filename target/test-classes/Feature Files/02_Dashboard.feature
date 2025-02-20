@Dashboard @LMS 
Feature: Dashboard Functionality

  @PgTitle
  Scenario: Verify LMS title
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should see LMS -Learning management system as title
