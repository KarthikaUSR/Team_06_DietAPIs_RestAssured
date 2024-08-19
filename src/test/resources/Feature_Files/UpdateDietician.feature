Feature: update dietician details
  Background: set admin token
    Given set admin token in header

  Scenario: check admin able to update dietician with valid data, dietician id and token
    Given admin creates put request with mandatory and additional details
    When admin send put request with endpoint
    Then admin recieves 200 ok with updated response body