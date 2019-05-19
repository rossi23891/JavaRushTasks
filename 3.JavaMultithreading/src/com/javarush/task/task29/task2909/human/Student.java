package com.javarush.task.task29.task2909.human;

import java.util.Date;

public class Student extends UniversityPerson {
    private double averageGrade;
    private Date beginningOfSession;
    private Date endOfSession;
    private int course;

    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.setAverageGrade(averageGrade);
    }

    public void live() {
        learn();
    }

    public void learn() {

    }

    public void incAverageGrade(double delta) {
        setAverageGrade(getAverageGrade() + delta);
    }

    public int getCourse() {
        return course;
    }

    public void setAverageGrade(double value) {
        averageGrade = value;
    }

    public void setCourse(int value) {
        course = value;
    }

    @Override
    public String getPosition() {
        return "Студент";
    }

    public void setBeginningOfSession(Date beginningSession) {
        beginningOfSession = beginningSession;
    }

    public void setEndOfSession(Date endSession) {
        endOfSession = endSession;
    }

    public double getAverageGrade() {
        return averageGrade;
    }
}