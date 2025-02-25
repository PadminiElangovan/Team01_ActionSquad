@Programpage @LMS
Feature: Manage Page Validation

  Background: Admin Is on the Dashboard page after login
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button

  @ValHeaders
  Scenario: Validate headers in the program page
    When Admin clicks on Program
    Then Admin should see all fields and headers on Manage Program page

  @ValPaginationIcons
  Scenario: Validating the text and pagination icon in the programpage
    When Admin clicks on Program
    Then Admin should see footer and enabled pagination controls under the data table

  @ValCheckboxs
  Scenario: Verify checkbox default state beside Program Name column header
    When Admin clicks on Program
    Then Admin should see the checkbox default state

  @ValSortIcon
  Scenario: Validate the sort icon of all the field in datatable
    When Admin clicks on Program
    Then Admin should see the Sort icon of all the field in the datatable.

  @ValSearchBox
  Scenario: Validating the Search box on the Manage program
    When Admin clicks on Program
    Then Admin should see the Search box on the Manage program page header

  @ValMultipleDeleteBtn
  Scenario: Validating the Delete button under the Manage program
    When Admin clicks on Program
    Then Admin should see the Delete button under the Manage program page header

  @VerifyCheckboxesDefaultState
  Scenario: Verify checkboxes default state beside each Program names in the data table
    When Admin clicks "Program" on the navigation bar in program module
    Then Admin should see check box default state as unchecked on the left side in all rows against program name

  @ValTotalPrograms
  Scenario: Validate the total no of programs in manage program page
    When Admin clicks on Program
    Then Admin should see Total no of programs in below of the data table

  #------------------------------------------Add New Program-----------------------------------------------
  @ValAddNewProgramPopupHeaders
  Scenario Outline: Validate Program Details Popup window
    When Admin clicks Add New Program under program navigation bar
    Then Admin should see the Program Details pop up window "<menu>"

    Examples: 
      | menu           |
      | Name           |
      | Description    |
      | Status         |
      | ProgramDetails |

  @ValEmptySubmission
  Scenario Outline: Empty form submission
    When Admin clicks on save button without entering data
    Then Admin should see error message below the test field and the field will be highlighed in red color "<ProgramNameIsRequired>" "<DescriptionIsRequired>" "<StatusIsRequired>"

    Examples: 
      | ProgramNameIsRequired    | DescriptionIsRequired    | StatusIsRequired    |
      | Program name is required | Description is required. | Status is required. |

  @NewProgramCreated
  Scenario Outline: Check if program is created
    When Admin enters mandatory fields "<Name>" "<Description>" "<Status>" "<SuccessMsg>" in the form and clicks on save button
    Then Admin gets message Class added Successfully

    Examples: 
      | Name  |  | Description |  | Status |  | SuccessMsg |
      | Dooro |  | Open        |  | Active |  | Successful |

  @VerifyProgramCreated
  Scenario Outline: Verify added Program is created
    When Admin searches with newly created "<Program Name>"
    Then Records of the newly created "<Program Name>" is displayed and match the data entered

    Examples: 
      | Program Name |
      | Doori        |

  @ValCancelBtn
  Scenario: Validate Cancel/Close(X) icon on program Details form
    When Admin clicks Cancel Icon on program Details form
    Then Program Details popup window should be closed

  #------------------------------------Edit Program -----------------------------------------------
  @ValEditProgramPopupHeaders
  Scenario Outline: Validate Edit Program Details Popup window
    When Admin clicks Edit New Program under program navigation bar
    Then Admin should see the Program Details pop up window "<menu>"

    Examples: 
      | menu           |
      | Name           |
      | Description    |
      | Status         |
      | ProgramDetails |

  @ValEditicon
  Scenario: Validate Edit icon feature
    When Admin should see the Program details pop-up window by clicking the edit icon for any program
    Then Admin should see the Program name field

  @ValProgramUpdated
  Scenario Outline: Check if the fields are updated with valid data
    When Update the fields with valid data "<Description>" and click save
    Then Admin gets message "Updated program Successfully" and see the updated values in data table

    Examples: 
      | Description |
      | Saps        |

  @ValCancelBtn
  Scenario: Validate Cancel button on Edit popup
    When Admin clicks Cancel Icon on program Details form
    Then Program Details popup window should be closed

  #--------------------------------------------Delete-------------------------------------------------
  @ValSingleRowDeletionBtn
  Scenario: Validate single row delete with checkbox
    Given Admin is on the program page
    When Admin clicks on the delete icon under the Manage program header
    Then Admin should see the box is disabled

  @ValSingleRowDeletionWithCheckbox
  Scenario: Validate single row delete with checkbox
    Given Admin is on the program page
    When Admin Should click the Enabled Delete icon on the datatable
    Then Admin should see the Delete confirmation popup box in program page

  @DeleteSingleProgram
  Scenario: Validate single row delete with checkbox
    Given Admin is on the program page
    When Admin clicks on the yes button on popup
    Then The respective row in the table should be deleted on program page

  @DeleteMultipleProgram
  Scenario: Validate multiple row delete with checkbox
    Given Admin is on the program page
    When Admin clicks on the delete icon under the Manage program header multiple delete
    Then The respective row in the table should be deleted in program module

  #-----------------------------------------------------Search-----------------------------------------------
  @SearchByProgramName
  Scenario Outline: Search Program by Program Name
    Given Admin is on the program page
    When Admin enter the "<field>" "<value>" in search textbox
    Then Admin should see Program details are searched by given fields

    Examples: 
      | field       |  | value    |
      | Name        |  | Door     |
      | Description |  | Open     |

  @SearchInvalid
  Scenario: Verify Admin is able to search results not found
    Given Admin is on the program page
    When Admin enter the program to search By program name that does not exist
    Then There should be zero results.

  #-------------------------------------------Sorting----------------------------------------------------------
  @SortProgramnameAsce
  Scenario: Verify sorting of Program name in Ascending order
    Given Admin is on the program page
    When Admin clicks on Arrow next to program Name of Program module page for sort
    Then Admin See the Program Name is sorted Ascending order in Program module page for sort

  @SearchProgramNameDesc
  Scenario: Verify sorting of Program name in Descending order
    Given Admin is on the program page
    When Admin clicks on Arrow next to program Name of Program module page for sort descend
    Then Admin See the Program Name is sorted Descending order in Program module page

  @SearchProgramDescriptionAsce
  Scenario: Verify sorting of Program description in Ascending order
    Given Admin is on the program page
    When Admin clicks on Arrow next to program description of Program module page for sort
    Then Admin See the Program description is sorted Ascending order in Program module page

  @SearchProgramDescriptionDesc
  Scenario: Verify sorting of Program description in Descending order
    Given Admin is on the program page
    When Admin clicks on Arrow next to program description of Program module page for sort descend
    Then Admin See the Program description is sorted Descending order in Program module page

  @SearchProgramStatusAsce
  Scenario: Verify sorting of Program status in Ascending order
    Given Admin is on the program page
    When Admin clicks on Arrow next to program status of Program module page for sort
    Then Admin See the Program status is sorted Ascending order in Program module page

  @SearchProgramStatusDesc
  Scenario: Verify sorting of Program status in Descending order
    Given Admin is on the program page
    When Admin clicks on Arrow next to program status of Program module page for sor descend
    Then Admin See the Program status is sorted Descending order in Program module page

  #----------------------------------- Pagination -----------------------------------------------------------
  @Pagination
  Scenario Outline: Validate pagination links for program page
    When Admin clicks the "<pageLink>" link on the data table in program page
    Then Admin should see the "<results>" on the data table in program module

    Examples: 
      | pageLink | results                           |
      | Next     | Next enabled link                 |
      | Last     | last page link with Next disabled |
      | Previous | previous page                     |
      | First    | very first page                   |

  @LogutProgramModule
  Scenario: Validate logout option in the header is visible and enabled from the program page
    Given Admin is on the program page
    When Admin clicks on the logout button on the Manage Program
    Then Admin should see the Login screen Page
