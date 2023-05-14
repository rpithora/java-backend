package com.shreya.designpattern.builder;

public class StudentBuilder {
    public int id;
    public String firstName;
    public String lastName;
    public String deptName;

    public StudentBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public StudentBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public StudentBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public StudentBuilder setDeptName(String deptName) {
        this.deptName = deptName;
        return this;
    }

    public Student build(){
        return new Student(this);
    }
}
