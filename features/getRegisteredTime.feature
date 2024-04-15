Feature: Get registered time
  Description: Get the registered time for a worker
  Actors: User

  Scenario: User gets their registered time
    Given the user is logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    And a project "Project 2" with activity "Activity 2" exists in the system
    And the user sets their hours spent on activity "Activity 1" to "5" hours in the project "Project 1"
    And the user sets their hours spent on activity "Activity 2" to "5" hours in the project "Project 2"
    When the user requests their registered time
    Then "10" hours is returned

  Scenario: The user tries to get their registered time when the user is not logged in
    Given that the user is not logged into the system
    When the user requests the registered time
    Then the error message "user not logged in" is given