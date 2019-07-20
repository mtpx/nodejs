Feature: User should be able to login on his account

  Background:
    Given user is on login page programs

  Scenario: Login to programs with invalid credentials
    When he enters invalid credentials to programs
    Then he isnt logged in programs

  Scenario: Login to programs with valid credentials
    When he enters valid credentials to programs
    Then he is logged in programs



