Feature: create dietician
  Background: set admin bearer token
    Given set admin bearer token in request header
  Scenario Outline: check admin able to create dietician with valid data and token
    Given admin creates "<Key>" request
    When admin send post "<Key>" http request with endpoint
    Then admin recieves <Statuscode> created
    Examples:
      | Key               | Statuscode |
      | DietCreationValid | 201        |
     # | DietCreationValidMandatory            | 201        |
     # | DietCreationValidAdditional           | 400        |
      | DietCreationInValidMandatory          | 400        |
      #| DietCreationInValidAdditional         | 400        |
      #| DietCreationValidDataInvalidMethod    | 405        |
      #| DietCreationValidDataInvalidEndpoints | 404        |
    #|DietCreationCreationInValidContentType  | 415       |


  Scenario: check admin able to create dietician with valid data and dietician bearer token
    Given admin creates post reqeust with valid data
    When admin send post http request with endpoint
    Then admin recives 403 forbidden for dietician token


  Scenario: check admin able to create dietician with valid data and patient token
    Given admin creates post request with patient token
    When admin send post http request with endpoint
    Then admin recives 403 forbidden for patient token