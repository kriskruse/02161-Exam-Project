package dtu.examproject.cucumber;

import dtu.examproject.main.System;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateProjectTest {

    private System system;
    private ErrorMessageHolder errorMessage;

    public CreateProjectTest(System system, ErrorMessageHolder errorMessage) {
        this.system = system;
        this.errorMessage = errorMessage;
    }

    @When("the user creates a project with the name {string}")
    public void theUserCreatesAProjectWithTheName(String project) {
        try {
            system.createProject(project);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("a project with the name {string} is in the system")
    public void aProjectWithTheNameIsInTheSystem(String project) {
        try {
            system.createProject(project);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }
}
