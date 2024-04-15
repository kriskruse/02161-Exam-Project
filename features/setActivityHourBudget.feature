Feature: Set activity hour budget
  Description: The project leader sets the hour budget for an activity
  Actors: User

  Scenario: Set activity hour budget successfully
    Given that the user is logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    And the user is the project lead of project "Project 1"
    When the user sets the hour budget as "20" for activity "Activity 1" in the project "Project 1"
    Then hour budget for activity "Activity 1" in project "Project 1" is set to "20"

  Scenario: Set an activity hour budget for an activity in a project that does not exist
    Given that the user is logged into the system
    And the Project does not exist
    When the user sets the hour budget as "20" for activity "Activity 1" in the project "Project 1"
    Then the error message "Project does not exist" is given.

  Scenario: Set activity hour budget when not project lead
    Given that the user is logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    When the user sets the hour budget as "20" for activity "Activity 1" in the project "Project 1"
    Then the error "User does not have the required permissions to do that" is given

  Scenario: Set activity hour budget when not logged in
    Given that the user is not logged into the system
    When the user sets the hour budget as "20" for activity "Activity 1" in the project "Project 1"
    Then the error message "user not logged in" is given.