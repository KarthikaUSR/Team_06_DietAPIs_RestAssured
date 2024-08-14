
Feature: Create Patient
  

  @Patient
  Scenario: Check dietician able to create patient with valid data
    Given Dietician creates POST request by entering valid data into the form-data key and value fields.
    When Dietician send POST http request with endpoint
    Then Dietician recieves 401 unauthorized
