Feature: createProject() Systematic Tests - Rasmus ostfeldt
  Description: Systematic tests for the createProject() method, as described in the project report.
  Actors: User

Scenario: User is not logged in
  Given the user is not logged into the system
  When the user creates the project "Proj1"
  Then the error message "User is not logged in" is given

Scenario: Project with that name already exist
  Given the user is logged into the system
  And a project "proj1" already exist in the system
  When the user creates the project "Proj1"
  Then the error message "A project with that name already exists" is given

Scenario: User Creates Project
  Given the user is logged into the system
  And a project "proj1" does not exist in the system
  When the user creates the project "Proj1"
  Then project "Proj1" is created

Scenario: User Creates Project and other projects also exist
  Given the user is logged into the system
  And a project "proj0" already exist in the system
  And a project "proj1" already does not exist in the system
  When the user creates the project "Proj1"
  Then project "Proj1" is created




