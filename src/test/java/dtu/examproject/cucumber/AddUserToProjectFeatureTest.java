package dtu.examproject.cucumber;

import dtu.examproject.main.TimeRegistration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class AddUserToProjectFeatureTest {
    private TimeRegistration timeRegistration;
    private ErrorMessageHolder errorMessageHolder;
    private String admin = "admn";

    public AddUserToProjectFeatureTest(TimeRegistration timeRegistration, ErrorMessageHolder errorMessageHolder) {
        this.timeRegistration = timeRegistration;
        this.errorMessageHolder = errorMessageHolder;
    }


    @And("a project {string} with activity {string} exists in the system")
    public void aProjectWithActivityExistsInTheSystem(String projectName, String activityName) throws Exception {
        try {
            timeRegistration.createProject(projectName);
            timeRegistration.addActivityToProject(projectName, activityName);
        } catch (Exception e) {
            errorMessageHolder.setErrorMessage(e.getMessage());
        }
    }

    @And("{string} is a registered user of the system")
    public void isARegisteredUserOfTheSystem(String user) throws Exception {
        try {
            timeRegistration.addUser(user);
        } catch (Exception e) {
            errorMessageHolder.setErrorMessage(e.getMessage());
        }
    }

    @When("the user associates {string} with {string}")
    public void theUserAssociatesWith(String user, String project) {
        try {
            timeRegistration.addUserToProject(project, user);

        } catch (Exception e) {
            errorMessageHolder.setErrorMessage(e.getMessage());
        }
    }

    @Then("{string} is associated with project {string}")
    public void isAssociatedWithProject(String user, String project) {
        try {
            assertTrue(timeRegistration.getProject(project).isAssociated(user));
        } catch (Exception e) {
            errorMessageHolder.setErrorMessage(e.getMessage());
        }
    }

    @When("the user associates {string} to project {string}'s activity {string}")
    public void theUserAssociatesToProjectSActivity(String user, String project, String activity) {
        try {
            timeRegistration.addUserToActivity(project, activity, user);
        } catch (Exception e) {
            errorMessageHolder.setErrorMessage(e.getMessage());
        }
    }

    @Then("{string} is associated with project {string}'s activity {string}")
    public void isAssociatedWithProjectSActivity(String user, String project, String activity) {
        try {
            assertTrue(timeRegistration.userIsAssociatedWithActivity(project, activity, user));
        } catch (Exception e) {
            errorMessageHolder.setErrorMessage(e.getMessage());
        }
    }
}
