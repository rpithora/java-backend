package com.shaurya._10linkedlist;

public class CircularLL {

    private class Node{

        private int value ;
        private Node next ;

        Node(int value){
            this.value = value;
        }

        Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    private Node head;
    private int size;

    public void insertFirst(int value){
        Node node = new Node(value);
    }

    public void insert(int value){
        Node node = new Node(value);
        Node temp = head;
        if(head == null){
            head = node;
            node.next = node;
        }else{
            do{
                temp = temp.next;
            }while (temp.next != head);
            temp.next = node;
            node.next = head;
        }
    }

    public void display(){
        Node temp = head;
        System.out.print("[ ");
        do{
            System.out.print(temp.value+ " ");
            temp = temp.next;
        }while (temp != head);
        System.out.print("]");
    }
}
