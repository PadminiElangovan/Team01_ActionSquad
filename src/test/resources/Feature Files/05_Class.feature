@Classpage @LMS
Feature: Class page validation

Background: Admin Is on the Dashboard page after login
  Given Admin is on login Page
  When Admin enter valid data in all field and clicks login button 






Scenario: Validate logout option in the header is visible and enabled from the Class page   
    When Admin from class clicks on the program button
    Then Admin should see the Program screen Page
    
Scenario: Validate logout option in the header is visible and enabled from the Class page   
    When Admin from class clicks on the Home button
    Then Admin should see the Batch screen Page






