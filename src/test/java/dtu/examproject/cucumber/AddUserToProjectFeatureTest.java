package dtu.examproject.cucumber;

import dtu.examproject.main.System;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddUserToProjectFeatureTest {
    private System system;
    private ErrorMessageHolder errorMessageHolder;
    private String admin = "admn";

    public AddUserToProjectFeatureTest(System system, ErrorMessageHolder errorMessageHolder) {
        this.system = system;
        this.errorMessageHolder = errorMessageHolder;
    }


    @And("a project {string} with activity {string} exists in the system")
    public void aProjectWithActivityExistsInTheSystem(String projectName, String activityName) throws Exception {
        try {
            system.createProject(projectName);
            system.addActivityToProject(projectName, activityName);
        } catch (Exception e) {
            errorMessageHolder.setErrorMessage(e.getMessage());
        }
    }

    @And("{string} is a registered user of the system")
    public void isARegisteredUserOfTheSystem(String user) throws Exception {
        try {
            system.addUser(user);
        } catch (Exception e) {
            errorMessageHolder.setErrorMessage(e.getMessage());
        }
    }

    @When("the user associates {string} with {string}")
    public void theUserAssociatesWith(String user, String project) {
        try {
            system.addUserToProject(project, user);

        } catch (Exception e) {
            errorMessageHolder.setErrorMessage(e.getMessage());
        }
    }

    @Then("{string} is associated with project {string}")
    public void isAssociatedWithProject(String user, String project) {
        try {
            assert system.getProject(project).isAssociated(user);
        } catch (Exception e) {
            errorMessageHolder.setErrorMessage(e.getMessage());
        }
    }

    @When("the user associates {string} to project {string}'s activity {string}")
    public void theUserAssociatesToProjectSActivity(String user, String project, String activity) {
        try {
            system.addUserToActivity(project, activity, user);
        } catch (Exception e) {
            errorMessageHolder.setErrorMessage(e.getMessage());
        }
    }

    @Then("{string} is associated with project {string}'s activity {string}")
    public void isAssociatedWithProjectSActivity(String user, String project, String activity) {
        try {
            assert system.getProject(project).getActivity(activity).isAssociated(user);
        } catch (Exception e) {
            errorMessageHolder.setErrorMessage(e.getMessage());
        }
    }
}
