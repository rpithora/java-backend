package com.shaurya._10linkedlist;

public class LinkedList {
    private class Node{
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

    public Node head;
    private Node tail;
    private int size;

    public Node getHead(){
        return head;
    }

    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;
        if(tail == null){
            tail = head;
        }
        size++;
    }

    public void insertLast(int value){
        if(tail == null){
            insertFirst(value);
            return;
        }

        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int value, int index){
        if(index <= 0){
            insertFirst(value);
            return;
        }

        if(index > size){
            insertLast(value);
            return;
        }

        Node temp = head;
        int counter = 1;
        while (counter < index){
            temp = temp.next;
            counter++;
        }

        Node node = new Node(value);
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    public Integer deleteFirst(){
        if(head == null){
            System.out.println("List is empty");
            return null;
        }
        int value = head.value;
        head = head.next;

        if(head == null){
            tail = null;
        }
        size --;
        return value;
    }

    public Integer deleteLast(){
        if(size <=1){
            return deleteFirst();
        }
        Node secondLast = get(size-2);
        int value = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return value;
    }

    public Integer delete(int index){
        if(index <= 1){
            return deleteFirst();
        }

        if(index >= size){
            return deleteLast();
        }

        Node prev = get(index-1);

        Node toDel = prev.next;
        if(toDel == tail){
            tail = prev;
        }
        int value = prev.next.value;
        prev.next = prev.next.next;

        size--;
        return value;
    }

    public Node get(int index){
        int counter = 0;
        Node temp = head;
        for(int i=0; i<index; i++){
            temp = temp.next;
        }
        return temp;
    }

    public int size(){
        return size;
    }

    public int find(int value){
        Node temp = head;
        int index = 0;
        while (temp != null){
            index ++ ;
            if(temp.value == value){
                return index;
            }
            temp = temp.next;
        }
        return -1;
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

    public int middleElement(){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return 0;
            }
        }
        return slow.value;
    }

    public Node reverseBetween(int B, int C) {

        Node curr = head;
        Node prevN = null;
        int counter = 1;
        while(counter < B && curr != null){
            prevN = curr;
            curr = curr.next;
            counter++;
        }

        Node prev = null;
        Node next = null;

        while(counter <= C && curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            counter++;
        }
        prevN.next = prev;
        return prev;
    }

    public void reverse(){
        Node prev = null;
        Node current = head;
        Node next = null;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    Node reverse(Node head, int k)
    {
        if(head == null)
            return null;
        Node current = head;
        Node next = null;
        Node prev = null;

        int count = 0;

        /* Reverse first k nodes of linked list */
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        /* next is now a pointer to (k+1)th node
           Recursively call for the list starting from
           current. And make rest of the list as next of
           first node */
        if (next != null)
            head.next = reverse(next, k);

        // prev is now head of input list
        return prev;
    }
}
