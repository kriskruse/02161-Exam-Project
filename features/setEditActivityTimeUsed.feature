Feature: Set/edit Activity time used
  Description: User set time used for an activity
  Actors: User

  Scenario: Set time used
    Given the user is logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    When the user sets their hours spent on activity "Activity 1" to "20" hours
    Then "20" hours are registered on activity "Activity 1".

  Scenario: Set time used with existing registration
    Given the user is logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    And the user sets their hours spent on activity "Activity 1" to "10" hours
    When the user sets their hours spent on activity "Activity 1" to "20" hours
    Then "20" hours are registered on activity "Activity 1".

  Scenario: set time used for an activity that does not exist.
    Given the user is logged into the system
    And a project "Project 1" exist in the system
    And the activity "Activity 1" does not exist for "Project 1".
    Then the error message "Activity does not exist" is given

  Scenario: A not logged-on user sets the activity time used.
    Given the user is not logged into the system
    When the user sets their hours spent on activity "Activity 1" to "20" hours
    Then the error message "user not logged in" is given