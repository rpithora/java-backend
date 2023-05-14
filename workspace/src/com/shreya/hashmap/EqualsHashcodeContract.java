package com.shreya.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EqualsHashcodeContract {

    static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    static class Employee {
        private int id;
        private String name;
        private String location;

        public Employee(int id, String name, String location){
            this.id = id;
            this.name = name;
            this.location = location;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", location='" + location + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            Employee employee = (Employee) o;
            return id == employee.id && Objects.equals(name, employee.name) && Objects.equals(location, employee.location);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, location);
        }
    }
    public static void main(String[] args) {

        Employee employee1 = new Employee(1, "Udit", "Noida");
        Employee employee2 = new Employee(1, "Udit", "Noida");

        System.out.println("Employee1.equals(Employee2) : " + employee1.equals(employee2));

        Map<Employee,Employee> hMap = new HashMap<>();
        hMap.put(employee1, employee1);
        hMap.put(employee2, employee2);
        System.out.println(employee1.hashCode());
        System.out.println(employee2.hashCode());
        System.out.println("hMap.size() : " + hMap.size());

        HashMap<String, String > hm = new HashMap<>();
        hm.put("Aa", "Aa");
        hm.put("BB", "BB");
        System.out.println("hm.size() : " + hm.size());

    }
}
