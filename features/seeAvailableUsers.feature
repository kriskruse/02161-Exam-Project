Feature: See available users
  Description: The project leader checks which workers are available
  Actors: User

  Scenario: The project leader attempts to see available employees
    Given the user is logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    And the user is the project lead of "Project 1"
    And there are employees named "Bob" "Carl" and "Alic" associated with project "Project 1"
    And the employee "Bob" is associated with activity "Vacation" in project "Project 1"
    When the user checks for available employees in project "Project 1"
    Then the employees "Carl" and "Alic" are returned

  Scenario: Someone other than the leader attempts to get available employees
    Given the user is logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    And the user is not the project lead of "Project 1"
    And there are employees named "Bob" "Carl" and "Alic" associated with project "Project 1"
    And the employee "Bob" is associated with activity "Activity 1" in project "Project 1"
    When the user checks for available employees in project "Project 1"
    Then the error message "User does not have the required permissions to do that" is given