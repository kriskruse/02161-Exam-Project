Feature: Set project lead
  Description: Set the project lead for a project
  Actors: User

  Scenario: Add a project lead successfully
    Given the user is logged into the system
    And a project "Project 1" exist in the system
    And "Bob" is a registered user of the system
    When a user sets "Bob" as the project lead of "Project 1"
    Then "Bob" is the project lead of "Project 1"

  Scenario: Add a project lead when the user is not logged in
    Given the user is not logged into the system
    And a project "Project 1" exist in the system
    And "Bob" is a registered user of the system
    When a user sets "Bob" as the project lead of "Project 1"
    Then the error message "User not logged in" is given

  Scenario: Add a project lead when the project does not exist
    Given the user is logged into the system
    And a project "Project 1" does not exist in the system
    And "Bob" is a registered user of the system
    When a user sets "Bob" as the project lead of "Project 1"
    Then the error message "Project does not exist" is given

  Scenario: Add a project lead when the Employee is not registered
    Given the user is logged into the system
    And a project "Project 1" does not exist in the system
    And "Bob" is not a registered user of the system
    When a user sets "Bob" as the project lead of "Project 1"
    Then the error message "Bob is not a registered user of the system" is given