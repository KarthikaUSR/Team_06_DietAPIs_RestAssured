Feature: delete dietician details by dietician id
  Background: admin token is set
    Given admin bearer token is set
    Scenario: check admin able to delete dietician by id
      Given admin create delete request
      When admin send delete http request with endpoint
      Then admin recieves 200 ok
    Scenario: check admin able to delete dietician by id with invalid method
      Given admin create post request
      When admin send post request with endpoint
      Then admin recives 405 method not allowed
    Scenario: check admin able to delete dietician by invalid id
      Given admin create delete request
      When admin send delete http request with endpoint
      Then admin recives 404 not found
    Scenario: check admin able to delete dietician by id with invalid endpoint
      Given admin create delete request
      When admin send delete request with invalid endpoint
      Then admin recives 404 not found
