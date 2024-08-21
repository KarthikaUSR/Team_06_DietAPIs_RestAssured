Feature: Get Operation [Retrieve Morbidity condition by Test name ]

  #Set no auth
  Scenario: N-Check dietician able to morbidity condition by test name
    Given Dietician create GET request
    When Dietician send GET http request with endpoint
    Then Dietician recieves 401 unauthorized

  #Set Patient Token
  Scenario: Check pateint is able to retrieve morbidity condition by test name
    Given Patient create GET request
    When Patient send GET http request with endpoint
    Then Patient recieves 403 Forbidden

  #Set admin token
  Scenario: Check admin able to retrieve morbidity condition by test name
    Given admin create GET request
    When admin send GET http request with endpoint
    Then admin recieves 200 ok with details of the patient id

  Scenario: N-Check admin able to retrieve morbidity condition by test name  with invalid method
    Given admin create POST request
    When admin send POST http request with endpoint
    Then admin recieves 405 method not allowed

  Scenario: N-Check admin able to retrieve morbidity condition by invalid test name
    Given admin create GET request
    When admin send GET http request with endpoint
    Then admin recieves 404 not found

  Scenario: N-Check admin able to retrieve morbidity condition by test name with invalid endpoint
    Given admin create GET request
    When admin send GET http request with invalid endpoint
    Then admin recieves 404 not found

  #Set dietetian token
  Scenario: Check dietician able to retrieve morbidity condition by test name
    Given Dietician create GET request
    When Dietician send GET http request with endpoint
    Then Dietician recieves 200 ok with details of the patient id

  Scenario: N-Check dietician able to retrieve morbidity condition by test name  with invalid method
    Given Dietician create POST request
    When Dietician send POST http request with endpoint
    Then Dietician recieves 405 method not allowed

  Scenario: N-Check dietician able to retrieve morbidity condition by invalid test name
    Given Dietician create GET request
    When Dietician send GET http request with endpoint
    Then Dietician recieves 404 not found

  Scenario: N-Check dietician able to retrieve morbidity condition by test name with invalid endpoint
    Given Dietician create GET request
    When Dietician send GET http request with invalid endpoint
    Then Dietician recieves 404 not found
