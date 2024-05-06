Feature: Associate worker with project or activity
  Description:
  Actors: User

  Scenario: user is not logged in
    Given the user is not logged into the system
    When the user tries to associate a user with a project
    Then the error message "User is not logged in" is given

  Scenario: Project does not exist
    Given the user is logged into the system
    And "Bob" is a registered user of the system
    When the user associates "Bob" with "Project 1"
    Then the error message "Project does not exist" is given

  Scenario: User does not exist when added to project
    Given the user is logged into the system
    And a project "Project 1" exists in the system
    When the user associates "Bob" with "Project 1"
    Then the error message "User does not exist" is given

  Scenario: The user associates a user with a project
    Given the user is logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    And "Bob" is a registered user of the system
    When the user associates "Bob" with "Project 1"
    Then "Bob" is associated with project "Project 1"

  Scenario: The user associates a user with a project activity
    Given the user is logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    And "Bob" is a registered user of the system
    When the user associates "Bob" to project "Project 1"'s activity "Activity 1"
    Then "Bob" is associated with project "Project 1"'s activity "Activity 1"

  Scenario: The user associates a user with a project
    Given the user is not logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    And "Bob" is a registered user of the system
    When the user associates "Bob" with "Project 1"
    Then the error message "User is not logged in" is given

  Scenario: The user is not logged in and tries to associate a user with a project activity
    Given the user is not logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    And "Bob" is a registered user of the system
    When the user associates "Bob" to project "Project 1"'s activity "Activity 1"
    Then the error message "User is not logged in" is given

  Scenario: The user associates a nonexistent user to a project
    Given the user is logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    When the user associates "Bob" to project "Project 1"'s activity "Activity 1"
    Then the error message "User does not exist" is given

  Scenario: The user associates a user to a project that does not exist
    Given the user is logged into the system
    And "Bob" is a registered user of the system
    When the user associates "Bob" to project "Project 1"'s activity "Activity 1"
    Then the error message "Project does not exist" is given

  Scenario: Add user to activity that does not exist
    Given the user is logged into the system
    And a project "Project 1" exists in the system
    And "Bob" is a registered user of the system
    When the user associates "Bob" to project "Project 1"'s activity "Activity 1"
    Then the error message "Activity does not exist" is given