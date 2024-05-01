package dtu.examproject.cucumber;

import dtu.examproject.main.TimeRegistration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class SetProjectLeadTest {
    private TimeRegistration timeRegistration;
    private String admin = "admn";
    private ErrorMessageHolder errorMessage;

    public SetProjectLeadTest(TimeRegistration timeRegistration, ErrorMessageHolder errorMessage) {
        this.timeRegistration = timeRegistration;
        this.errorMessage = errorMessage;
    }

    @When("a user sets {string} as the project lead of {string}")
    public void aUserSetsAsTheProjectLeadOf(String lead, String project) {
        try {
            timeRegistration.setProjectLead(project, lead);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @And("the user is the project lead of {string}")
    public void theUserIsTheProjectLeadOf(String project) {
        try {
            timeRegistration.setProjectLead(project, admin);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("{string} is the project lead of {string}")
    public void isTheProjectLeadOf(String lead, String project) {
        assertEquals(timeRegistration.getProject(project).getProjectLead(), lead);
    }

    @And("a project {string} does not exist in the system")
    public void aProjectDoesNotExistInTheSystem(String project) {
        assertFalse(timeRegistration.projectExists(project));
    }

    @And("{string} is not a registered user of the system")
    public void isNotARegisteredUserOfTheSystem(String user) {
        assertFalse(timeRegistration.userExists(user));
    }
}
