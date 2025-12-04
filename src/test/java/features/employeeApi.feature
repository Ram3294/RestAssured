Feature: Test Employee EndPoints

  Background: 
    Given user add Reuest spec builder with all http request

  Scenario: Create new Employee entity
    Given user add post requestPayload
    When user select post request
    Then user get employee id frome response payload
    And user validate status code  201
		And user validate status line "Created"
    And user validate response time should be below 5000 milliseonds
    And user validate firstname should not be null
    And user validate city should not be null
    And user validate email contains "gmail.com" domain
    And user validate content type header

    Scenario: Retrieve created employee 
    Given user add path parameter
    When user select get request
    Then user validate status code  200
		And user validate status line "HTTP/1.1 200 OK"
    And user validate response time should be below 5000 milliseonds
    And user validate firstname should not be null
    And user validate city should not be null
    And user validate email contains "gmail.com" domain
    And user validate content type header
    
    Scenario: Update employee Entity
    Given user add put requestPayload
    When user add path parameter
    Then user select put request
    Then user get employee id frome response payload
    And user validate status code  200
		And user validate status line "HTTP/1.1 200 OK"
    And user validate response time should be below 5000 milliseonds
    And user validate firstname should not be null
    And user validate city should not be null
    And user validate email contains "gmail.com" domain
    And user validate content type header
    
    Scenario: Delete employee entity
    Given user add path parameter
    When user select delete request
    Then user validate status code  200
		And user validate status line "HTTP/1.1 200 OK"
    And user validate response time should be below 5000 milliseonds