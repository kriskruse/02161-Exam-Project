package dtu.examproject.cucumber;

import dtu.examproject.main.Activity;
import dtu.examproject.main.System;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SeeDistributionOfRegisteredHoursTest {
    private System system;
    private String admin = "admn";
    private ErrorMessageHolder errorMessage;
    private Map<Activity, Double> hourDistribution;

    public SeeDistributionOfRegisteredHoursTest(System system, ErrorMessageHolder errorMessage) {
        this.system = system;
        this.errorMessage = errorMessage;
    }

    @And("{string} has hours registered on activity {string} of the project {string}")
    public void hasHoursRegisteredTodayOnActivity(String employee, String activity, String project) {
        Calendar date = Calendar.getInstance();
        try {
            system.registerHours(project, activity, employee, date, 8);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @When("the user gets hour distribution for project {string}")
    public void theUserGetsHourRegistrationForActivityOfTheProject(String project) {
        try {
            hourDistribution = system.getHourDistribution(project);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @Then("the distribution of hour registrations is given")
    public void theDistributionOfHourRegistrationsIsGiven() {
        // TODO: find a way to assert the hour distribution better
        assertNotNull(hourDistribution);
    }
}
