package dtu.examproject.cucumber;

import dtu.examproject.main.TimeRegistration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SeeAvaliableHoursTest {
    private TimeRegistration timeRegistration;
    private String admin = "admn";
    private ErrorMessageHolder errorMessage;
    private Set<String> availableEmployees;

    public SeeAvaliableHoursTest(TimeRegistration timeRegistration, ErrorMessageHolder errorMessage) {
        this.timeRegistration = timeRegistration;
        this.errorMessage = errorMessage;
    }


    @And("the user is the project lead of {string}")
    public void theUserIsTheProjectLeadOf(String project) {
        try {
            timeRegistration.setProjectLead(project, admin);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @And("there are employees named {string} {string} and {string} associated with project {string}")
    public void thereAreEmployeesNamedAndAssociatedWithProject(String emp1, String emp2, String emp3, String project) {
        try {
            timeRegistration.addUser(emp1);
            timeRegistration.addUser(emp2);
            timeRegistration.addUser(emp3);
            timeRegistration.getProject(project).addEmployee(emp1);
            timeRegistration.getProject(project).addEmployee(emp2);
            timeRegistration.getProject(project).addEmployee(emp3);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @And("the employee {string} is associated with activity {string} in project {string}")
    public void theEmployeeIsAssociatedWithActivity(String employee, String activity, String project) {
        try {
            timeRegistration.associateEmployeeWithActivity(project, activity, employee);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @When("the user checks for available employees in project {string}")
    public void theUserChecksForAvailableEmployees(String project) {
        try {
            availableEmployees = timeRegistration.getAssociatedEmployees(project);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("the employees {string} and {string} are returned")
    public void theEmployeesAndAreReturned(String avemp1, String avemp2) {
        List<String> expected = List.of(avemp1, avemp2);
        // we need to check that both lists contain the same elements
        // since the order of the elements may differ
        assertEquals(expected, availableEmployees);

    }

    @And("the user is not the project lead of {string}")
    public void theUserIsNotTheProjectLeadOf(String project) {
        try {
            timeRegistration.setProjectLead(project, "");
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }

    }
}
