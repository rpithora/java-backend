package com.shaurya._10linkedlist;

import java.util.HashSet;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
}
public class RemoveDuplicate {

    public void display(Node head){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void removeDuplicate(Node head){
        HashSet<Integer> hSet = new HashSet<>();
        Node current = head;
        Node prev = null;
        System.out.println(current);
        System.out.println(head);
        while (current != null){
            int curVal = current.data;
            if(hSet.contains(curVal)){
                prev.next = current.next;
            }else {
                hSet.add(curVal);
                prev = current;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(10);
        Node node2 = new Node(9, node1);
        Node node3 = new Node(4, node2);
        Node node4 = new Node(101, node3);
        Node node5 = new Node(89, node4);
        Node node6 = new Node(101, node5);
        Node node7 = new Node(10, node6);
        Node node8 = new Node(10, node7);

        Node head = node8;
        RemoveDuplicate removeDuplicate = new RemoveDuplicate();
        removeDuplicate.display(head);
        removeDuplicate.removeDuplicate(head);
        removeDuplicate.display(head);
    }
}
