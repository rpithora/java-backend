package com.shaurya._10linkedlist;

import java.util.HashMap;
import java.util.Map;

public class DeepCopyWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    Node head ;
    public void print(){
        if(head == null){
            System.out.printf("List is empty.");
            return;
        }

        Node temp = head;
        System.out.printf("[ ");
        while (temp != null){
            System.out.printf(" [ " + temp.val + " , " + (null !=temp.random?temp.random.val:"NULL" ) + " ] ");
            temp = temp.next;
        }
        System.out.printf("]");
    }

    public void createLL(){
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        n1.next = n2;
        n2.random = n1;
        Node n3 = new Node(11);
        n2.next = n3;
        Node n4 = new Node(10);
        n3.next = n4;
        n4.random = n3;
        Node n5 = new Node(1);
        n4.next = n5;
        n3.random = n5;
        n5.random = n1;
        head = n1;
    }
    public static void main(String[] args) {
        DeepCopyWithRandomPointer randomPointer = new DeepCopyWithRandomPointer();
        randomPointer.createLL();
        randomPointer.print();
        randomPointer.copyRandomList(randomPointer.head);
    }

    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Map<Node,Node> hMap = new HashMap();
        Node curr = head;
        Node nHead = null;
        Node tail = null;
        while(curr != null){
            Node temp =  new Node(curr.val);
            if(nHead == null){
                nHead = temp;
                tail = nHead;
            }else{
                tail.next = temp;
                tail = tail.next;
            }
            hMap.put(curr, temp);
            curr = curr.next;
        }
        curr = head;
        Node temp = nHead;
        while(curr != null){
            temp.random = hMap.get(curr.random);
            curr = curr.next;
            temp = temp.next;
        }
        return nHead;
    }
}
