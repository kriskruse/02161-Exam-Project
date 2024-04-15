package dtu.examproject.main;

import dtu.examproject.main.Registry;

import java.util.ArrayList;
import java.util.List;

public class Activity {

    private String title;
    private int startDate;
    private int endDate;
    private int budgetedHours;
    private double totalHours = 0;
    private List<String> associatedEmployees = new ArrayList<>();
    private List<Registry> registeredHours = new ArrayList<>();

    public Activity(String activityName) {
        this.title = activityName;
    }

    public String getTitle() {return this.title;}
    public void setTitle(String title) {this.title = title;}
    public int getStartDate() {return this.startDate;}
    public void setStartDate(int startDate) {this.startDate = startDate;}
    public int getEndDate() {return this.endDate;}
    public void setEndDate(int endDate) {this.endDate = endDate;}
    public int getBudgetedHours() {return budgetedHours;}
    public void setBudgetedHours(int budgetedHours) {this.budgetedHours = budgetedHours;}
    public double getTotalHours() {return totalHours;}
    public void addToTotalHours(double hours) {this.totalHours += hours;}
    public Boolean isAssociated(String user) {return associatedEmployees.contains(user);}


    public void addEmployee(String user) {
        associatedEmployees.add(user);
    }

    public void registerHours() throws Exception {
        throw new Exception("Not Implemented");
    }

    public void getEmployeeHours() throws Exception {
        throw new Exception("Not Implemented");
    }


}
