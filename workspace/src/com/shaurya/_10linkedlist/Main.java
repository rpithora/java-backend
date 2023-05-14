package com.shaurya._10linkedlist;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertFirst(10);
        linkedList.insertFirst(20);
        linkedList.print();
        System.out.println();
        linkedList.insert(30,0);
        linkedList.insert(50,2);
        linkedList.insertLast(40);
        System.out.println();
        linkedList.print();
        System.out.println();
        System.out.println("List size : "+linkedList.size());
        System.out.println();
        System.out.println(linkedList.deleteFirst());
        System.out.println(linkedList.deleteLast());
        System.out.println();
        linkedList.print();
        System.out.println(linkedList.delete(2));
        System.out.println();
        linkedList.print();
        System.out.println();
        System.out.println("size : "+linkedList.size());
        System.out.println(linkedList.find(50));
        linkedList.insertLast(78);
        linkedList.insertLast(8);
        linkedList.insertLast(58);
        System.out.println();
        linkedList.print();
        System.out.println();
        System.out.println("size : "+linkedList.size());
        linkedList.print();
        System.out.println();
        System.out.println(linkedList.middleElement());
        linkedList.reverse();
        System.out.println();
        linkedList.print();
        linkedList.reverseBetween(2, 4);
        System.out.println();
        linkedList.print();
        System.out.println();
        linkedList.head = linkedList.reverse(linkedList.head, 2);
        linkedList.print();
    }
}