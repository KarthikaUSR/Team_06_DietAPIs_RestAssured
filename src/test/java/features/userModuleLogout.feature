Feature: LOGOUT [GET Operation]

 Background: Set bearer token in header
 
    Given  Set bearer token in header
    |Email              |Password| Role      |
    
    |Team6.admin@gmail.com|test      | Admin     |
    |shobana@gmail.com     |Honor66  |  Dietician|
    |RestA_Hack2@gmail.com|test      | Patient   |
 


  Scenario Outline: Check dietician able to retrieve all patients
    Given <Roles> Setup the valid logout endpoint
    And  <Roles>  Setup the invalid logout endpoint
    When <Roles> send request by entering valid data
    And  <Roles> send request by entering invalid data
    Then <Roles> recieves 200 for valid
    And  <Roles> recieves 403 Forbidden for invalid
    Examples:
    |Roles    |
    |Admin    |
    |Dietician|
    |Patient  |
  


 

  #Scenario: N-Check admin able to logout  with invalid method
  #  Given admin creates POST request
    #When admin send POST HTTP request with endpoint
    #Then admin recieves 403 method not allowed
#
 #
#
 # Scenario: Check dietician able to logout
  #  Given dietician creates GET request
   # When dietician send GET HTTP request with endpoint
    #Then dietician recieves 200 created with Logout successful message
#
  #Scenario: N-Check dietician able to logout  with invalid method
    #Given dietician creates POST request
    #When dietician send POST HTTP request with endpoint
    #Then dietician recieves 403 method not allowed
#
  #Scenario: Check patient able to logout
  # Given patient creates GET request
   # When patient send GET HTTP request with endpoint
    #Then patient recieves 200 created with Logout successful message
#
  #Scenario: N-Check patient able to logout  with invalid method
    #Given patient creates POST request
    #When patient send POST HTTP request with endpoint
    #Then patient recieves 403 method not allowed

