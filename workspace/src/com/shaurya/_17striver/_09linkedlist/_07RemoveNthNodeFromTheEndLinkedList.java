package com.shaurya._17striver._09linkedlist;

/**
 * Problem Statement: Given a linked list and an integer N, the task is to delete the Nth node from the end of the linked list and print the updated linked list.
 * <p>
 * Examples
 * Example 1:
 * <p>
 * Input Format: 5->1->2, N=2
 * <p>
 * Result: 5->2
 */
public class _07RemoveNthNodeFromTheEndLinkedList {
    public static void main(String[] args) {
        int n = 3;
        int[] arr = {1, 2, 3, 4, 5};
        LinkedList linkedList = LinkedList.create(arr);
        System.out.println(linkedList);
        linkedList.head = deleteFromEnd(linkedList.head, n);
        System.out.println(linkedList);
    }

    private static Node deleteFromEnd(Node head, int n) {
        Node slow = head;
        Node fast = head;

        for (int i = 0; i < n; i++)
            fast = fast.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        Node toDel = slow;

        toDel.next = toDel.next.next;

        return head;
    }
}
