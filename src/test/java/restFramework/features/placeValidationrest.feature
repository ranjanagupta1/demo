Feature: Validating Place API

  Scenario: Verify place is successfully added
    Given add place payload
    When user calls "AddPlaceApi" using POST http request
    Then the API call is success with status 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"