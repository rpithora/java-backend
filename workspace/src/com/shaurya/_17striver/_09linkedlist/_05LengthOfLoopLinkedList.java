package com.shaurya._17striver._09linkedlist;

/**
 * Length of Loop in Linked List
 * <p>
 * <p>
 * 22
 * <p>
 * 2
 * Problem Statement: Given the head of a linked list, determine the length of a loop present in the linked list; if not present, return 0.
 */
public class _05LengthOfLoopLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node first = new Node(2);
        Node second = new Node(3);
        Node third = new Node(4);
        Node fourth = new Node(5);

        head.next = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second;

        LinkedList linkedList = new LinkedList();
        linkedList.head = head;

        int length = findLength(linkedList.head);
        System.out.println(length);
    }

    private static int findLength(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return findLoopLength(head, fast);
        }
        return 0;
    }

    private static int findLoopLength(Node head, Node fast) {
        Node slow = head;
        int counter = 0;

        while (slow != fast) {
            ++counter;
            slow = slow.next;
            fast = fast.next;
        }
        return counter;
    }
}
