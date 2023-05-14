package com.shreya.hashmap;

import java.io.Serializable;
import java.util.*;

class Emp implements Serializable, Comparable<Emp> {
    int id;
    String name;
    String empDept;

    public Emp(int id, String name, String empDept) {
        this.id = id;
        this.name = name;
        this.empDept = empDept;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmpDept() {
        return empDept;
    }

    public void setEmpDept(String empDept) {
        this.empDept = empDept;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return id == emp.id && Objects.equals(name, emp.name) && Objects.equals(empDept, emp.empDept);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, empDept);
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", empDept='" + empDept + '\'' +
                '}';
    }

    @Override
    public int compareTo(Emp emp) {
        return this.id - emp.id;
    }
}

public class ComparatorDemo {
    public static void main(String[] args) {
        Emp e1 = new Emp(3, "A", "D1");
        Emp e2 = new Emp(1, "B", "D2");
        Emp e3 = new Emp(2, "C", "D1");

        List<Emp> empList = new ArrayList<>();
        empList.add(e1);
        empList.add(e2);
        empList.add(e3);
        System.out.println(empList);
        Collections.sort(empList);
        System.out.println(empList);
        Collections.sort(empList, (a,b) -> a.getEmpDept().compareTo(b.empDept));
        System.out.println(empList);
    }
}
