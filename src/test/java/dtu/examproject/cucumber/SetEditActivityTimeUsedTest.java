package dtu.examproject.cucumber;

import dtu.examproject.main.TimeRegistration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class SetEditActivityTimeUsedTest {
    private TimeRegistration timeRegistration;
    private String admin = "admn";
    private ErrorMessageHolder errorMessage;
    private Calendar today;

    public SetEditActivityTimeUsedTest(TimeRegistration timeRegistration, ErrorMessageHolder errorMessage) {
        this.timeRegistration = timeRegistration;
        this.errorMessage = errorMessage;
        this.today = Calendar.getInstance();
    }


    @When("the user sets their hours spent today on activity {string} for project {string} to {double} hours")
    public void theUserSetsTheirHoursSpentOnActivityToHours(String activity, String project, double hours) {
        try {

            timeRegistration.registerHours(project, activity, admin, today, hours);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("{double} hours are registered on activity {string} for project {string}")
    public void hoursAreRegisteredOnActivity(double hours, String activity, String project) {
        try {
            assertEquals(hours, timeRegistration.getProject(project).getActivity(activity).getTotalEmployeeHours(admin), 0.01);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @And("a project {string} exist in the system")
    public void aProjectExistInTheSystem(String project) throws Exception {
        try {
            timeRegistration.createProject(project);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }     

    @And("the activity {string} does not exist for {string}")
    public void theActivityDoesNotExistFor(String activity, String project) {

    }
}
