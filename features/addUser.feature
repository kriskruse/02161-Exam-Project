Feature: Add user to system
  Description: a user adds a new user to the system
  Actors: User

  Scenario: Add user successfully
    Given the user is logged into the system
    When the user registers the user "Bob"
    Then the user "Bob" is registered

  Scenario: Register a user that is already registered
    Given the user is logged into the system
    And a user with the initials "Bob" exists in the system
    When the user registers the user "Bob"
    Then the error message "A user with those initials already exists" is given

  Scenario: Register a user when not logged in
    Given the user is not logged into the system
    When the user registers the user "Bob"
    Then the error message "User is not logged in" is given
