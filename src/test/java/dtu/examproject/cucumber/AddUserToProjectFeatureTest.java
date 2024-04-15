package dtu.examproject.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddUserToProjectFeatureTest {
    @And("a project {string} with activity {string} exists in the system")
    public void aProjectWithActivityExistsInTheSystem(String arg0, String arg1) {
    }

    @And("{string} is a registered user of the system")
    public void isARegisteredUserOfTheSystem(String arg0) {
    }

    @When("the user associates {string} with {string}")
    public void theUserAssociatesWith(String arg0, String arg1) {
    }

    @Then("{string} is associated with project {string}")
    public void isAssociatedWithProject(String arg0, String arg1) {
    }

    @When("the user associates {string} to project {string}'s activity {string}")
    public void theUserAssociatesToProjectSActivity(String arg0, String arg1, String arg2) {
    }

    @Then("{string} is associated with project {string}'s activity {string}")
    public void isAssociatedWithProjectSActivity(String arg0, String arg1, String arg2) {
    }
}
