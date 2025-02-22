@ProgramExtra @LMS 
Feature: Additional Program Functionality

 Background: Admin is on the Dashboard page after login
   Given Admin is on home page after Login

  @SearchDiffCase
  Scenario: Verify program search text with different case
    Given Admin is on Manage Program page
    When Admin enter valid program search in different case
    Then Admin should see all program data for the search
   