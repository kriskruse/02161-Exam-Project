package dtu.examproject.cucumber;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddUserTest {

    @Given("the user is logged into the system")
    public void theUserIsLoggedIntoTheSystem() {
    }

    @And("there is a user with the initials {string}")
    public void thereIsAUserWithTheInitials(String arg0) {
    }

    @When("the user registers the user")
    public void theUserRegistersTheUser() {
        
    }

    @Then("the user is registered")
    public void theUserIsRegistered() {
    }

    @And("a user with the initials {string} exists in the system")
    public void aUserWithTheInitialsExistsInTheSystem(String arg0) {
    }

    @When("the user registers the user again")
    public void theUserRegistersTheUserAgain() {
    }

    @Then("the error message {string} is given")
    public void theErrorMessageIsGiven(String arg0) {
    }

    @Given("the user is not logged into the system")
    public void theUserIsNotLoggedIntoTheSystem() {
    }
}
