package dtu.examproject.cucumber;

import dtu.examproject.main.TimeRegistration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SeeAvaliableUsersTest {
    private TimeRegistration timeRegistration;
    private String admin = "admn";
    private ErrorMessageHolder errorMessage;
    private Map<String, Double> availableEmployees;

    public SeeAvaliableUsersTest(TimeRegistration timeRegistration, ErrorMessageHolder errorMessage) {
        this.timeRegistration = timeRegistration;
        this.errorMessage = errorMessage;
    }


    @And("the employee {string} is associated with activity {string} in project {string}")
    public void theEmployeeIsAssociatedWithActivity(String employee, String activity, String project) {
        try {
            timeRegistration.addUser(employee);
            timeRegistration.addUserToActivity(project, activity, employee);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @When("the user checks for employees between week {int} and {int} in project {string}")
    public void theUserChecksForAvailableEmployees(int startWeek, int endWeek, String project) {
        try {
            availableEmployees = timeRegistration.getAvailableEmployees(project, startWeek, endWeek);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("{string} with {int} hours is returned")
    public void theEmployeeAndAreReturned(String employee, int hours) {
        assertTrue(availableEmployees.containsKey(employee));
        assertEquals(hours, availableEmployees.get(employee), 0.01);
    }

    @And("the user is not the project lead of {string}")
    public void theUserIsNotTheProjectLeadOf(String project) {
        try {
            timeRegistration.setProjectLead(project, "");
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }

    }

    @And("{string} has {int} hours registered in week {int} on activity {string} of the project {string}")
    public void hasHoursRegisteredInWeekOnActivityOfTheProject(String user, int hours, int week, String activity, String project) {
        try {
            timeRegistration.registerHours(project, activity, user, week, hours);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }
}
