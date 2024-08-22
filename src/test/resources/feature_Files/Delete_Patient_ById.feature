Feature: Delete patient by ID

  Background: 
    Given Set Dietician token
      | D_Email             | D_Password | Role      |
      | apiph2aug@gmail.com | Daisy77    | Dietician |

  
  @Patient
  Scenario: Check dietician able to Delete all patients
  
    Given  Dietician create <Key> request for Delete patient
    When   Dietician send http Delete request with endpoint <Key>
    Then   Dietician recieves <Statuscode> with response body for Delete Patient
    
    Examples: 
    |Key            |Statuscode| 
    |Valid          |200       |
    |InvalidID      |404       |  
    |InvalidMethod  |405       |
    |InvalidEndpoint|404       |
 

  Scenario Outline: Check other roles able to delete patient by ID
    Given <Roles> Set Token with <Email> <Password>
    And <Roles> create Delete requests
    When <Roles> send Delete http requests with endpoint
    Then <Roles> recieves 403 Forbidden for delete patient

    Examples: 
      | Email                 | Password | Roles   |
      | Team6.admin@gmail.com | test     | Admin   |
      | RestA_Hack3@gmail.com  | test     | Patient |
