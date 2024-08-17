
Feature: Create Patient

Background:
    Given Set Dietician bearer token 
    
    |Role       |Token      | 
    |No auth    |" "        |  
    |Admin      |" "        | 
    |Patient    |" "        | 
    |Dietician  |" "        | 
      
  @Patient
  Scenario: Check dietician able to create patient with valid data and token 
    Given Dietician creates POST request by entering valid data. 
    ( Mandatory and additional details) into the form-data key and value fields.
    When Dietician send POST http request with endpoint
    Then Dietician recieves 401 unauthorized
