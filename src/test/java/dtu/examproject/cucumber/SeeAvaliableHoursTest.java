package dtu.examproject.cucumber;

import dtu.examproject.main.System;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class SeeAvaliableHoursTest {
    private System system;
    private String admin = "admn";
    private ErrorMessageHolder errorMessage;
    private List<String> availableEmployees;

    public SeeAvaliableHoursTest(System system, ErrorMessageHolder errorMessage) {
        this.system = system;
        this.errorMessage = errorMessage;
    }


    @And("the user is the project lead of {string}")
    public void theUserIsTheProjectLeadOf(String project) {
        try {
            system.setProjectLead(project, admin);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @And("there are employees named {string} {string} and {string} associated with project {string}")
    public void thereAreEmployeesNamedAndAssociatedWithProject(String emp1, String emp2, String emp3, String project) {
        try {
            system.addUser(emp1);
            system.addUser(emp2);
            system.addUser(emp3);
            system.getProject(project).addEmployee(emp1);
            system.getProject(project).addEmployee(emp2);
            system.getProject(project).addEmployee(emp3);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @And("the employee {string} is associated with activity {string} in project {string}")
    public void theEmployeeIsAssociatedWithActivity(String employee, String activity, String project) {
        try {
            system.associateEmployeeWithActivity(project, activity, employee);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @When("the user checks for available employees in project {string}")
    public void theUserChecksForAvailableEmployees(String project) {
        try {
            availableEmployees = system.getAssociatedEmployees(project);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("the employees {string} and {string} are returned")
    public void theEmployeesAndAreReturned(String avemp1, String avemp2) {
        List<String> expected = List.of(avemp1, avemp2);
        // we need to check that both lists contain the same elements
        // since the order of the elements may differ
        assert availableEmployees.containsAll(expected) && expected.containsAll(availableEmployees);

    }

    @And("the user is not the project lead of {string}")
    public void theUserIsNotTheProjectLeadOf(String project) {
        try {
            system.setProjectLead(project, "");
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }

    }
}
