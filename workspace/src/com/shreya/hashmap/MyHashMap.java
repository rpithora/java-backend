package com.shreya.hashmap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyHashMap<K, V> {
    private static final int INITIAL_SIZE = 1 << 4; //// 16
    public Entry[] hashTable;

    public MyHashMap() {
        hashTable = new Entry[INITIAL_SIZE];
    }

    class Entry<K, V> {
        public K key;
        public V value;
        public Entry next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + "key=" + key + ", value=" + value + '}';
        }
    }

    public void put(K key, V value) {
        int hashCode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashCode];

        if (null == node) {
            Entry newNode = new Entry(key, value);
            hashTable[hashCode] = newNode;
        } else {
            while (node != null) {
                if (node.key == key) {
                    node.value = value;
                    return;
                }
                node = node.next;
            }
            Entry newNode = new Entry(key, value);
            node = newNode;
        }
    }

    public V get(K key) {
        int hashCode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashCode];
        while (node != null) {
            if (node.key == key) {
                return (V) node.value;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("[ ");
        for (Entry entry : hashTable) {
            if (entry != null) buffer.append(entry.toString());
        }
        buffer.append(" ]");
        return buffer.toString();
    }

    public static void main(String[] args) {
        MyHashMap<Integer, String> hashMap = new MyHashMap<>();
        hashMap.put(1, "Rudra");
        hashMap.put(2, "Divya");
        hashMap.put(3, "Shreya");
        hashMap.put(4, "Shaurya");
        System.out.println(hashMap.get(3));
        System.out.println(hashMap);
        Map<Integer, Integer> map = new HashMap<>();
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1,1);
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
    }
}