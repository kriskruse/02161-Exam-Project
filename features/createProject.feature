Feature: Create a project
  Description: The user creates a project for the system
  Actors: User

  Scenario: Add a project successfully
    Given the user is logged into the system
    When the user creates a project with the name "Project1"
    Then a project with the name "Project1" is in the system

  Scenario: A not logged in user tries to create a project
    Given the user is not logged into the system
    When the user creates a project with the name "Project1"
    Then the error message "User is not logged in" is given

  Scenario: Get all projects
    Given the user is logged into the system
    And a project with the name "Project1" is in the system
    And a project with the name "Project2" is in the system
    When the user requests all projects
    Then projects "Project1" and "Project2" are returned