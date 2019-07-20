Feature: UserEmployee should be able to filter documents by signature

  Scenario: Filtering documents by signature
    Given UserEmployee is on documents list
    When UserEmployee filter random document by signature
    Then documents is filtered