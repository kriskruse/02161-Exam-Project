Feature: Set/edit Activity time used
  Description: User set time used for an activity
  Actors: User

  Scenario: The project does not exist
    Given the user is logged into the system
    When the user sets their hours spent today on activity "Activity 1" for project "Project 1" to 20 hours
    Then the error message "Project does not exist" is given

  Scenario: Set time used
    Given the user is logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    When the user sets their hours spent today on activity "Activity 1" for project "Project 1" to 20 hours
    Then 20 hours are registered on activity "Activity 1" for project "Project 1"

  Scenario: Set time used with existing registration
    Given the user is logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    And the user is a member of project "Project 1" and activity "Activity 1"
    And the user sets their hours spent today on activity "Activity 1" for project "Project 1" to 10.5 hours
    When the user sets their hours spent today on activity "Activity 1" for project "Project 1" to 20.5 hours
    Then 20.5 hours are registered on activity "Activity 1" for project "Project 1"

  Scenario: set time used for an activity that does not exist.
    Given the user is logged into the system
    And a project "Project 1" exist in the system
    And the activity "Activity 1" does not exist for "Project 1"
    When the user sets their hours spent today on activity "Activity 1" for project "Project 1" to 20 hours
    Then the error message "Activity does not exist" is given

  Scenario: A not logged-on user sets the activity time used.
    Given the user is not logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    When the user sets their hours spent today on activity "Activity 1" for project "Project 1" to 20 hours
    Then the error message "User is not logged in" is given

  Scenario: Employee not associated with activity
    Given the user is logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    And the project "Project 1" has the activity "shitfest"
    And the user is a member of project "Project 1" and activity "shitfest"
    When the user sets their hours spent today on activity "Activity 1" for project "Project 1" to 20 hours
    Then the error message "Employee is not associated with this activity" is given

  Scenario: Employee does not exist
    Given the user is logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    When the user sets "jack" to have hours spent today on activity "Activity 1" for project "Project 1" equal to 20 hours
    Then the error message "User does not exist" is given

  Scenario: alot of registrations
    Given the user is logged into the system
    And a project "Project 1" with activity "test1" exists in the system
    And the user is a member of project "Project 1" and activity "test1"
    And the employee "jack" is associated with activity "test1" in project "Project 1"
    And the employee "mark" is associated with activity "test1" in project "Project 1"
    And the employee "eddy" is associated with activity "test1" in project "Project 1"
    And "jack" has 20 hours registered in week 15 on activity "test1" of the project "Project 1"
    And "mark" has 10 hours registered in week 16 on activity "test1" of the project "Project 1"
    And "eddy" has 0 hours registered in week 13 on activity "test1" of the project "Project 1"
    And the user sets their hours spent today on activity "test1" for project "Project 1" to 10.5 hours
    When the user sets their hours spent today on activity "test1" for project "Project 1" to 20.5 hours
    Then 20.5 hours are registered on activity "test1" for project "Project 1"
