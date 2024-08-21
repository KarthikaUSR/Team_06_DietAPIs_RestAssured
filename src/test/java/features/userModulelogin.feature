Feature: user login [Post Operation]

  Scenario: Check user able to login as admin with valid data
    Given User creates Post request with request body
    When User send POST HTTP request with endpoint
    Then User recieves statusCode 200 created with response body

  Scenario: N-Check user able to login as admin with invalid credential
    Given User creates Post request with invalid credential
    When User send POST HTTP request with endpoint
    Then User recieves 401 unauthorized

  Scenario: N-Check user able to login as admin with valid credential and invalid method
    Given User creates GET request with request body
    When User send GET HTTP request with endpointt
    Then User recieves 405 method not allowed

  Scenario: N-Check user able to login as admin with valid credential and invalid endpoint
    Given User creates Post request with request body
    When User send POST HTTP request with invalid endpoint
    Then User recieves 401 unauthorized

  Scenario: N-Check user able to login as admin with valid credential and invalid content type
    Given User creates Post request with request body and invalid content type
    When User send POST HTTP request with endpoint
    Then User recieves 415 unsupported media type

  Scenario: Check user able to login as dietician with valid credential
    Given User creates Post request with request body
    When User send POST HTTP request with endpoint
    Then User recieves statusCode 200 created with response body

  Scenario: N-Check user able to login as dietician with invalid credential
    Given User creates Post request for dietecian with invalid credential
    When User send POST HTTP request with endpoint
    Then User recieves 401 unauthorized

  Scenario: Check user able to login as patient with valid credential
    Given User creates Post request with request body
    When User send POST HTTP request with endpoint
    Then User recieves statusCode 200 created with response body

  Scenario: N-Check user able to login as patient with invalid credential
    Given User creates Post request with invalid credential
    When User send POST HTTP request with endpoint
    Then User recieves 401 unauthorized
