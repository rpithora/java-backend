package com.shreya.hashmap;

import java.util.LinkedHashMap;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("one", 1);
        linkedHashMap.put("two", 2);
        linkedHashMap.put("three", 3);
        linkedHashMap.put("four", 4);
        linkedHashMap.put("one", 11);
        System.out.println(linkedHashMap);

        LinkedHashMap linkedHashMapAccessOrder = new LinkedHashMap(2, .75f, true);
        linkedHashMapAccessOrder.put("one", 1);
        linkedHashMapAccessOrder.put("two", 2);
        linkedHashMapAccessOrder.put("three", 3);
        linkedHashMapAccessOrder.put("four", 4);
        linkedHashMapAccessOrder.put("one", 11);
        linkedHashMapAccessOrder.get("two");
        System.out.println(linkedHashMapAccessOrder);
    }
}
