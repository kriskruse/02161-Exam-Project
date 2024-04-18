package dtu.examproject.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
    public List<Activity> getActivities() {return activities;}
    public List<String> getAssociatedEmployees() {return associatedEmployees;}

    public void registerHours(String activityName, String employee, double hours) throws Exception {
        if (!activityExists(activityName))
            throw new Exception("Activity does not exist");
        else if (!isAssociated(employee))
            throw new Exception("Employee is not associated with this project");
        else getActivity(activityName).registerHours(employee, hours);
    }

    public void setActivityHourBudget(String activityName, int budget) throws Exception {
        if (!activityExists(activityName))
            throw new Exception("Activity does not exist");
        else getActivity(activityName).setBudgetedHours(budget);
    }

    public void createActivity(String activityName) {
        activities.add(new Activity(activityName));
    }

    public void addEmployee(String user) {
        associatedEmployees.add(user);
    }

    public Map<Activity, Double> getHourDistribution() throws Exception {
        if (activities.isEmpty())
            return null;
        else {
            return activities.stream().collect(
                java.util.stream.Collectors.toMap(
                    a -> a,
                        Activity::getTotalHours
                )
            );
        }
    }

    public List<String> getAvalibleEmployees() throws Exception {
        List<String> avalibleEmployees = new ArrayList<>();
        for (String employee : associatedEmployees) {
            if (activities.stream().noneMatch(a -> a.isAssociated(employee)))
                avalibleEmployees.add(employee);
        }
        return avalibleEmployees;
    }

    public void addEmployeeToActivity(String activityName, String user) throws Exception {
        if (!activityExists(activityName))
            throw new Exception("Activity does not exist");
        else getActivity(activityName).addEmployee(user);
    }


}
