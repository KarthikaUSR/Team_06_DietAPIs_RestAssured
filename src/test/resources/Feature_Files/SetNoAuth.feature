Feature: set no auth
  Scenario: check admin able to create dietician with valid data
    Given admin creates post request with valid data
    When admin send post request with endpoint
    Then admin recieves 401 unauthorized

    #Get All Dietician
  Scenario: check admin able to retireve all dietician
    Given admin create get request
    When admin send get http request with endpoint
    Then admin recieves 401 unauthorized

    #Get Dietician By ID
  Scenario: check admin able to retireve dietician by Id
    Given admin create get request
    When admin send get http request with endpont
    Then admin recieves 401 unauthorized

    #Put Dietician
  Scenario: check admin able to udpate dietician with valid data and dietician id
    Given admin create put request with valid data
    When admin send put http request with endpoint
    Then admin recieves 401 unauthorized

    #Delete Dietician
  Scenario: check admin able to delete dietician by Id
    Given admin create delete reqeust
    When admin send delete reqeust with endpoint
    Then admin recieves 401 unauthorized


