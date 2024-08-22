Feature: Login as Admin

  Scenario: Check user able to login as admin with valid data
    Given User creates Post request with request body
    When User send "POST" HTTP request with endpoint
    Then User recieves statusCode 200 created with response body

  Scenario: N-Check user able to login as admin with invalid credential
    Given User creates Post request with invalid credential
    When User send POST HTTP request with endpoint
    Then User recieves statusCode 401 unauthorized

  Scenario: N-Check user able to login as admin with valid credential and invalid method
    Given User creates GET request with request body
    When User send GET HTTP request with endpointt
    Then User recieves statusCode 405 method not allowed

  Scenario: N-Check user able to login as admin with valid credential and invalid endpoint
    Given User creates Post request with request body
    When User send POST HTTP request with invalid endpoint
    Then User recieves statusCode 401 unauthorized

  Scenario: Check user able to login as dietician with valid credential
    Given User creates Post request with dietician valid credential
    When User send POST HTTP request with dietician valid endpoint
    Then User recieves statusCode 200 created with response body

  Scenario: N-Check user able to login as dietician with invalid credential
    Given User creates Post request for dietician with invalid credential
    When User send POST HTTP request with endpoint
    Then User recieves 401 unauthorized

  Scenario: Check user able to login as patient with valid credential
    Given User creates Post request as patient valid credential
    When User send POST HTTP request with patient valid credential
    Then User recieves statusCode 200 created with response body

  Scenario: N-Check user able to login as patient with invalid credential
    Given User creates Post request as patient with invalid credential
    When User send POST HTTP request with endpoint
    Then User recieves 401 unauthorized

  Scenario: N-Check user able to login as admin with valid credential and invalid content type
    Given User creates Post request with request body and invalid content type
    When User send POST HTTP request with endpoint
    Then User recieves statusCode 415 unsupported media type