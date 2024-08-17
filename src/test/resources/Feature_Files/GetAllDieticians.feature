Feature: retrieve all dieticians
  Background: set admin token
    Given admin bearer token is set in header
  Scenario: check admin able to retrieve all dieticians
    Given admin create get request
    When admin send get http request with endpoint
    Then admin recives 200 ok with resonse body
  Scenario: check admin able to retrieve all dieticians with invalid method
    Given admin create put method
    When admin send put method
    Then admin recives 405 method not allowed
  Scenario: check admin able to retrieve all dieticians with invalid endpoint
    Given admin create get request
    When admin send http request with invalid endpoint
    Then admin recives 404 not found