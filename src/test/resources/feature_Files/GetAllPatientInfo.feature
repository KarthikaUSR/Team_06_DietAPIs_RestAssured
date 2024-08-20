Feature: Get all Patients

Background:
    Given  Set Dietician token
    |D_Email              |D_Password| Role      |
    |APIPH2_1@gmail.com   |Neem77    | Dietician |
        
  @Patient
  Scenario: Check dietician able to retrieve all patients
  
    Given  Dietician create <Key> request 
    When   Dietician send http get all patient request with endpoint <Key>
    Then   Dietician recieves <Statuscode> with response body
    
    Examples: 
    |Key            |Statuscode| 
    |Valid          |200       | 
    |InvalidMethod  |405       |
    |InvalidEndpoint|404       |  
    
  @Patient
  
  Scenario Outline: Check other roles able to retrieve all patients 
  
    Given <Roles> Set Token with <Email> <Password> 
    And   <Roles> create GET requests 
    When  <Roles> send GET http requests with endpoint
    Then  <Roles> recieves 403 Forbidden
    Examples: 
    |Email                |Password  | Roles     |
    |Team6.admin@gmail.com|test      | Admin     |
    |RestA_Hack2@gmail.com|test      | Patient   |
     
     
     
     
     
     
     
  
