package dtu.examproject.cucumber;

import static org.junit.jupiter.api.Assertions.*;

import dtu.examproject.main.TimeRegistration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AddUserTest {

    private TimeRegistration timeRegistration;
    private String dummyUser = "dumy";
    private String admin = "admn";
    private ErrorMessageHolder errorMessage;

    public AddUserTest(TimeRegistration timeRegistration, ErrorMessageHolder errorMessage) {
        this.timeRegistration = timeRegistration;
        this.errorMessage = errorMessage;
    }


    @Given("the user is logged into the system")
    public void theUserIsLoggedIntoTheSystem() throws Exception{
        try{
            timeRegistration.login(admin);
        } catch (Exception e){
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @When("the user registers the user {string}")
    public void theUserRegistersTheUser(String user) throws Exception {
        try {
            timeRegistration.addUser(user);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("the user {string} is registered")
    public void theUserIsRegistered(String user) {
        assertTrue(timeRegistration.userExists(user));
    }

    @And("a user with the initials {string} exists in the system")
    public void aUserWithTheInitialsExistsInTheSystem(String user) throws Exception {
        try {
            timeRegistration.addUser(user);
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
        timeRegistration.logout();
    }


    @When("{string} logs into the system")
    public void logsIntoTheSystem(String user) {
        try {
            timeRegistration.login(user);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("{string} is logged into the system")
    public void isLoggedIntoTheSystem(String user) {
        assertEquals(user, timeRegistration.getActiveUser());
    }
}
