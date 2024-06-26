package dtu.examproject.main;

import java.util.Calendar;

public class Registry {
    private String employee;
    private Calendar date;
    private double hours;

public Registry(String employee, Calendar date, double hours) {
        this.employee = employee;
        this.date = date;
        this.hours = hours;
    }

    public String getEmployee() {return this.employee;}
    public Calendar getDate() {return this.date;}
    public void setHours(double hours) {this.hours = hours;}
    public double getHours() {return this.hours;}
}
