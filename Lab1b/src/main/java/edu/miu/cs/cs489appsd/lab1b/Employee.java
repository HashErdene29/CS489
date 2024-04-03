package edu.miu.cs.cs489appsd.lab1b;

import java.time.LocalDate;

public class Employee {
    private long employeeId;
    private String firstName;
    private String lastName;
    private LocalDate employmentDate;
    private float yearlySalary;

    private PensionPlan pensionPlan;

    public Employee() {
    }

    public Employee(long employeeId, String firstName, String lastName, String employmentDate, float yearlySalary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = LocalDate.parse(employmentDate);
        this.yearlySalary = yearlySalary;
    }

    public Employee(long employeeId, String firstName, String lastName, String employmentDate, float yearlySalary, PensionPlan plan) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = LocalDate.parse(employmentDate);
        this.yearlySalary = yearlySalary;
        this.pensionPlan = plan;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(String employmentDate) {
        this.employmentDate = LocalDate.parse(employmentDate);
    }

    public float getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(float yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public PensionPlan getPensionPlan() {
        return pensionPlan;
    }

    public void setPensionPlan(PensionPlan pensionPlan) {
        this.pensionPlan = pensionPlan;
    }
}
