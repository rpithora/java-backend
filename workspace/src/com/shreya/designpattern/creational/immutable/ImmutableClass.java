package com.shreya.designpattern.creational.immutable;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableClass {

    private final String name;
    private final List<Integer> arrList;
    public ImmutableClass(final String name, final List<Integer> arrList){
        this.name = name;
        //this.arrList = arrList;// we should do the deep copy
        //this.arrList = arrList.stream().collect(Collectors.toList());
        this.arrList = new ArrayList<>(arrList);
    }

    public String getName(){
        return name;
    }

    public List<Integer> getArrList(){
        return new ArrayList<>(arrList);
    }

    public static void main(String[] args) {
        List<Integer> al = new ArrayList<>();
        al.add(23);
        al.add(5);
        ImmutableClass immutableClass = new ImmutableClass("abc", al);
        System.out.println(immutableClass.getName());
        immutableClass.getArrList().forEach(s -> System.out.print(s + " "));
        System.out.println();
        al.add(100);
        immutableClass.getArrList().forEach(s -> System.out.print(s + " "));
    }
}
