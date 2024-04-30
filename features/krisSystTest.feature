Feature: createActivity() Systematic Tests - Kris
  Description: Systematic tests for the createActivity() method, as described in the project report.
  Actors: User

#A
Scenario: User is not logged in
  Given the user is not logged into the system
  When the user creates the activity "Act1" in the project "Proj1"
  Then the error message "User is not logged in" is given
#B
Scenario: Project does not exist
  Given the user is logged into the system
  When the user creates the activity "Act1" in the project "Proj1"
  Then the error message "Project does not exist" is given
#Ca
Scenario: There is no project lead and the user tries to create activity which already exists
  Given the user is logged into the system
  And a project "Proj1" with activity "Act1" exists in the system
  And project "Proj1" has no project lead
  When the user creates the activity "Act1" in the project "Proj1"
  Then the error message "Activity already exists" is given
#Cb
Scenario: There is no project lead and the user tries to create activities for a project
  Given the user is logged into the system
  And a project "Proj1" exist in the system
  And project "Proj1" has no project lead
  When the user creates the activity "Act1" in the project "Proj1"
  Then project "Proj1" has the activity "Act1"
#D
Scenario: The user is not the project lead and tries to create activities for a project
  Given the user is logged into the system
  And a project "Project 1" exist in the system
  And a user with the initials "Bob" exists in the system
  And "Bob" is the project lead of project "Project 1"
  When the user creates the activity "Activity 1" in the project "Project 1"
  Then the error message "User does not have the required permissions to do that" is given

#Ea
Scenario: There is project lead and the user tries to create activity which already exists
  Given the user is logged into the system
  And a project "Proj1" with activity "Act1" exists in the system
  And the user is the project lead of project "Proj1"
  When the user creates the activity "Act1" in the project "Proj1"
  Then the error message "Activity already exists" is given

#Eb
Scenario: There is project lead and the user tries to create activity
  Given the user is logged into the system
  And a project "Proj1" exist in the system
  And the user is the project lead of project "Proj1"
  When the user creates the activity "Act1" in the project "Proj1"
  Then project "Proj1" has the activity "Act1"