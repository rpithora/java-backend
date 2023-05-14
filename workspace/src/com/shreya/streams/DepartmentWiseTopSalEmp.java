package com.shreya.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@FunctionalInterface
interface I1 {
    void m1();
}

@FunctionalInterface
interface I2 {
    void m2();

    boolean equals(Object o);
}

class Employees {
    int empId;
    String name;
    String dept;
    int salary;

    public Employees(int empId, String name, String dept, int salary) {
        this.empId = empId;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class DepartmentWiseTopSalEmp {
    public static void main(String[] args) {
        List<Employees> employeeList = Arrays.asList(new Employees(1, "A", "CS", 10000),
                new Employees(2, "B", "CS", 20000),
                new Employees(3, "C", "CS", 25000),
                new Employees(4, "D", "IT", 10000),
                new Employees(5, "E", "IT", 15000));

        employeeList.stream().map(Employees::getEmpId).collect(Collectors.toList());
        Map<String, List<Employees>> deptWiseEmp = employeeList.stream().collect(Collectors.groupingBy(e -> e.getDept()));
        System.out.println(deptWiseEmp);

        Map<String, Employees> deptWiseTopSalariedEmp = employeeList.stream().collect(Collectors.groupingBy(e -> e.getDept(),
                Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparingInt(s -> s.getSalary())
                        ), Optional::get
                )));
        System.out.println(deptWiseTopSalariedEmp);

        String name = "bhanwar-shaurya-pratap-singh-chauhan";
        List<String> charArray = Arrays.stream(name.split("")).collect(Collectors.toList());
        System.out.println(charArray);
        Map<String, Long> countMap = charArray.stream().collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting())
        );
        System.out.println(countMap);

        String name1 = "Adarsh-Viddhya-Mandir";
        Map<String, Long> scCnt = Arrays.stream(name1.toLowerCase(Locale.ROOT).split(""))
                .collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );

        System.out.println(scCnt);
    }
}