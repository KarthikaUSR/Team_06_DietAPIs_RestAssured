 Feature: Check User able to send request with no authorization.
 
 @Patient
 Scenario Outline: Check User able to send Get Put Delete Post request with no auth
  
    Given  User able to <ToDo> request 
    When   User send http get all patient request with endpoint <ToDo>
    Then   User recieves "401" with response body
    
    Examples: 
    |ToDo                   |
    |CreatePatient          |
    |UpdatePatient          |
    |AddNewReports          | 
    |RetriveAllPatient      |
    |RetrivePatientMorbidity|
    |RetrivePatientByFileId |
    |DeletePatientByFileId  |
    
   