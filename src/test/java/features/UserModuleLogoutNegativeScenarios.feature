Feature: LOGOUT [GET Operation]

 Background: Set bearer token in header
 
 Scenario: Check admin able to logout  
    Given User creates GET request 
    When User send GET HTTP request with endpoint
    Then User recieves 200 created with Logout successful message
    
 Scenario: N-Check admin able to logout  with invalid method  
    Given admin creates POST request 
    When admin send POST HTTP request with endpoint
    Then admin recieves 405 method not allowed
       


Scenario: Check dietician able to logout   
    Given dietician creates GET request  
    When dietician send GET HTTP request with endpoint
    Then dietician recieves 200 created with Logout successful message
       
Scenario: N-Check dietician able to logout  with invalid method
Given dietician creates POST request 
When dietician send POST HTTP request with endpoint
Then dietician recieves 405 method not allowed


Scenario: Check patient able to logout 
 Given patient creates GET request  
    When patient send GET HTTP request with endpoint
    Then patient recieves 200 created with Logout successful message
    
Scenario: N-Check atient able to logout  with invalid method
    Given patient creates POST request  
    When patient send GET HTTP request with endpoint
    Then patient recieves 200 created with Logout successful message





