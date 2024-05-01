Feature: See available users
  Description: The project leader checks which workers are available
  Actors: User

  Scenario: The project leader attempts to see available employees
    Given the user is logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    And the employee "Bob" is associated with activity "Vacation" in project "Project 1"
    And the employee "Carl" is associated with activity "Sickness" in project "Project 1"
    And the employee "Alic" is associated with activity "Activity 1" in project "Project 1"
    And the user is the project lead of "Project 1"
    And "Bob" has 20 hours registered in week 15 on activity "Vacation" of the project "Project 1"
    And "Carl" has 20 hours registered in week 15 on activity "Sickness" of the project "Project 1"
    And "Alic" has 20 hours registered in week 15 on activity "Activity 1" of the project "Project 1"
    When the user checks for employees between week 0 and 52 in project "Project 1"
    Then "Alic" with 20 hours is returned

  Scenario: Someone other than the leader attempts to get available employees
    Given the user is logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    And the employee "Bob" is associated with activity "Vacation" in project "Project 1"
    And the employee "Carl" is associated with activity "Sickness" in project "Project 1"
    And the employee "Alic" is associated with activity "Activity 1" in project "Project 1"
    And the user is not the project lead of "Project 1"
    And "Bob" has 20 hours registered in week 15 on activity "Vacation" of the project "Project 1"
    And "Carl" has 20 hours registered in week 15 on activity "Sickness" of the project "Project 1"
    And "Alic" has 20 hours registered in week 15 on activity "Activity 1" of the project "Project 1"
    When the user checks for employees between week 0 and 52 in project "Project 1"
    Then the error message "User does not have the required permissions to do that" is given