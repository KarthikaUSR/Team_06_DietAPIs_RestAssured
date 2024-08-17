##Feature: Get all Patients

#Background:
   # Given  Set Dietician token
   # |D_Email              |D_Password |
    #|APIPH2_1@gmail.com   |Neem77     |
  
  # @Patient
    #Scenario Outline: Check dietician able to retrieve all patients
  
    #Given <Roles> create GET request 
    #When  <Roles> send GET http request with endpoint 
    #Then  <Roles> recieves <StatusCode> with response body
    
    #Examples: 
      #|Roles     | StatusCode|
      #|Norole    |401        |
      #|Admin     |200        |
      #|Dietician |403        |
      #|Patient   |403        |