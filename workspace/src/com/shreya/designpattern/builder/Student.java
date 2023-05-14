package com.shreya.designpattern.builder;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String deptName;
    public Student(StudentBuilder builder){
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.deptName = builder.deptName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
