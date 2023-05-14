package com.shreya.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class InheritanceDemo {
    public void method1() throws IOException {
        System.out.println("Throw IO exception.");
        throw new IOException();
    }
}

class Child1 extends InheritanceDemo {
    public void method1() {
        System.out.println("In here in Child.");
    }

    public static void main(String[] args) throws IOException {
        InheritanceDemo child1 = new Child1();
        child1.method1();
    }
}
