Feature: GET Dietician By ID

  Background: set admin bearer token
    Given set admin bearer token in request header

  Scenario Outline: Check admin able to retrieve dietician by ID
    Given Admin create GET request
    When Admin send GET http request with endpoint
    Then Admin recieves 200 ok with details of the dietician ID
      #| ID   |
      #| 1679 |
