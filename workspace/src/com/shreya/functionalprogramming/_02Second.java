package com.shreya.functionalprogramming;

public class _02Second {
    protected static class Person {
        private String name;
        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    protected static class DataLoader {

        public final NoArgFunction<Person> loader;

        public DataLoader(boolean isDevelopment) {
            this.loader = isDevelopment ? this::loadFakePerson : this::loadRealPerson;
        }

        public Person loadRealPerson() {
            System.out.println("loading real person ...");
            return new Person("Real Person", 30);
        }

        public Person loadFakePerson() {
            System.out.println("loading fake person ...");
            return new Person("Fake Person", 300);
        }
    }

    public static void main(String[] args) {
        DataLoader dataLoader = new DataLoader(true);
        System.out.println(dataLoader.loader.apply());
    }
}
