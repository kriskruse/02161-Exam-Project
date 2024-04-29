Feature: getAvailableEmployees() Systematic Tests - Simon
  Description: Systematic tests for the getAvailableEmployees() method, as described in the project report.
  Actors: User

  Scenario: User is not logged in
    Given the user is not logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    When the user checks for employees between week 20 and 10 in project "Project 1"
    Then the error message "User does not have the required permissions to do that" is given

  Scenario: Project does not exist
    Given the user is logged into the system
    When the user checks for employees between week 20 and 10 in project "Project 1"
    Then the error message "User does not have the required permissions to do that" is given

  Scenario: Week interval has start week after end week
    Given the user is logged into the system
    And a project "Project 1" exists in the system
    When the user checks for employees between week 20 and 10 in project "Project 1"
    Then the error message "User does not have the required permissions to do that" is given

  Scenario: User is not the project lead
    Given the user is logged into the system
    And a project "Project 1" exists in the system
    When the user checks for employees between week 10 and 20 in project "Project 1"
    Then the error message "User does not have the required permissions to do that" is given

  Scenario: No activities in project
    Given the user is logged into the system
    And a project "Project 1" exists in the system
    And the user is the project lead of "Project 1"
    When the user checks for employees between week 10 and 20 in project "Project 1"
    Then the error message "User does not have the required permissions to do that" is given

  Scenario: No employees associated with project
    Given the user is logged into the system
    And a project "Project 1" with activity "test" exists in the system
    And the user is the project lead of "Project 1"
    When the user checks for employees between week 10 and 20 in project "Project 1"
    Then the error message "User does not have the required permissions to do that" is given

  Scenario: One associated employee with registered hours
    Given the user is logged into the system
    And a project "Project 1" with activity "test" exists in the system
    And the user is the project lead of "Project 1"
    And "jack" has 20 hours registered in week 15 on activity "test" of the project "Project 1"
    When the user checks for employees between week 10 and 20 in project "Project 1"
    Then "jack" with 20 hours is returned

  Scenario: Two employees, one with hours in "Sickness"
    Given the user is logged into the system
    And a project "Project 1" with activity "test" exists in the system
    And the user is the project lead of "Project 1"
    And "jack" has 20 hours registered in week 15 on activity "Sickness" of the project "Project 1"
    And "mark" has 20 hours registered in week 15 on activity "test" of the project "Project 1"
    When the user checks for employees between week 10 and 20 in project "Project 1"
    Then "mark" with 20 hours is returned

  Scenario: Two employees, one with hours in "Vacation"
    Given the user is logged into the system
    And a project "Project 1" with activity "test" exists in the system
    And the user is the project lead of "Project 1"
    And "jack" has 20 hours registered in week 15 on activity "test" of the project "Project 1"
    And "mark" has 20 hours registered in week 15 on activity "Vacation" of the project "Project 1"
    When the user checks for employees between week 10 and 20 in project "Project 1"
    Then "jack" with 20 hours is returned

  Scenario: Three employees, one with no registered hours
    Given the user is logged into the system
    And a project "Project 1" with activity "test1" exists in the system
    And project "Project 1" has activity "test2"
    And the user is the project lead of "Project 1"
    And "jack" has 20 hours registered in week 15 on activity "test1" of the project "Project 1"
    And "mark" has 10 hours registered in week 15 on activity "test2" of the project "Project 1"
    And "eddy" has 0 hours registered in week 15 on activity "test2" of the project "Project 1"
    When the user checks for employees between week 10 and 20 in project "Project 1"
    Then "eddy" with 0 hours, then "mark" with 10 hours, and then "jack" with 20 hours is returned

  Scenario: Four associated employees with registered hours, one with hours outside the given week interval
    Given the user is logged into the system
    And a project "Project 1" with activity "test1" exists in the system
    And project "Project 1" has activity "test2"
    And project "Project 1" has activity "test3"
    And the user is the project lead of "Project 1"
    And "jack" has 20 hours registered in week 12 on activity "test1" of the project "Project 1"
    And "mark" has 10 hours registered in week 5 on activity "test2" of the project "Project 1"
    And "eddy" has 30 hours registered in week 17 on activity "test1" of the project "Project 1"
    And "cody" has 15 hours registered in week 15 on activity "test3" of the project "Project 1"
    When the user checks for employees between week 10 and 20 in project "Project 1"
    Then "cody" with 15 hours, then "jack" with 20 hours, and then "eddy" with 30 hours is returned
