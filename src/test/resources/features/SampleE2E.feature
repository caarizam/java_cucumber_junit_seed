Feature: Examples feature

  @e2e
  Scenario: example scenario
    Given The user is on the Home Page
    When The user enters the credentials "example.user@yopmail.com" and "123456"
    Then The user should see the Welcome Page