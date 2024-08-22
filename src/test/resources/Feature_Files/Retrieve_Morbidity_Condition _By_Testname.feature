Feature: Retrieve Morbidity Condition By Test name

  Background: 
    Given Set Admin Token
      | A_Email               | A_Password | Role      |
      | Team6.admin@gmail.com | test       | Dietician |

  @Patient
  Scenario Outline: Check user able to retrieve morbidity condition by test name
    Given <Roles> Set Token with <Email> <Password>
    And <Roles> create GET request
    #When <Roles> send GET http request with endpoint
    Then <Roles> recieves 200 ok with details

    Examples: 
      | Email                 | Password | Roles     |
      | Team6.admin@gmail.com | test     | Admin     |
      | APIDIET1234@gmail.com | Light21  | Dietician |

  @Patient
  Scenario Outline: Check user able to retrieve morbidity condition by test name  with invalid method
    Given <Roles> Set Token with <Email> <Password>

    #And <Roles> create POST request
    #When <Roles> send POST http request with endpoint
    #Then <Roles> recieves 405 method not allowed
    Examples: 
      | Email                 | Password | Roles     |
      | Team6.admin@gmail.com | test     | Admin     |
      | APIDIET1234@gmail.com | Light21  | Dietician |

  @Patient
  Scenario Outline: Check user able to retrieve morbidity condition by invalid test name
    Given <Roles> Set Token with <Email> <Password>
    And <Roles> create GET request

    #When <Roles> send GET http request with endpoint
    #Then <Roles> recieves 404 not found
    Examples: 
      | Email                 | Password | Roles     |
      | Team6.admin@gmail.com | test     | Admin     |
      | APIDIET1234@gmail.com | Light21  | Dietician |

  @Patient
  Scenario Outline: Check user able to retrieve morbidity condition by test name with invalid endpoint
    Given <Roles> Set Token with <Email> <Password>
    And <Roles> create GET request

    #When <Roles> send GET http request with endpoint
    #Then <Roles> recieves 404 not found
    Examples: 
      | Email                 | Password | Roles     |
      | Team6.admin@gmail.com | test     | Admin     |
      | APIDIET1234@gmail.com | Light21  | Dietician |

  @Patient
  Scenario Outline: Check pateint is able to retrieve morbidity condition by test name
    Given <Roles> Set Token with <Email> <Password>

    #And <Roles> Patient create GET request
    #When <Roles> Patient send GET http request with endpoint
    #Then <Roles> rPatient recieves 403 Forbidden
    Examples: 
      | Email                | Password | Roles   |
      | dietapi434@gmail.com | test     | Patient |

  @Patient
  Scenario Outline: Check dietician able to morbidity condition by test name
    Given Set no auth
    And Dietician create GET request

    #When  Dietician send GET http request with endpoint
    #Then Dietician recieves 401 unauthorized
    Examples: 
      | Email | Password | Roles |
      |       |          |       |
