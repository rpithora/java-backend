package com.shreya.designpattern.creational.builder;

public class Director {
    StudentBuilder studentBuilder;

    Director(StudentBuilder studentBuilder) {
        this.studentBuilder = studentBuilder;
    }

    public Student createEngineeringStudent() {
        return studentBuilder.setId(1).setFirstName("Shaurya Pratap").
                setLastName("Chauhan").setDeptName("Engineering").build();
    }

    public static void main(String[] args) {
        Director director = new Director(new StudentBuilder());
        Student student = director.createEngineeringStudent();
        System.out.println(student);
    }
}
