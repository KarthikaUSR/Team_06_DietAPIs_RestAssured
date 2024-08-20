
Feature: Create Patient

Background:
    Given  Set Dietician token
    |D_Email              |D_Password| Role      |
    |APIPH2_1@gmail.com   |Neem77    | Dietician |
      
  @Patient
  Scenario: Check dietician able to create patient with valid data and token  
    Given Dietician creates <Key> request into the form-data key and value fields
    When  Dietician send http patient creation request with endpoint <Key>
    Then  Dietician recieves <Statuscode> with response body for patient
    And   Validate the response body
       
  Examples: 
    |Key                                     |Statuscode| 
    |PateintCreationValid                    |201       | 
    |PateintCreationValidMandatory           |201       |
    |PateintCreationValidAdditional          |400       |
    |PateintCreationInValidMandatory         |400       | 
    |PateintCreationInValidAdditional        |400       |
    |PateintCreationValidDataInvalidMethod   |405       | 
    |PateintCreationValidDataInvalidEndpoints|404       | 
    #|PateintCreationInValidContentType       |415       |
    
  @Patient
  
  Scenario Outline: Check other roles able to retrieve all patients 
  
    Given <Roles> Set Token with <Email> <Password> 
    And   <Roles> creates request by entering valid data into the form-data
    When  <Roles> send http requests with endpoint for patient creation
    Then  <Roles> recieves 403 Forbidden
    Examples: 
    |Email                  |Password  | Roles     |
    |Team6.admin@gmail.com  |test      | Admin     |
    |RestA_check10@gmail.com|test      | Patient   |
    
    
    
    
    
    
    
    
    