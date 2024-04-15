package dtu.examproject.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SetActivityHourBudgetTest {
    @And("the user is the project lead of project {string}")
    public void theUserIsTheProjectLeadOfProject(String arg0) {
    }

    @When("the user sets the hour budget as {string} for activity {string} in the project {string}")
    public void theUserSetsTheHourBudgetAsForActivityInTheProject(String arg0, String arg1, String arg2) {
    }

    @Then("hour budget for activity {string} in project {string} is set to {string}")
    public void hourBudgetForActivityInProjectIsSetTo(String arg0, String arg1, String arg2) {
    }

    @And("the Project does not exist")
    public void theProjectDoesNotExist() {
    }

    @Then("the error message {string} is given.")
    public void theErrorMessageIsGiven(String arg0) {
    }
}
