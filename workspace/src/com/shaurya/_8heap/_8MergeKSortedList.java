package com.shaurya._8heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class _8MergeKSortedList {

    public static void main(String[] args) {
        _8MergeKSortedList l1 = new _8MergeKSortedList();
        l1.insertFirst(5);
        l1.insertFirst(4);
        l1.insertFirst(1);
        l1.print();
        _8MergeKSortedList l2 = new _8MergeKSortedList();
        l2.insertFirst(4);
        l2.insertFirst(3);
        l2.insertFirst(1);
        l2.print();
        _8MergeKSortedList l3 = new _8MergeKSortedList();
        l3.insertFirst(6);
        l3.insertFirst(2);
        l3.print();

        List<_8MergeKSortedList> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);
        list.add(l3);
        l1.solution(list);
    }

    public class Node{
        private int value;
        private Node next;

        Node(int value){
            this.value = value;
        }

        Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    private Node head;

    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;
    }

    public void print(){
        if(head == null){
            System.out.printf("List is empty.");
            return;
        }

        Node temp = head;
        System.out.printf("[ ");
        while (temp != null){
            System.out.printf(temp.value + " ");
            temp = temp.next;
        }
        System.out.printf("]");
    }

    private void solution(List<_8MergeKSortedList> list) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.value-b.value);
        for(_8MergeKSortedList l : list){
            Node temp = l.head;
            while (temp != null){
                minHeap.offer(temp);
                temp = temp.next;
            }
        }
        Node temp = new Node(minHeap.poll().value);
        Node head = temp;
        while (!minHeap.isEmpty()){
            Node newNode = new Node(minHeap.poll().value);
            temp.next = newNode;
            temp = temp.next;
        }
        temp = head;
        System.out.printf("\\\n Merged List");
        System.out.print("[ ");
        while (temp != null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.printf("]");
    }
}
