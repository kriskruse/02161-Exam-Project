package dtu.examproject.cucumber;

import dtu.examproject.main.System;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SetProjectActivitiesTest {
    private System system;
    private String admin = "admn";
    private ErrorMessageHolder errorMessage;

    public SetProjectActivitiesTest(System system, ErrorMessageHolder errorMessage) {
        this.system = system;
        this.errorMessage = errorMessage;
    }

    @When("the user creates the activity {string} in the project {string}")
    public void theUserCreatesTheActivityInTheProject(String activity, String project) {
        try {
            system.createActivity(project, activity);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("project {string} has the activity {string}")
    public void projectHasTheActivity(String project, String activity) {
        assert system.getProject(project).activityExists(activity);
    }

    @And("project {string} has no project lead")
    public void projectHasNoProjectLead(String project) {
        try {
            system.setProjectLead(project, "");
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @And("{string} is the project lead of project {string}")
    public void isTheProjectLeadOfProject(String lead, String project) {
        try {
            system.setProjectLead(project, lead);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }
}
