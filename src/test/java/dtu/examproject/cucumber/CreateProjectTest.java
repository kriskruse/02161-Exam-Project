package dtu.examproject.cucumber;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateProjectTest {
    @When("the user creates a project with the name {string}")
    public void theUserCreatesAProjectWithTheName(String arg0) {
    }

    @Then("a project with the name {string} is in the system")
    public void aProjectWithTheNameIsInTheSystem(String arg0) {
    }
}
