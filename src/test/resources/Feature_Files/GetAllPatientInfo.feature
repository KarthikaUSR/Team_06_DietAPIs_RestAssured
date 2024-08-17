Feature: Get all Patients

Background:
    Given  Set Dietician token
    |D_Email              |D_Password | Role      |
    |APIPH2_1@gmail.com   |Neem77     |  Dietician|
  
 
      
  @Patient
  Scenario: Check dietician able to retrieve all patients
  
    Given Dietician create GET request 
    When  Dietician send GET http request with endpoint 
    Then  Dietician recieves 200 ok with response body