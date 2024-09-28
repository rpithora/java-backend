package com.shaurya._17striver._09linkedlist;

public class LinkedList {
    protected Node head;
    protected Node tail;
    protected int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public static LinkedList create(int[] arr) {
        LinkedList temp = new LinkedList();

        temp.insertAtStart(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            temp.insertAtEnd(arr[i]);
        }
        return temp;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        linkedList.insertAtStart(1);
        linkedList.insertAtStart(2);
        linkedList.insertAtEnd(3);
        linkedList.insertAtEnd(4);
        linkedList.insertAtIndex(3, 5);
        linkedList.insertAtStart(6);
        linkedList.insertAtEnd(8);
        linkedList.insertAtIndex(3, 510);

        System.out.println(linkedList);
        System.out.println("head : " + linkedList.head);
        System.out.println("tail : " + linkedList.tail);
        System.out.println("size : " + "[ " + linkedList.size + " ]");

        System.out.println("***after delete");

        linkedList.deleteAtStart();
        linkedList.deleteAtEnd();
        linkedList.deleteAtEnd();
        linkedList.deleteAtIndex(3);

        System.out.println(linkedList);
        System.out.println("head : " + linkedList.head);
        System.out.println("tail : " + linkedList.tail);
        System.out.println("size : " + "[ " + linkedList.size + " ]");

    }

    private static LinkedList createLinkedList(int[] arr) {
        LinkedList list = new LinkedList();

        list.head = new Node(arr[0]);

        Node temp = list.head;

        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }

        return list;
    }

    private void deleteAtIndex(int index) {
        if (index <= 1) {
            deleteAtStart();
            return;
        }
        if (index >= size) {
            deleteAtEnd();
            return;
        }

        Node prev = getNode(index - 1);

        prev.next = prev.next.next;

        --size;
    }

    private void deleteAtEnd() {
        if (null == tail)
            throw new RuntimeException("no element in the LinkedList");

        Node secondLastNode = getNode(size - 1);
        secondLastNode.next = null;

        tail = secondLastNode;
        --size;
    }

    private void deleteAtStart() {

        if (null == head)
            throw new RuntimeException("no element in the LinkedList");

        head = head.next;

        if (null == head)
            tail = null;

        --size;
    }

    private void insertAtIndex(int index, int val) {

        if (index <= 1) {
            insertAtStart(val);
            return;
        }
        if (index >= size) {
            insertAtEnd(val);
            return;
        }

        Node newNode = new Node(val);

        Node prev = getNode(index - 1);

        newNode.next = prev.next;
        prev.next = newNode;
        ++size;
    }

    private Node getNode(int index) {
        Node temp = head;
        int count = 0;

        while (temp != null) {
            ++count;

            if (count == index)
                return temp;

            temp = temp.next;
        }

        throw new RuntimeException("index does not exists!");
    }

    private void insertAtEnd(int val) {
        if (null == head) {
            insertAtStart(val);
            return;
        }

        Node newNode = new Node(val);

        tail.next = newNode;
        tail = newNode;
        ++size;
    }

    private void insertAtStart(int val) {

        Node newNode = new Node(val);

        if (null == head) {
            head = newNode;
            tail = head;
        } else {
            newNode.next = head;
            head = newNode;
        }

        ++size;
    }

    @Override
    public String toString() {

        Node temp = head;
        StringBuilder builder = new StringBuilder();
        builder.append("LinkedList [ ");

        while (temp != null) {
            builder.append(temp.val).append(" ");
            temp = temp.next;
        }

        builder.append("]");

        return builder.toString();
    }
}
