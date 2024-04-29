Feature: getAvailableEmployees() Systematic Tests - Simon
  Description: Systematic tests for the getAvailableEmployees() method, as described in the project report.
  Actors: User

  Scenario: User is not logged in
    Given the user is logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    And the user is the project lead of "Project 1"
    And there are employees named "Bob" "Carl" and "Alic" associated with project "Project 1"
    And the employee "Bob" is associated with activity "Vacation" in project "Project 1"
    When the user checks for available employees in project "Project 1"
    Then the employees "Carl" and "Alic" are returned

  Scenario: Project does not exist
    Given the user is logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    And the user is not the project lead of "Project 1"
    And there are employees named "Bob" "Carl" and "Alic" associated with project "Project 1"
    And the employee "Bob" is associated with activity "Activity 1" in project "Project 1"
    When the user checks for available employees in project "Project 1"
    Then the error message "User does not have the required permissions to do that" is given

  Scenario: Week interval has start week after end week
    Given the user is logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    And the user is the project lead of "Project 1"
    And there are employees named "Bob" "Carl" and "Alic" associated with project "Project 1"
    And the employee "Bob" is associated with activity "Vacation" in project "Project 1"
    When the user checks for available employees in project "Project 1"
    Then the employees "Carl" and "Alic" are returned

  Scenario: User is not the project lead
    Given the user is logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    And the user is the project lead of "Project 1"
    And there are employees named "Bob" "Carl" and "Alic" associated with project "Project 1"
    And the employee "Bob" is associated with activity "Vacation" in project "Project 1"
    When the user checks for available employees in project "Project 1"
    Then the employees "Carl" and "Alic" are returned

  Scenario: No activities in project
    Given the user is logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    And the user is not the project lead of "Project 1"
    And there are employees named "Bob" "Carl" and "Alic" associated with project "Project 1"
    And the employee "Bob" is associated with activity "Activity 1" in project "Project 1"
    When the user checks for available employees in project "Project 1"
    Then the error message "User does not have the required permissions to do that" is given

  Scenario: No employees associated with project
    Given the user is logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    And the user is the project lead of "Project 1"
    And there are employees named "Bob" "Carl" and "Alic" associated with project "Project 1"
    And the employee "Bob" is associated with activity "Vacation" in project "Project 1"
    When the user checks for available employees in project "Project 1"
    Then the employees "Carl" and "Alic" are returned

  Scenario: One associated employee with registered hours
    Given the user is logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    And the user is the project lead of "Project 1"
    And there are employees named "Bob" "Carl" and "Alic" associated with project "Project 1"
    And the employee "Bob" is associated with activity "Vacation" in project "Project 1"
    When the user checks for available employees in project "Project 1"
    Then the employees "Carl" and "Alic" are returned

  Scenario: Two employees, one with hours in "Sickness"
    Given the user is logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    And the user is not the project lead of "Project 1"
    And there are employees named "Bob" "Carl" and "Alic" associated with project "Project 1"
    And the employee "Bob" is associated with activity "Activity 1" in project "Project 1"
    When the user checks for available employees in project "Project 1"
    Then the error message "User does not have the required permissions to do that" is given

  Scenario: Two employees, one with hours in "Vacation"
    Given the user is logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    And the user is the project lead of "Project 1"
    And there are employees named "Bob" "Carl" and "Alic" associated with project "Project 1"
    And the employee "Bob" is associated with activity "Vacation" in project "Project 1"
    When the user checks for available employees in project "Project 1"
    Then the employees "Carl" and "Alic" are returned

  Scenario: Three employees, one with no registered hours
    Given the user is logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    And the user is the project lead of "Project 1"
    And there are employees named "Bob" "Carl" and "Alic" associated with project "Project 1"
    And the employee "Bob" is associated with activity "Vacation" in project "Project 1"
    When the user checks for available employees in project "Project 1"
    Then the employees "Carl" and "Alic" are returned

  Scenario: Four associated employees with registered hours,
    Given the user is logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    And the user is not the project lead of "Project 1"
    And there are employees named "Bob" "Carl" and "Alic" associated with project "Project 1"
    And the employee "Bob" is associated with activity "Activity 1" in project "Project 1"
    When the user checks for available employees in project "Project 1"
    Then the error message "User does not have the required permissions to do that" is given

  Scenario: Two employees, one with hours in "Vacation"
    Given the user is logged into the system
    And a project "Project 1" with activity "Activity 1" exists in the system
    And the user is the project lead of "Project 1"
    And there are employees named "Bob" "Carl" and "Alic" associated with project "Project 1"
    And the employee "Bob" is associated with activity "Vacation" in project "Project 1"
    When the user checks for available employees in project "Project 1"
    Then the employees "Carl" and "Alic" are returned