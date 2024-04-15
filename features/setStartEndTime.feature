Feature: Set the start/end time of an activity
  Description: The user tries to set a project activity's start and end date by week number. They get an error if they are not the project lead.
  Actors: User

  Scenario: The user is a project lead and tries to set start/end time
    Given the user is logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    And the user is the project lead of "Project 1"
    When the user sets the start time to week "10" and end time to week "12" for activity "Activity 1"
    Then the activity "Activity 1" has week "10" as the start time and week "12" as the end time

  Scenario: The user is not the project lead and tries to set a start/end time
    Given the user is logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    When the user sets the start time to week "10" and end time to week "12" for activity "Activity 1"
    Then the error "User does not have the required permissions to do that" is given