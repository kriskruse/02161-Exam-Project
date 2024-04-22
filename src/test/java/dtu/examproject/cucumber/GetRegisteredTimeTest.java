package dtu.examproject.cucumber;

import dtu.examproject.main.System;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetRegisteredTimeTest {
    private System system;
    private String admin = "admn";
    private ErrorMessageHolder errorMessage;
    private double hours;

    public GetRegisteredTimeTest(System system, ErrorMessageHolder errorMessage) {
        this.system = system;
        this.errorMessage = errorMessage;
    }


    @When("the user requests their registered time")
    public void theUserRequestsTheirRegisteredTime() {
        try {
            this.hours = system.getRegisteredTime(admin);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("{double} hours is returned")
    public void hoursIsReturned(double hours) {
        assertEquals(this.hours, hours, 0.0);
    }

    @And("the user is a member of project {string} and activity {string}")
    public void theUserIsAMemberOfProjectAndActivity(String project, String activity){
        try {
            system.getProject(project).addEmployee(admin);
            system.getProject(project).addEmployeeToActivity(activity, admin);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }

    }
}
