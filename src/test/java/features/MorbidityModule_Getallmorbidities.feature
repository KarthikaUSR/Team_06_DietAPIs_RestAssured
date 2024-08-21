Feature: Get Operation [Get all Morbidities ]

  #Set no auth
  Scenario: N-Check dietician able to retrieve all morbidities details
    Given Dietician create GET request
    When Dietician send GET http request with endpoint
    Then Dietician recieves 401 unauthorized

  #Set patient token
  Scenario: Check pateint is able to retrieve all morbidities details
    Given Patient create GET request
    When Patient send GET http request with endpoint
    Then Patient recieves 403 Forbidden

  #Set admin token
  Scenario: Check admin able to retrieve all morbidities details
    Given admin create GET request
    When admin send GET http request with endpoint
    Then admin recieves 200 ok with details of the patient id

  Scenario: N-Check admin able to retrieve all morbidities details with invalid method
    Given admin create POST request
    When admin send POST http request with endpoint
    Then admin recieves 405 method not allowed

  Scenario: N-Check admin able to retrieve all morbidities details with invalid endpoint
    Given admin create GET request
    When admin send GET http request with invalid endpoint
    Then admin recievew 404 not found

  #Set dietecian token
  Scenario: Check dietician able to retrieve all morbidities details
    Given Dietician create GET request
    When Dietician send GET http request with endpoint
    Then admin recieves 200 ok with details of the patient id

  Scenario: N-Check dietician able to retrieve all morbidities details with invalid method
    Given Dietician create POST request
    When Dietician send POST http request with endpoint
    Then Dietician recieves 405 method not allowed

  Scenario: N-Check dietician able to retrieve all morbidities details with invalid endpoint
    Given Dietician create GET request
    When Dietician send GET http request with invalid endpoint
    Then Dietician recieves 404 not found
