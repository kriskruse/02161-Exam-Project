package dtu.examproject.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Project {

    private String projectName;
    private List<Activity> activities = new ArrayList<>();
    private List<String> associatedEmployees = new ArrayList<>();
    private String projectLead;

    public Project(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {return this.projectName;}
    public void setProjectName(String projectName) {this.projectName = projectName;}
    public String getProjectLead() {return this.projectLead;}
    public void setProjectLead(String projectLead) {this.projectLead = projectLead;}
    public Boolean activityExists(String activityName) {return activities.stream().anyMatch(a -> a.getTitle().equals(activityName));}
    public Activity getActivity(String activityName) {return activities.stream().filter(a -> a.getTitle().equals(activityName)).findFirst().get();}
    public Boolean isAssociated(String user) {return associatedEmployees.contains(user);}


    public void createActivity(String activityName) {
        activities.add(new Activity(activityName));
    }

    public void addEmployee(String user) {
        associatedEmployees.add(user);
    }

    public void getHourDistribution() throws Exception {
        throw new Exception("Not Implemented");
    }

    public void getEmployeeAvailability() throws Exception {
        throw new Exception("Not Implemented");
    }

    public void addEmployeeToActivity(String activityName, String user) throws Exception {
        if (!activityExists(activityName))
            throw new Exception("Activity does not exist");
        else getActivity(activityName).addEmployee(user);
    }


}
