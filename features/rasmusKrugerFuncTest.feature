Feature: getRegisteredTime() Systematic Tests - Rasmus Kruger
 Description: Systematic tests for the Get registered time() method, as described in the project report.
  Actors: User

#1
Scenario: User is not logged in
    Given the user is not logged into the system
    When the user requests their registered time
    Then the error message "User is not logged in" is given


#2
Scenario: User does not exist
    Given the user is logged into the system
    When the user requests the user "bob" registered time
    Then the error message "User does not exist" is given

#3
Scenario: User gets 0 registered time
    Given the user is logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    And the user is a member of project "Project 1" and activity "Activity 1"
    When the user requests their registered time
    Then 0 hours is returned
#4
Scenario: User gets their registered time
    Given the user is logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    And the user is a member of project "Project 1" and activity "Activity 1"
    And the user sets their hours spent today on activity "Activity 1" for project "Project 1" to 10 hours
    When the user requests their registered time
    Then 10 hours is returned

#5
Scenario: User gets their registered time
    Given the user is logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    And a project "Project 2" with activity "Activity 2" exists in the system
    And the project "Project 2" has the activity "Activity 3"
    And the user is a member of project "Project 1" and activity "Activity 1"
    And the user is a member of project "Project 2" and activity "Activity 2"
    And the user is a member of project "Project 2" and activity "Activity 3"
    And the user sets their hours spent today on activity "Activity 1" for project "Project 1" to 10 hours
    And the user sets their hours spent today on activity "Activity 2" for project "Project 2" to 10 hours
    And the user sets their hours spent today on activity "Activity 3" for project "Project 2" to 8 hours
    When the user requests their registered time
    Then 28 hours is returned

#6
Scenario: User gets their registered time
    Given the user is logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    And a project "Project 2" with activity "Activity 2" exists in the system
    And the project "Project 2" has the activity "Activity 3"
    And a project "Project 3" with activity "Activity 4" exists in the system
    And the user is a member of project "Project 1" and activity "Activity 1"
    And the user is a member of project "Project 2" and activity "Activity 2"
    And the user is a member of project "Project 2" and activity "Activity 3"
    And the user is a member of project "Project 3" and activity "Activity 4"
    And the user sets their hours spent today on activity "Activity 1" for project "Project 1" to 10 hours
    And the user sets their hours spent today on activity "Activity 2" for project "Project 2" to 10 hours
    And the user sets their hours spent today on activity "Activity 3" for project "Project 2" to 8 hours
    And the user sets their hours spent today on activity "Activity 4" for project "Project 3" to 9 hours
    When the user requests their registered time
    Then 37 hours is returned
