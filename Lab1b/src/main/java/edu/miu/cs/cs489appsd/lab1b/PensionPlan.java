package edu.miu.cs.cs489appsd.lab1b;

import java.time.LocalDate;

public class PensionPlan {
    private String planReferenceNumber;
    private LocalDate enrollmentDate;
    private float monthlyContribution;

    public PensionPlan() {
    }

    public PensionPlan(String planReferenceNumber, String enrollmentDate, float monthlyContribution) {
        this.planReferenceNumber = planReferenceNumber;
        this.enrollmentDate = LocalDate.parse(enrollmentDate);
        this.monthlyContribution = monthlyContribution;
    }

    public String getPlanReferenceNumber() {
        return planReferenceNumber;
    }

    public void setPlanReferenceNumber(String planReferenceNumber) {
        this.planReferenceNumber = planReferenceNumber;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = LocalDate.parse(enrollmentDate);
    }

    public float getMonthlyContribution() {
        return monthlyContribution;
    }

    public void setMonthlyContribution(float monthlyContribution) {
        this.monthlyContribution = monthlyContribution;
    }
}
