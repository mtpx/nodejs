Feature: UserEmployee should be able to add or remove expert to/from application

  Scenario: Adding an expert to application
    Given UserEmployee finds application with status formal evaluation accepted
    When UserEmployee adds expert to application
    #Then UserExpert is added to application

  Scenario: Removing an expert from application
    #Given UserEmployee is on permissions page of application with added expert
    #When UserEmployee removes expert from application
    Then UserExpert was removed from application