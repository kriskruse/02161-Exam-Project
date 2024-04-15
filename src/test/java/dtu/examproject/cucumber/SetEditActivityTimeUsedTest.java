package dtu.examproject.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SetEditActivityTimeUsedTest {
    @When("the user sets their hours spent on activity {string} to {string} hours")
    public void theUserSetsTheirHoursSpentOnActivityToHours(String arg0, String arg1) {
    }

    @Then("{string} hours are registered on activity {string}.")
    public void hoursAreRegisteredOnActivity(String arg0, String arg1) {
    }

    @And("a project {string} exist in the system")
    public void aProjectExistInTheSystem(String arg0) {
    }

    @And("the activity {string} does not exist for {string}.")
    public void theActivityDoesNotExistFor(String arg0, String arg1) {
    }
}
