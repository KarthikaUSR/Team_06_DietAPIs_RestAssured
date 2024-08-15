Feature: Login as Admin

  Scenario: Check user able to login as admin with valid data
    Given User creates Post request with request body
    When User send "POST" HTTP request with endpoint
    Then User recieves statusCode 200 created with response body