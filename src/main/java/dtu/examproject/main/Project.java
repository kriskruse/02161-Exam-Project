package dtu.examproject.main;

import io.cucumber.java.ca.Cal;

import java.util.*;

public class Project {

    private String projectName;
    private String projectID;
    private List<Activity> activities = new ArrayList<>();
    private Set<String> associatedEmployees = new HashSet<>();
    private String projectLead;
    private String sickness = "Sickness";
    private String vacation = "Vacation";

    public Project(String projectName, int projectNum){
        this.projectName = projectName;
        String year = "" + Calendar.getInstance().get(Calendar.YEAR);
        this.projectID = year.substring(year.length() - 2) + String.format("%04d", projectNum);
        this.projectLead = "";
        this.activities.add(new Activity(sickness));
        this.activities.add(new Activity(vacation));
    }

    public Set<String> getAssociatedEmployees() {return associatedEmployees;}
    public String getProjectName() {return this.projectName;}
    public String getProjectLead() {return this.projectLead;}
    public void setProjectLead(String projectLead) {this.projectLead = projectLead;}
    public Boolean activityExists(String activityName) {return activities.stream().anyMatch(a -> a.getTitle().equals(activityName));}
    public Activity getActivity(String activityName) {return activities.stream().filter(a -> a.getTitle().equals(activityName)).findFirst().get();}
    public Boolean isAssociated(String employee) {return associatedEmployees.contains(employee);}
    public List<Activity> getActivities() {return activities;}
    public String getProjectID() {return projectID;}

    public void registerHours(String activityName, String employee, Calendar date, double hours) throws Exception {
        if (!activityExists(activityName))
            throw new Exception("Activity does not exist");
        else if (!isAssociated(employee))
            throw new Exception("Employee is not associated with this project");
        else getActivity(activityName).registerHours(employee, date, hours);
    }

    public void setActivityHourBudget(String activityName, int budget) throws Exception {
        if (!activityExists(activityName))
            throw new Exception("Activity does not exist");
        else getActivity(activityName).setBudgetedHours(budget);
    }

    public void createActivity(String activity) throws Exception{
        if (activityExists(activity)) throw new Exception("Activity already exists");
        else activities.add(new Activity(activity));
    }

    public void addEmployee(String employee) {
        associatedEmployees.add(employee);
    }

    public Map<Activity, Double> getHourDistribution() throws Exception {
        if (activities.isEmpty())
            throw new Exception("No activities in project");
        else {
            return activities.stream().collect(
                java.util.stream.Collectors.toMap(
                    a -> a,
                        Activity::getTotalHours
                )
            );
        }
    }

    public Map<String,Double> getAvailableEmployees() throws Exception {
        if (activities.isEmpty()) throw new Exception("No activities in project");
        else if (associatedEmployees.isEmpty()) throw new Exception("No employees associated with project");
        else {
            Map<String,Double> availableEmployees = new HashMap<>();
            for (String employee : associatedEmployees) {
                if(!(getActivity(sickness).isAssociated(employee) && getActivity(vacation).isAssociated(employee))) {
                    availableEmployees.put(employee, getRegisteredTime(employee));
                }
            }
            return availableEmployees;
        }
    }

    public void addEmployeeToActivity(String activityName, String employee) throws Exception {
        if (!activityExists(activityName))
            throw new Exception("Activity does not exist");
        else {
            getActivity(activityName).addEmployee(employee);
            addEmployee(employee);
        }
    }


    public double getRegisteredTime(String employee) {
        double hours = 0;
        for (Activity a : getActivities()) {
            try {
                hours += a.getTotalEmployeeHours(employee);
            } catch (Exception e) {
                hours += 0;
            }
        }
        return hours;
    }
}
