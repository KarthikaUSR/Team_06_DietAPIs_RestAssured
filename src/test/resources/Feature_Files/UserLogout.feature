Feature: check all three roles admin, dietician, patient able to logout
  Scenario: check amdin able to logout
    Given user creates get request
    When user send http request with endpoint
    Then user recives 200 created with logout successful message


