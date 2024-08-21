Feature: Delete patient by ID

  Background: 
    Given Set Dietician token
      | D_Email             | D_Password | Role      |
      | apiph2aug@gmail.com | Daisy77    | Dietician |

  @Patient
  Scenario: Validate dietician is able to delete patient by ID
    Given Dietician create DELETE request
    When Dietician send DELETE http request with endpoint
    Then Dietician recieves 200 with response body

  @Patient
  Scenario: Validate dietician is able to delete patient by id with invalid method
    Given Dietician create DELETE request
    When Dietician send DELETE http request with invalid method
    Then Dietician should receives 405 method not allowed

  Scenario: Validate dietician is able to delete patient by invalid id
    Given Dietician create DELETE request
    When Dietician send DELETE http request with Invalid Id
    Then Dietician should receives 404 not found

  Scenario: Validate dietician is able to delete patient by id with invalid endpoint
    Given Dietician create DELETE request
    When Dietician send DELETE http request with invalid endpoint
    Then Dietician should receives 404 not found

  Scenario Outline: Check other roles able to delete patient by ID
    Given <Roles> Set Token with <Email> <Password>
    And <Roles> create Delete requests
    When <Roles> send Delete http requests with endpoint
    Then <Roles> recieves 403 Forbidden

    Examples: 
      | Email                 | Password | Roles   |
      | Team6.admin@gmail.com | test     | Admin   |
      | dietapi26@gmail.com | test     | Patient |
