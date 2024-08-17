Feature: Login as admin
  Scenario: check user able to login as admin with valid data
    Given user creates post request with request body
    When user send "POST" http request with endpoint
    Then user receives statuscode 200 created with response body