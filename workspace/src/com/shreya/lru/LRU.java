package com.shreya.lru;

import java.util.HashMap;
import java.util.Map;

public class LRU {

    class Node{
        private int val;
        private Node next;
        private Node prev;

        Node(int val){
            this.val = val;
        }
    }

    public LRU(){
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
        hMap = new HashMap<>();
    }

    private Node head;
    private Node tail;
    private int size;

    private Map<Integer, Node> hMap ;
    private static final int CAPACITY = 5;

    public Node addToTail(int item){
        Node newNode = new Node(item);
        newNode.next = tail;
        newNode.prev = tail.prev;
        tail.prev = newNode;
        newNode.prev.next = newNode;
        size++;
        return newNode;
    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public Node removeAtHead(){
        Node node = head.next;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
        return node;
    }

    public void put(int item){
        if(hMap.containsKey(item)){
            Node node = hMap.get(item);
            remove(node);
            node = addToTail(item);
            hMap.put(item, node);
        }else{
            Node node;
            if (size >= CAPACITY) {
                node = removeAtHead();
                hMap.remove(node.val);
            }
            node = addToTail(item);
            hMap.put(item, node);
        }
    }

    public void display(){
        Node node = head.next;
        System.out.println();
        System.out.print("[ ");
        while (node != null && node.val != -1){
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.print("]");
        System.out.println();
    }

    public static void main(String[] args) {
        LRU lru = new LRU();
        lru.put(5);
        lru.display();
        lru.put(15);
        lru.display();
        lru.put(25);
        lru.display();
        lru.put(35);
        lru.display();
        lru.put(45);
        lru.display();
        lru.put(55);
        lru.display();
        lru.put(15);
        lru.display();
        lru.put(15);
        lru.display();
        lru.put(35);
        lru.display();
        System.out.println("LRU SIZE : " + lru.size);
        System.out.println("MAP SIZE : " + lru.hMap.size());
        System.out.println(lru.hMap);
    }
}
