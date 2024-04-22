package dtu.examproject.cucumber;

import dtu.examproject.main.System;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class SetStartEndTimeTest {
    private System system;
    private String admin = "admn";
    private ErrorMessageHolder errorMessage;

    public SetStartEndTimeTest(System system, ErrorMessageHolder errorMessage) {
        this.system = system;
        this.errorMessage = errorMessage;
    }

    @When("the user sets the start time to week {int} and end time to week {int} for activity {string} in project {string}")
    public void theUserSetsTheStartTimeToWeekAndEndTimeToWeekForActivity(int start, int end, String activity, String project) {
        try {
            system.setActivityStart(project, activity, start);
            system.setActivityEnd(project, activity, end);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("the activity {string} in project {string} has week {int} as the start time and week {int} as the end time")
    public void theActivityHasWeekAsTheStartTimeAndWeekAsTheEndTime(String activity,String project, int start, int end) {
        try {
            assertEquals( system.getActivityStart(project, activity),start);
            assertEquals(system.getActivityEnd(project, activity), end);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }

    }
}
