Feature: createProject() Systematic Tests - Rasmus ostfeldt
  Description: Systematic tests for the createProject() method, as described in the project report.
  Actors: User

Scenario: User is not logged in
  Given the user is not logged into the system
  When the user creates a project with the name "proj1"
  Then the error message "User is not logged in" is given

Scenario: Project with that name already exist
  Given the user is logged into the system
  And a project "proj1" exist in the system
  When the user creates a project with the name "proj1"
  Then the error message "A project with that name already exists" is given

Scenario: User Creates Project
  Given the user is logged into the system
  And a project "proj1" does not exist in the system
  When the user creates a project with the name "proj1"
  Then a project with the name "proj1" is in the system

Scenario: User Creates Project and other projects also exist
  Given the user is logged into the system
  And a project "proj0" exist in the system
  And a project "proj1" does not exist in the system
  When the user creates a project with the name "proj1"
  Then a project with the name "proj1" is in the system




