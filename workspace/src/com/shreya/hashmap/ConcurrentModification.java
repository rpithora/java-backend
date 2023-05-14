package com.shreya.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ConcurrentModification {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("key1", "value1");
        hashMap.put("key2", "value2");
        hashMap.put("key3", "value3");
        hashMap.put("key4", "value4");

        Iterator<String> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
            //hashMap.remove("key1");
            System.out.println(hashMap);
        }

        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.println("Here ::: " + list);
            Integer value = it.next(); // If List is modified .next() will throw ConcurrentModificationException
            System.out.println("List Value:" + value);
            if (value.equals(3)) {
                //it.remove(); // This will not throw ConcurrentModificationException
                list.remove(value); // This will remove the item but throw ConcurrentModificationException on next()
                /**
                 * ConcurrentModificationException is thrown when the next() method
                 * is called as the iterator is iterating the List, and we are making
                 * modifications in it simultaneously.
                 */
                break;//
            }
        }
        System.out.println(list);
    }
}
