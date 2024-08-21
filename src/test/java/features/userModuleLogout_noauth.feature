Feature: LOGOUT [GET Operation]


Scenario: N-Check admin able to logout
    Given User creates GET request for admin
    When User send GET HTTP request with endpoint for admin
    Then admin recieves 405 unauthorized

  Scenario: N-Check dietician able to logout
    Given User creates GET request for dietician
    When User send GET HTTP request with endpoint for dietician
    Then dietecian recieves 401 unauthorized

  Scenario: N-Check patient able to logout
    Given User creates GET request for patient
    When User send GET HTTP request with endpoint for patient
    Then patient recieves 401 unauthorized

