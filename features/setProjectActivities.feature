Feature: Set the activities of a project
  Description: The user tries to create project activities, either as a project lead or employee if there is no project lead, else they will get an error.
  Actors: User

  Scenario: The user is the project lead and tries to create activities for a project
    Given the user is logged into the system
    And a project "Project 1" exist in the system
    And the user is the project lead of "Project 1"
    When the user creates the activity "Activity 1" in the project "Project 1"
    Then project "Project 1" has the activity "Activity 1"

  Scenario: There is no project lead and the user tries to create activities for a project
    Given the user is logged into the system
    And a project "Project 1" exist in the system
    And project "Project 1" has no project lead
    When the user creates the activity "Activity 1" in the project "Project 1"
    Then project "Project 1" has the activity "Activity 1"

  Scenario: The user is not the project lead and tries to create activities for a project
    Given the user is logged into the system
    And a project "Project 1" exist in the system
    And "Bob" is the project lead of project "Project 1"
    When the user creates the activity "Activity 1" in the project "Project 1"
    Then the error "User does not have the required permissions to do that" is given