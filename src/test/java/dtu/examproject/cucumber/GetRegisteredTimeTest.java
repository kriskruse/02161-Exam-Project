package dtu.examproject.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GetRegisteredTimeTest {
    @And("the user sets their hours spent on activity {string} to {string} hours in the project {string}")
    public void theUserSetsTheirHoursSpentOnActivityToHoursInTheProject(String arg0, String arg1, String arg2) {
    }

    @When("the user requests their registered time")
    public void theUserRequestsTheirRegisteredTime() {
    }

    @Then("{string} hours is returned")
    public void hoursIsReturned(String arg0) {
    }

    @Given("that the user is not logged into the system")
    public void thatTheUserIsNotLoggedIntoTheSystem() {
    }

    @When("the user requests the registered time")
    public void theUserRequestsTheRegisteredTime() {
    }
}
