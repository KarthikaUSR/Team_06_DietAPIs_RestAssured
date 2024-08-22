Feature: Get all Morbidities

  Background: 
    Given Set Admin Token
      | A_Email               | A_Password | Role      |
      | Team6.admin@gmail.com | test       | Dietician |
@Patient
  Scenario Outline: Check admin able to retrieve all morbidities details
    Given <Roles> Set Token with <Email> <Password>
    And <Roles> create GET request
    #When <Roles> send GET http request with endpoint
    Then <Roles> recieves 200 ok with details of the patient id

    Examples: 
      | Email                 | Password | Roles     |
      | Team6.admin@gmail.com | test     | Admin     |
      | APIDIET1234@gmail.com | Light21  | Dietician |
@Patient
  Scenario Outline: Check admin able to retrieve all morbidities details with invalid method
    Given <Roles> Set Token with <Email> <Password>
    And <Roles> create GET request
    #When <Roles> send POST http request with endpoint

    #Then <Roles> recieves 405 method not allowed
    Examples: 
      | Email                 | Password | Roles     |
      | Team6.admin@gmail.com | test     | Admin     |
      | APIDIET1234@gmail.com | Light21  | Dietician |
@Patient
  Scenario Outline: Check admin able to retrieve all morbidities details with invalid endpoint
    Given <Roles> Set Token with <Email> <Password>
    And <Roles> create GET request

    #When <Roles> send GET http request with invalid endpoint
    #Then <Roles> recieves 404 not found
    Examples: 
      | Email                 | Password | Roles     |
      | Team6.admin@gmail.com | test     | Admin     |
      | APIDIET1234@gmail.com | Light21  | Dietician |
@Patient
  Scenario Outline: Check pateint is able to retrieve all morbidities details
    Given <Roles> Set Token with <Email> <Password>
    #And <Roles> Patient create GET request
    #When <Roles> Patient send GET http request with endpoint
    #Then <Roles> Patient recieves 403 Forbidden

    Examples: 
      | Email                | Password | Roles   |
      | dietapi434@gmail.com | test     | Patient |
@Patient
  Scenario Outline: Check dietician able to retrieve all morbidities details
    Given Set no auth
    And <Roles> Dietician create GET request
    #When <Roles> Dietician send GET http request with endpoint
    Then <Roles> Dietician recieves 401 unauthorized

    Examples: 
      | Email | Password | Roles |
      |       |          |       |
