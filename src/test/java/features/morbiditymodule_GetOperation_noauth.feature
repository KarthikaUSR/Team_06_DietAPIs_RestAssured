Feature: Get Operation [Get all Morbidities ]

  Scenario: N-Check dietician able to retrieve all morbidities details
    Given Dietician create GET request
    When Dietician send GET http request with endpoint
    Then Dietician recieves 401 unauthorized