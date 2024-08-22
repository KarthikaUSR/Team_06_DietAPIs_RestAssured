Feature: Get dietician details by ID
  Background: set admin token
    Given set admin bearer token in request header
  Scenario: check admin able to retrieve dietician by id
    Given admin creates get request by dietician id
    When admin send get http request with endpoint
    Then admin recives 200 ok

  Scenario: check admin able to retrieve dietician by id with invalid method
    Given admin create post request with invalid method
    When admin send post http invalid method
    Then admin recived 405 method not allowed

  Scenario: check admin able to retrieve dietician by invalid id
    Given admin create get request with invalid id
    When admin send get http request with endpoint
    Then admin recives 404 not found

  Scenario: check admin able to retrieve dietician with invalid endpoint
    Given admin create get request with invalid enpoint
    When admin send get http request with endpoint
    Then admin recives 404 not found

