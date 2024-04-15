package dtu.examproject.cucumber;

import static org.junit.jupiter.api.Assertions.*;

import dtu.examproject.main.System;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AddUserTest {

    private System system;
    private String dummyUser = "dumy";
    private String admin = "admn";
    private ErrorMessageHolder errorMessage;

    public AddUserTest(System system, ErrorMessageHolder errorMessage) {
        this.system = system;
        this.errorMessage = errorMessage;
    }


    @Given("the user is logged into the system")
    public void theUserIsLoggedIntoTheSystem() throws Exception{
        try{
            system.login(admin);
        } catch (Exception e){
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @When("the user registers the user {string}")
    public void theUserRegistersTheUser(String user) throws Exception {
        try {
            system.addUser(user);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("the user {string} is registered")
    public void theUserIsRegistered(String user) {
        assertTrue(system.userExists(user));
    }

    @And("a user with the initials {string} exists in the system")
    public void aUserWithTheInitialsExistsInTheSystem(String user) throws Exception {
        try {
            system.addUser(user);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }


    @Then("the error message {string} is given")
    public void theErrorMessageIsGiven(String error) {
        assertEquals(error, this.errorMessage.getErrorMessage());

    }

    @Given("the user is not logged into the system")
    public void theUserIsNotLoggedIntoTheSystem() {
        system.logout();
    }


}
