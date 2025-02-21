@LoginExtra @LMS 
Feature: Additional Login Functionality

  @AllEmpty
  Scenario: Verify all field empty error message
    Given Admin is on login Page
    When The Admin clicks Login button
    Then Admin receives mandatory fields error message

 