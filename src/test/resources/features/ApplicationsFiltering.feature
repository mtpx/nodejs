Feature: UserEmployee should be able to filter applications by signature

  Scenario: Filtering applications by signature
    Given UserEmployee is on applications list
    When UserEmployee filter random application by signature
    Then application is filtered