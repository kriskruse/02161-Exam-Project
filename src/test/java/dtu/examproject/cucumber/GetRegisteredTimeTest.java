package dtu.examproject.cucumber;

import dtu.examproject.main.System;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GetRegisteredTimeTest {
    private System system;
    private String admin = "admn";
    private ErrorMessageHolder errorMessage;

    public GetRegisteredTimeTest(System system, ErrorMessageHolder errorMessage) {
        this.system = system;
        this.errorMessage = errorMessage;
    }


    @When("the user requests their registered time")
    public void theUserRequestsTheirRegisteredTime() {
        try {
            system.getRegisteredTime(admin);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("{double} hours is returned")
    public void hoursIsReturned(double hours) {

    }

    @Given("that the user is not logged into the system")
    public void thatTheUserIsNotLoggedIntoTheSystem() {
    }

}
