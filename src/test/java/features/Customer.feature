Feature: Test All Customer Endpoints

  Background: 
    Given user add request Spec builder to http request

  Scenario: Create Customer Entity
    Given user add request payload
    When user select a post request
    Then user capture id frome response Payload
    And user validate a status code 201
    And user validate a status line "Created"
    And user validate a content type header

 