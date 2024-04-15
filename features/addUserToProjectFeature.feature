Feature: Associate worker with project or activity
  Description:
  Actors: User

  Scenario: The user associates a user with a project activity
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

  Scenario: The user associates a user with a project activity
    Given the user is not logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    And "Bob" is a registered user of the system
    When the user associates "Bob" with "Project 1"
    Then the error message "User is not logged in" is given

  Scenario: The user associates a user with a project activity
    Given the user is not logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    And "Bob" is a registered user of the system
    When the user associates "Bob" to project "Project 1"'s activity "Activity 1"
    Then the error message "User is not logged in" is given