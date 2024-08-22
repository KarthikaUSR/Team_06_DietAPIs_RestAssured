Feature: Get patient by ID

  Background: 
    Given Set Dietician token
      | D_Email             | D_Password | Role      |
      | apiph2aug@gmail.com | Daisy77    | Dietician |

  @Patient
  
  Scenario: Check dietician able to retrieve patients by field
  
    Given  Dietician create <Key> request for retrieve patients by field
    When   Dietician send http request for retrieve patients by field with endpoint <Key>
    Then   Dietician recieves <Statuscode> with response body for retrieve patients by field
    
    Examples: 
    |Key            |Statuscode| 
    |ValidFileID    |200       |
    |InvalidFileID  |404       |  
    |InvalidMethod  |405       |
    |InvalidEndpoint|404       |
  
 
 
    Scenario Outline: Check other roles able to get patient by ID
    Given <Roles> Set Token with <Email> <Password>
    And <Roles> create Get requests to get patient by ID
    When <Roles> send Get http requests to get patient by ID with endpoint
    Then <Roles> recieves <Statuscode> Forbidden for getting patient by ID

    Examples: 
      | Email                 | Password | Roles   |Statuscode|
      | Team6.admin@gmail.com | test     | Admin   |403|
      | RestA_Hack3@gmail.com | test     | Patient |200|
    
