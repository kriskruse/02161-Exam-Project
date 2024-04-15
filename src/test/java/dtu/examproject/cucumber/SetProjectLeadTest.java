package dtu.examproject.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SetProjectLeadTest {
    @When("a user sets {string} as the project lead of {string}")
    public void aUserSetsAsTheProjectLeadOf(String arg0, String arg1) {
    }

    @Then("{string} is the project lead of {string}")
    public void isTheProjectLeadOf(String arg0, String arg1) {
    }

    @And("a project {string} does not exist in the system")
    public void aProjectDoesNotExistInTheSystem(String arg0) {
    }

    @And("{string} is not a registered user of the system")
    public void isNotARegisteredUserOfTheSystem(String arg0) {
    }
}
