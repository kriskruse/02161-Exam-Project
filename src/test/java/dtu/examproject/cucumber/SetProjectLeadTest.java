package dtu.examproject.cucumber;

import dtu.examproject.main.System;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class SetProjectLeadTest {
    private System system;
    private String admin = "admn";
    private ErrorMessageHolder errorMessage;

    public SetProjectLeadTest(System system, ErrorMessageHolder errorMessage) {
        this.system = system;
        this.errorMessage = errorMessage;
    }

    @When("a user sets {string} as the project lead of {string}")
    public void aUserSetsAsTheProjectLeadOf(String lead, String project) {
        try {
            system.setProjectLead(project, lead);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("{string} is the project lead of {string}")
    public void isTheProjectLeadOf(String lead, String project) {
        assertEquals(system.getProject(project).getProjectLead(), lead);
    }

    @And("a project {string} does not exist in the system")
    public void aProjectDoesNotExistInTheSystem(String project) {
        assertFalse(system.projectExists(project));
    }

    @And("{string} is not a registered user of the system")
    public void isNotARegisteredUserOfTheSystem(String user) {
        assertFalse(system.userExists(user));
    }
}
