package com.shreya.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee {
    private int id;
    private String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
public class EmployeeDemo {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, "Shaurya");
        Employee e2 = new Employee(2, "Shreya");
        Employee e3 = new Employee(3, "Divya");
        Employee e4 = new Employee(4, "Rudra");

        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);

        //Collections.sort(employees, (employee1, employee2) -> employee1.getName().compareTo(employee2.getName()));
        Collections.sort(employees, Comparator.comparing(Employee::getName));
        employees.stream().forEach(s -> System.out.println(s.getName()));
    }
}
