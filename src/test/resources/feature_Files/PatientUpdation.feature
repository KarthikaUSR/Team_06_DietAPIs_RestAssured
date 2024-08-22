
Feature: Update Patient

Background:
    Given  Set Dietician token
    |D_Email              |D_Password| Role      |
    |APIPH2_1@gmail.com   |Neem77    | Dietician |
      
  @Patient
  Scenario: Check dietician able to Update patient with valid data and token  
    Given Dietician creates <Key> request to update patient details
    When  Dietician send http patient updation request with endpoints <Key>
    Then  Dietician recieves <Statuscode> with response body after patient updation
    And   Validate the response body after the patient updation
       
  Examples: 
    |Key                                   |Statuscode| 
    |PateintUpdateValid                    |200       | 
    |PateintUpdateValidMandatory           |200       |
    |PateintUpdateValidAdditional          |400       |
    |PateintUpdateInValidMandatory         |400       | 
    |PateintUpdateInValidPatientID         |404       |
    |PateintUpdateWithNoFile               |200       | 
    |PateintUpdateValidDataInvalidMethod   |405       | 
    |PateintUpdateValidDataInvalidEndpoints|404       |  
    |PateintUpdationInValidContentType     |415       |
    
  @Patient
  
  Scenario Outline: Check other roles able to retrieve all patients 
  
    Given <Roles> Set Token with <Email> <Password> 
    And   <Roles> creates request by entering valid data into the form-data
    When  <Roles> send http requests with endpoint for patient creation
    Then  <Roles> recieves 403 Forbidden for patient creation
    Examples: 
    |Email                  |Password  | Roles     |
    |Team6.admin@gmail.com  |test      | Admin     |
    |RestA_check9@gmail.com|test      | Patient   |
   
    
    
    
    
    
    
    