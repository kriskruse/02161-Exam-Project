package dtu.examproject.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SeeAvaliableHoursTest {
    @Given("that the user is logged into the system")
    public void thatTheUserIsLoggedIntoTheSystem() {
    }

    @And("the user is the project lead of {string}")
    public void theUserIsTheProjectLeadOf(String arg0) {
    }

    @And("there are employees named {string} {string} and {string} associated with project {string}")
    public void thereAreEmployeesNamedAndAssociatedWithProject(String arg0, String arg1, String arg2, String arg3) {
    }

    @And("the employee {string} is associated with activity {string}")
    public void theEmployeeIsAssociatedWithActivity(String arg0, String arg1) {
    }

    @When("the user checks for available employees")
    public void theUserChecksForAvailableEmployees() {
    }

    @Then("the employees {string} and {string} are returned")
    public void theEmployeesAndAreReturned(String arg0, String arg1) {
    }

    @And("the user is not the project lead of {string}")
    public void theUserIsNotTheProjectLeadOf(String arg0) {
    }

    @Then("the error {string} is given")
    public void theErrorIsGiven(String arg0) {
    }
}
