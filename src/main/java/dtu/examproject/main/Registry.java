package dtu.examproject.main;

import java.util.Calendar;

public class Registry {
    private String employee;
    private Calendar date;
    private double hours;

    public void setEmployee(String employee) {this.employee = employee;}
    public String getEmployee() {return this.employee;}
    public void setDate(Calendar date) {this.date = date;}
    public Calendar getDate() {return this.date;}
    public void setHours(double hours) {this.hours = hours;}
    public double getHours() {return this.hours;}
}
