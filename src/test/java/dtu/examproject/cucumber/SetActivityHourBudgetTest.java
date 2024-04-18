package dtu.examproject.cucumber;

import dtu.examproject.main.System;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class SetActivityHourBudgetTest {
    private System system;
    private String dummyUser = "dumy";
    private String admin = "admn";
    private ErrorMessageHolder errorMessage;

    public SetActivityHourBudgetTest(System system, ErrorMessageHolder errorMessage) {
        this.system = system;
        this.errorMessage = errorMessage;
    }


    @And("the user is the project lead of project {string}")
    public void theUserIsTheProjectLeadOfProject(String project) {
        try {
            system.setProjectLead(project, admin);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @When("the user sets the hour budget as {int} for activity {string} in the project {string}")
    public void theUserSetsTheHourBudgetAsForActivityInTheProject(int budget, String activity, String project) {
        try {
            system.setActivityHourBudget(project, activity, budget);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("hour budget for activity {string} in project {string} is set to {int}")
    public void hourBudgetForActivityInProjectIsSetTo(String activity, String project, int budget) {
        assertEquals(budget, system.getProject(project).getActivity(activity).getBudgetedHours());
    }


    @And("the Project does not exist")
    public void theProjectDoesNotExist() {
    }
}
