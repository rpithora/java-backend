package com.shreya.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {
    private int id;
    private String empName;

    public Employee(int id, String empName) {
        this.id = id;
        this.empName = empName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empName='" + empName + '\'' +
                '}';
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee(1,"Rudra");
        Employee employee2 = new Employee(2,"Divya");
        Employee employee3 = new Employee(3,"Shaurya");
        Employee employee4 = new Employee(4,"Shreya");

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        System.out.println(employees);

        employees.stream().forEach(System.out::println);

        employees.stream().forEach(s -> System.out.println(s.getEmpName()));
        List<Employee> newList = employees.stream().filter(s -> s.getId() >= 3).collect(Collectors.toList());
        newList.stream().forEach(s-> System.out.println(s.getEmpName()));
        employees.stream().skip(1).forEach(System.out::println);
        System.out.println("+++++ sort");
        List<Employee> elist = employees.stream().sorted((e1, e2) -> e2.getId() - e1.getId()).collect(Collectors.toList());
        elist.stream().forEach(s -> System.out.println(s));
        System.out.println();
        employees.stream().map(s->s.getEmpName().toLowerCase()).forEach(System.out::println);
        List<String> members = Arrays.asList("Babbal", "Teena", "Chiku", "Nains");
        System.out.println();
        members.stream().map(String::toUpperCase).filter(s -> s.startsWith("B")).forEach(System.out::println);
        // employees.stream().map(String::toLowerCase).filter(s -> s.ge)
    }
}