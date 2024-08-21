Feature: Get patient by ID

  Background: 
    Given Set Dietician token
      | D_Email             | D_Password | Role      |
      | apiph2aug@gmail.com | Daisy77    | Dietician |

  @Patient
  Scenario: Validate dietician is able to retrieve patients by field
    Given Dietician create GET request
    When Dietician send GET http request with given endpoint
    Then The dietitian receives a response body with a status code of 200 

  @Patient
  Scenario: Validate dietician is able to get patient by id with invalid method
    Given Dietician create Get request
    When Dietician send Get http request with invalid method
    Then The Dietician receives a response body 405 method not allowed

  @Patient
  Scenario: Validate dietician is able to retrieve patients by invalid fileld
    Given Dietician create GET request
    When Dietician send Get http request with invalid fileid
    Then The Dietician receives a response body 404 not found

  @Patient
  Scenario: Validate dietician able to retrieve patients by field with invalid endpoint
    Given Dietician create GET request
    When Dietician send get http request with invalid endpoint
    Then The Dietician receives a response body 404 not found
    
    Scenario Outline: Check other roles able to get patient by ID
    Given <Roles> Set Token with <Email> <Password>
    And <Roles> create Get requests
    When <Roles> send Get http requests with endpoint
    Then <Roles> recieves 403 Forbidden

    Examples: 
      | Email                 | Password | Roles   |
      | Team6.admin@gmail.com | test     | Admin   |
      | dietapi26@gmail.com | test     | Patient |
    
