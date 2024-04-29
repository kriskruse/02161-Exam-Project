Feature: See the distribution of registered hours
  Description: The user tries to see the distribution of registered hours on a project per activity. They get an error if they are not the project lead.
  Actors: User

  Scenario: The user is a project lead for a project with registered time and tries to get hour registration
    Given the user is logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    And the user is the project lead of "Project 1"
    And "Bob" is a registered user of the system
    And "Bob" has hours registered on activity "Activity 1" of the project "Project 1"
    When the user gets hour distribution for project "Project 1"
    Then the distribution of hour registrations is given

  Scenario: The user gets hourdistribution for a project without registered activities
    Given the user is logged into the system
    And a project "Project 1" exists in the system
    And the user is the project lead of "Project 1"
    When the user gets hour distribution for project "Project 1"
    Then the distribution of hour registrations is given

  Scenario: The user is not a project lead and tries to get hour registration
    Given the user is logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    When the user gets hour distribution for project "Project 1"
    Then the error message "User does not have the required permissions to do that" is given