
Feature: Update Patient

Background:
    Given  Set Dietician token
    |D_Email              |D_Password| Role      |
    |APIPH2_1@gmail.com   |Neem77    | Dietician |
      
  @Patient
  Scenario: Check dietician able to add new reports with valid data and token  
    Given Dietician creates <Key> request to add new reports
    When  Dietician send http request to add new reports with endpoints <Key>
    Then  Dietician recieves <Statuscode> with response body for adding new reports
    
       
  Examples: 
    |Key                                                  |Statuscode| 
    |WithVitalsforPatientWithValidData                    |200       | 
    |WithoutVitalsforPatientWithValidData                 |200       |
    |AddOnlyNewVitalsWithoutReportsForPatientWithReport   |200       |
    |AddOnlyNewVitalsWithoutReportsForPatientWithoutReport|200       | 
    |PatientOnlyWithValidMandatoryDetails                 |200       |
    |PatientOnlyWithValidAdditionalDetails                |200       | 
    |PatientWithInvalidData                               |400       | 
    |PatientWithValidDataInvalidPatientId                 |404       |  
    |PatientWithValidDataInvalidMethod                    |405       |
    |PatientWithValidDataInvalidEndPoints                 |404       |
    |PatientWithValidDataInvalidContentType               |415       |
   
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
   
    
    
    
    
    
    
    