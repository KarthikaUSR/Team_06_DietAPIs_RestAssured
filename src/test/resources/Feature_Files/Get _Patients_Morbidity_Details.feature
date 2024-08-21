Feature: Get Patients Morbidity Details

  Background: 
    Given Set Dietician token
      | D_Email              | D_Password | Role      |
      | APIDIET123@gmail.com | Bag22      | Dietician |

  @Patient
  Scenario: Validate dietician is able to retrieve patients morbidity details by patient ID
    Given Dietician create GET request for patient ID
    When The Dietician send GET http request with given endpoint
    Then Dietician should receives 200 ok with details of the patient id

  @Patient
  Scenario: Validate dietician is able to retrieve patients morbidity details by patient ID with invalid method
    Given Dietician create POST request
    When Dietician send POST http request with given endpoint
    Then Dietician should receives 405 method not allowed

  @Patient
  Scenario: Validate dietician is able to retrieve patients morbidity details by invalid patient ID
    Given Dietician create GET request for patient ID
    When Dietician send GET http request with Invalid patient ID
    Then Dietician should receives 404 not found

  @Patient
  Scenario: Validate dietician is able to retrieve patients morbidity details by patient ID with invalid endpoint
    Given Dietician create GET request for patient ID
    When Dietician send GET http request with invalid endpoint
    Then Dietician should receives 404 not found
    
    Scenario Outline: Check other roles able to delete patient by ID
    Given <Roles> Set Token with <Email> <Password>
    And <Roles> create Get requests
    When <Roles> send Get http requests with endpoint
    Then <Roles> recieves 403 Forbidden

    Examples: 
      | Email                 | Password | Roles   |
      | Team6.admin@gmail.com | test     | Admin   |
      | dietapi26@gmail.com | test     | Patient |
    
