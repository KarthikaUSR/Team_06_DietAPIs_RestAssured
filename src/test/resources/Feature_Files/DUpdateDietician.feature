Feature: update dietician details
  Background: set admin token
    Given set admin bearer token in request header
  Scenario Outline: check admin able to update dietician with valid data, dietician id and token
    Given admin creates "<Key>" request with valid mandatory, optional fields
    When admin send http request "<Key>" with endpoint
    Then admin recieves <Statuscode> ok with updated response body
    Examples:
      | Key                | Statuscode |
      | UpdateDietValidAll | 200        |
     # | UpdateDietValidMandatory            | 200        |
     # | UpdateDietValidAdditional           | 400        |
      | UpdateDietInValidAdditional          | 400        |
      #| UpdateDietInValidDietID         | 404        |
      #| UpdateDietValidDataInvalidMethod    | 405        |
      #| UpdateDietValidDataInvalidEndpoints | 404        |
    #|UpdateDietInValidContentType  | 415       |

#set dietician token
  Scenario: check admin able to update dietician with valid data and dietician bearer token
    Given admin creates put reqeust with dietician token
    When admin send put http request with endpoint and diet token
    Then admin recives 403 forbidden

  #set patient token
  Scenario: check admin able to update dietician with valid data and patient token
    Given admin creates put request with valid data and patient bearer token
    When admin send put http request with endpoint and patient token
    Then admin recives 403 forbidden

  #Scenario: check admin able to update dietician with valid data, dietician id and invalid content type
    Given admin creates put request with valid data and invalid content type
    When admin send put request with invalid content type
    Then admin recieves 415 unsuported media type