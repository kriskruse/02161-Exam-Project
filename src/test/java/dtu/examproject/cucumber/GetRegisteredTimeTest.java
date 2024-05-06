package dtu.examproject.cucumber;

import dtu.examproject.main.TimeRegistration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetRegisteredTimeTest {
    private TimeRegistration timeRegistration;
    private String admin = "admn";
    private ErrorMessageHolder errorMessage;
    private double hours;

    public GetRegisteredTimeTest(TimeRegistration timeRegistration, ErrorMessageHolder errorMessage) {
        this.timeRegistration = timeRegistration;
        this.errorMessage = errorMessage;
    }


    @When("the user requests their registered time")
    public void theUserRequestsTheirRegisteredTime() {
        try {
            this.hours = timeRegistration.getRegisteredTime(admin);
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
            timeRegistration.getProject(project).addEmployee(admin);
            timeRegistration.getProject(project).addEmployeeToActivity(activity, admin);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }

    }

    @When("the user requests the user {string} registered time")
    public void theUserRequestsTheUserRegisteredTime(String user) {
        try {
            this.hours = timeRegistration.getRegisteredTime(user);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }
}
