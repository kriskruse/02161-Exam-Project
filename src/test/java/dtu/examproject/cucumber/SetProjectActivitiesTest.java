package dtu.examproject.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SetProjectActivitiesTest {
    @When("the user creates the activity {string} in the project {string}")
    public void theUserCreatesTheActivityInTheProject(String arg0, String arg1) {
    }

    @Then("project {string} has the activity {string}")
    public void projectHasTheActivity(String arg0, String arg1) {
    }

    @And("project {string} has no project lead")
    public void projectHasNoProjectLead(String arg0) {
    }

    @And("{string} is the project lead of project {string}")
    public void isTheProjectLeadOfProject(String arg0, String arg1) {
    }
}
