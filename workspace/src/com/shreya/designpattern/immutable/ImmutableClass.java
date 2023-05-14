package com.shreya.designpattern.immutable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class ImmutableClass {

    private final String name;
    private final List<Integer> arrList;
    public ImmutableClass(final String name, final List<Integer> arrList){
        this.name = name;
        //this.arrList = arrList;// we should do the deep copy
        this.arrList = arrList.stream().collect(Collectors.toList());
    }

    public String getName(){
        return name;
    }

    public List<Integer> getArrList(){
        return arrList.stream().collect(Collectors.toList());
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
