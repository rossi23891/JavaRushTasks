package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    private List<Student> students;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
        students = new ArrayList<>();
    }

    public Student getStudentWithAverageGrade(double value) {
        //TODO:
        Student st=null;
        for (Student student : students) {
            if(student.getAverageGrade()==value){
                st = student;
            }
        }
        return st;
    }

    public Student getStudentWithMaxAverageGrade() {
        double maxGrade = students.get(0).getAverageGrade();
        Student student = students.get(0);
        for (int i = 1; i <students.size() ; i++) {
            if(students.get(i).getAverageGrade()>maxGrade){
                maxGrade = students.get(i).getAverageGrade();
                student = students.get(i);
            }
        }
        return student;
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        double minGrade = students.get(0).getAverageGrade();
        Student student = students.get(0);
        //TODO:
        for (int i = 1; i <students.size() ; i++) {
            if(students.get(i).getAverageGrade()<minGrade){
                minGrade = students.get(i).getAverageGrade();
                student = students.get(i);
            }
        }
        return student;
    }
     public void expel(Student student){
        students.remove(student);
     }


}