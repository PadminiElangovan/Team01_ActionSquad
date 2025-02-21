Feature: Batch Page Navigation

  Background: Veryfy Admin is able to login Succesfully
    Given Admin is logged into the LMS portal and on the dashboard page

  Scenario: Verify Admin Navigate to Batch page successfully
    Given Admin is on LMS Homepage
    When Admin Clicks on the Batch menu from the header
    Then Admin should be in the Manage Batch Page

  Scenario Outline: Batch Page Elements Validation
    Given Admin is on the home page
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the "<Elements>" on the Batch page

    Examples: 
      | Elements                                                                                                 |
      | LMS - Learning Management System                                                                         |
      | Manage Batch                                                                                             |
      | disabled Delete Icon under the header                                                                    |
      | enabled pagination controls under the data table                                                         |
      | edit icon in each data row                                                                               |
      | delete icon in each data row                                                                             |
      | checkbox in each data row                                                                                |
      | datatable headers: Batch name, Batch Description, Batch Status, No Of classes, Program Name, Edit/Delete |
      | checkbox in the datatable header row                                                                     |
      | sort icon next to all datatable headers                                                                  |

  Scenario Outline: Verify sub menu displayed in batch menu bar
    Given Admin is on batch page
    When Admin clicks "Add New Batch" under batch menu bar
    Then Admin should see the Batch Details pop up window "<Menu>"

    Examples: 
      | Menu                      |
      | Batch Name                |
      | Number of classes         |
      | Description as text box   |
      | Program Name as drop down |
      | Status as radio button    |
      | Save Button               |
      | Cancel Button             |
      | close                     |

  Scenario: Validate batchname prefix selected program name
    Given Admin is on the Batch Details Pop Up Window
    When Admin selects program name present in the dropdown
    Then Admin should see selected program name in the batch name prefix box

  Scenario Outline: Validate batch name suffix box should accept only numbers
    Given Admin is on the Batch Details Pop Up Window
    When Admin enters alphabets and alphanumeric and special character in "<BatchName>" suffix box
    Then Admin should get "<expected_message>" below the text box of respective field

    Examples: 
      | BatchName | expected_message                                |
      | DB        | This field accept only numbers and max 5 count. |
      | BG5       | This field accept only numbers and max 5 count. |
      | $$        | This field accept only numbers and max 5 count. |

  Scenario: Validate batch name prefix box is not editable
    Given Admin is on the Batch Details Pop Up Window
    When Admin enters alphabets in batch name prefix box
    Then Admin should see empty text box

  Scenario: Validate input data only for mandatory fields
    Given Admin is on the Batch Details Pop Up Window
    When Admin enters the data only to the mandatory fields and clicks save button
    Then Admin should get a successful message "Batch created successfully"

  Scenario: validate input data missing for mandatory fields
    Given Admin is on the Batch Details Pop Up Window
    When Admin leaves blank one of the mandatory fields
    Then Admin should get a error message on the respective mandatory field

  Scenario: validate cancel button in Batch details pop up
    Given Admin is on the Batch Details Pop Up Window
    When Admin enters the valid data to all the mandatory fields and click cancel button
    Then Admin can see the batch details popup closes without creating any batch

  Scenario: validate close icon on the batch details pop up
    Given Admin is on the Batch Details Pop Up Window
    When Admin clicks on the close icon
    Then Admin can see batch details pop up closes

  Scenario: Validate Edit icon feature in any row
    Given Admin is on the Batchs page
    When Admin clicks the edit icon
    Then Admin should see the Batch details pop up window
    When Admin clicks the edit icon
    Then Admin should see Program name and Batch name value field is disabled for editing
    When Admin Updates any fields with invalid data and click save button
    Then Admin should get a error message under the respective field
    When Admin enters the valid data to all the mandatory fields and click save button
    Then Admin should get a successful message for editing the batch
    When Admin enters the valid data in edit btach to all the mandatory fields and click cancel button
    Then Admin can see the batch details popup closes without editing the batch
    When Admin enters the valid data to all the mandatory fields and click close button
    Then Admin can see the batch details popup closes without editing the batch

  Scenario: validate delete Icon on any row
    Given Admin is on the Batchs page
    When Admin clicks the delete Icon on any row
    Then Admin should see the confirm alert box with yes and no button

  Scenario: Validate yes button on the confirm alert box
    Given Admin is on the batch confirm popup page
    When Admin clicks on the delete icon and click yes button
    Then Admin should see the successful message and the batch should be deleted

  Scenario: validate no button on the confirm alert box
    Given Admin is on the batch confirm popup page
    When Admin clicks on the delete icon and click no button
    Then Admin should see the alert box closed and the batch is not deleted

  Scenario: validate close Icon on the alert box
    Given Admin is on the batch confirm popup page
    When Admin clicks on the close icon on deletewindow
    Then Admin should see the alert box closed

  Scenario: Validate single row delete with checkbox
    Given Admin is on the batch page
    When Admin clicks on the delete icon under the Manage batch header
    Then Admin should see the box get highlighted
    
 Scenario: Validate single row delete with checkbox
    Given Admin is on the batch page
    When Admin Should click the Enabled Delete icon on the header
    Then Admin should see the Delete confirmation popup box
    
 Scenario: Validate single row delete with checkbox
    Given Admin is on the batch page
    When Admin clicks on the yes button
    Then The respective row in the table should be deleted

  Scenario: Validate multiple row delete with checkbox
    Given Admin is on the batch page
    When Admin clicks on the delete icon under the Manage batch header
    Then The respective row in the table should be deleted

  Scenario Outline: Validate pagination links
    Given Admin is on the batch page
    When Admin clicks the <pageLink> link on the data table
    Then Admin should see the <pageLink> results on the data table

    Examples: 
      | pageLink | results                           |
      | Next     | Next enabled link                 |
      | Last     | last page link with Next disabled |
      | Previous | previous page                     |
      | First    | very first page                   |

  Scenario: validate search box functionality
    Given Admin is on the batch page
    When Admin enters the batch name in the search text box
    Then Admin should see the filtered batches in the data table

  Scenario: Validate logout option in the header is visible and enabled from the batch page
    Given Admin is on the batch page
    When Admin clicks on the logout button
    Then Admin should see the Login screen Page
