Feature: Get Patients Morbidity Details

  Background: 
    Given Set Dietician token
      | D_Email              | D_Password | Role      |
      |apiph2aug@gmail.com   | Daisy77      | Dietician |

   @Patient
  
  Scenario: Check dietician able to retrieve patients morbidity details by patient ID
  
    Given  Dietician create <Key> request for retrieve patients morbidity details by patient ID
    When   Dietician send http request for retrieve patients morbidity details by patient ID with endpoint <Key>
    Then   Dietician recieves <Statuscode> with response body for retrieve patients morbidity details by patient ID
    
    Examples: 
    |Key            |Statuscode| 
    |ValidFileID    |200       |
    |InvalidFileID  |404       |  
    |InvalidMethod  |405       |
    |InvalidEndpoint|404       |
  
  
    
    Scenario Outline: Check other roles able to retrieve Morbidity
    Given <Roles> Set Token with <Email> <Password>
    And <Roles> create Get requests to retrieve Morbidity
    When <Roles> send Get http requests with endpoint for retrieve Morbidity
    Then <Roles> recieves <Statuscode> Forbidden for retrieve Morbidity

    Examples: 
      | Email                 | Password | Roles   |Statuscode|
      | Team6.admin@gmail.com | test     | Admin   |403|
      | RestA_Hack3@gmail.com   | test     | Patient |200|
    
