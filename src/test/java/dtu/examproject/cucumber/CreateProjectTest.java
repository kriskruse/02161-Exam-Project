package dtu.examproject.cucumber;

import dtu.examproject.main.Project;
import dtu.examproject.main.System;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CreateProjectTest {

    private System system;
    private ErrorMessageHolder errorMessage;
    private List<Project> projects;
    private List<String> projectNames;

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

    @When("the user requests all projects")
    public void theUserRequestsAllProjects() {
        projects = system.getProjectList();
        // get names of projects
        projectNames = projects.stream().map(Project::getProjectName).toList();

    }

    @Then("projects {string} and {string} are returned")
    public void projectsAndAreReturned(String project1, String project2) {
        List<String> expectedProjects = List.of(project1, project2);
        assertEquals(expectedProjects, projectNames);
    }


    @And("a project {string} exists in the system")
    public void aProjectExistsInTheSystem(String project) {
        try {
            system.createProject(project);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }
}
