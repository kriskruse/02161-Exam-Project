package dtu.examproject.cucumber;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SetStartEndTimeTest {
    @When("the user sets the start time to week {string} and end time to week {string} for activity {string}")
    public void theUserSetsTheStartTimeToWeekAndEndTimeToWeekForActivity(String arg0, String arg1, String arg2) {
    }

    @Then("the activity {string} has week {string} as the start time and week {string} as the end time")
    public void theActivityHasWeekAsTheStartTimeAndWeekAsTheEndTime(String arg0, String arg1, String arg2) {
    }
}
