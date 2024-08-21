Feature: create dietician

  Background: set admin bearer token
    Given set admin bearer token in request header

  Scenario Outline: check admin able to create dietician with valid data and token
    Given admin creates "<Key>" request
    When admin send post http request with endpoint
    Then admin recieves <Statuscode> created

    Examples: 
      | Key                                   | Statuscode |
      | DietCreationValid                     |        201 |
      #| DietCreationValidMandatory            |        201 |
      #| DietCreationValidAdditional           |        400 |
      #| DietCreationInValidMandatory          |        400 |
      #| DietCreationInValidAdditional         |        400 |
      #| DietCreationValidDataInvalidMethod    |        405 |
      #| DietCreationValidDataInvalidEndpoints |        404 |
    #|DietCreationCreationInValidContentType  | 415       |
