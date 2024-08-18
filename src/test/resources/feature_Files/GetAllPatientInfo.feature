Feature: Get all Patients

Background:
    Given  Set Dietician token
    |D_Email              |D_Password| Role      |
    |APIPH2_1@gmail.com   |Neem77    | Dietician |
        
  @Patient
  Scenario: Check dietician able to retrieve all patients
  
    Given  Dietician create GET request 
    When   Dietician send GET http request with endpoint 
    Then   Dietician recieves 200 with response body
    
  @Patient
  Scenario: Check dietician able to retrieve all patient with invalid method
  
    Given  Dietician create PUT request 
    When   Dietician send PUT http request with endpoint 
    Then   Dietician recieves 405 method not allowed
    
  @Patient
  Scenario: Check dietician able to retrieve all patient with invalid endpoint
  
    Given  Dietician create GET request 
    When   Dietician send GET http request with invalid endpoint
    Then   Dietician recieves 404 not found
    
  @Patient
  
  Scenario Outline: Check other roles able to retrieve all patients 
  
    Given <Roles> Set Token with <Email> <Password> 
    And   <Roles> create GET requests 
    When  <Roles> send GET http requests with endpoint
    Then  <Roles> recieves 403 Forbidden
    Examples: 
    |Email                |Password  | Roles     |
    |Team6.admin@gmail.com|test      | Admin     |
    |RestA_Hack1@gmail.com|test      | Patient   |
     
     
     
     
     
     
     
  
