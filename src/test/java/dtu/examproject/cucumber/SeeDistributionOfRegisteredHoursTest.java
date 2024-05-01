package dtu.examproject.cucumber;

import dtu.examproject.main.Activity;
import dtu.examproject.main.TimeRegistration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Calendar;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SeeDistributionOfRegisteredHoursTest {
    private TimeRegistration timeRegistration;
    private String admin = "admn";
    private ErrorMessageHolder errorMessage;
    private Map<Activity, Double> hourDistribution;

    public SeeDistributionOfRegisteredHoursTest(TimeRegistration timeRegistration, ErrorMessageHolder errorMessage) {
        this.timeRegistration = timeRegistration;
        this.errorMessage = errorMessage;
    }

    @And("{string} has hours registered on activity {string} of the project {string}")
    public void hasHoursRegisteredTodayOnActivity(String employee, String activity, String project) {
        Calendar date = Calendar.getInstance();
        int week = date.get(Calendar.WEEK_OF_YEAR);
        try {
            timeRegistration.registerHours(project, activity, employee, week, 8);
        } catch (Exception e) {
            errorMessage.setErrorMessage(e.getMessage());
        }
    }

    @When("the user gets hour distribution for project {string}")
    public void theUserGetsHourRegistrationForActivityOfTheProject(String project) {
        try {
            hourDistribution = timeRegistration.getHourDistribution(project);
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
