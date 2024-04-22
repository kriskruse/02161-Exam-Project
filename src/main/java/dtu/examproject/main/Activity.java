package dtu.examproject.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

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
    public int getStartDate() {return this.startDate;}
    public void setStartDate(int startDate) {this.startDate = startDate;}
    public int getEndDate() {return this.endDate;}
    public void setEndDate(int endDate) {this.endDate = endDate;}
    public int getBudgetedHours() {return budgetedHours;}
    public void setBudgetedHours(int budgetedHours) {this.budgetedHours = budgetedHours;}
    public double getTotalHours() {return totalHours;}

    public Boolean isAssociated(String user) {return associatedEmployees.contains(user);}
    public void addEmployee(String user) {
        associatedEmployees.add(user);
    }

    public Boolean hasRegisteredHours(Calendar date, String user) {
        return registeredHours.stream().anyMatch(r -> r.getDate().equals(date) && r.getEmployee().equals(user));}

    public Boolean hasAnyRegisteredHours(String user) {
        return registeredHours.stream().anyMatch(r -> r.getEmployee().equals(user));
    }

    public void registerHours(String employee, Calendar date, double hours) throws Exception {
        if (!associatedEmployees.contains(employee))
            throw new Exception("Employee is not associated with this activity");
        else if (hasRegisteredHours(date, employee))
            // find and update hours
            registeredHours.stream()
                .filter(r -> r.getDate().equals(date) && r.getEmployee().equals(employee))
                .findFirst()
                .get()
                .setHours(hours);
        else
            registeredHours.add(new Registry(employee, date, hours));
    }


    public double getTotalEmployeeHours(String employee) throws Exception {
        // find employee and return hours
        if (!associatedEmployees.contains(employee))
            throw new Exception("Employee is not associated with this activity");
        else
            return
                registeredHours.stream()
                    .filter(r -> r.getEmployee().equals(employee))
                    .mapToDouble(Registry::getHours)
                    .sum();
    }



}
