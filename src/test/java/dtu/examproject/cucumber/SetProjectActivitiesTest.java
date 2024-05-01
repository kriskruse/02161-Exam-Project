package dtu.examproject.cucumber;

import dtu.examproject.main.TimeRegistration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class SetProjectActivitiesTest {
    private TimeRegistration timeRegistration;
    private String admin = "admn";
    private ErrorMessageHolder errorMessage;

    public SetProjectActivitiesTest(TimeRegistration timeRegistration, ErrorMessageHolder errorMessage) {
        this.timeRegistration = timeRegistration;
        this.errorMessage = errorMessage;
    }

    @When("the user creates the activity {string} in the project {string}")
    public void theUserCreatesTheActivityInTheProject(String activity, String project) {
        try {
            timeRegistration.createActivity(project, activity);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("project {string} has the activity {string}")
    public void projectHasTheActivity(String project, String activity) {
        assertTrue(timeRegistration.getProject(project).activityExists(activity));
    }

    @And("project {string} has no project lead")
    public void projectHasNoProjectLead(String project) {
        try {
            timeRegistration.setProjectLead(project, "");
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @And("{string} is the project lead of project {string}")
    public void isTheProjectLeadOfProject(String lead, String project) {
        try {
            timeRegistration.setProjectLead(project, lead);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @And("the project {string} has the activity {string}")
    public void theProjectHasTheActivity(String project, String activity) {
        try {
            timeRegistration.createActivity(project, activity);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }
}
