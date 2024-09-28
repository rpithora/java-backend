package com.shaurya._17striver._09linkedlist;

/**
 * Find middle element in a Linked List
 * <p>
 * <p>
 * 111
 * <p>
 * 4
 * Problem Statement: Given the head of a linked list of integers, determine the middle node of the linked list. However, if the linked list has an even number of nodes, return the second middle node.
 * <p>
 * Examples
 * Example 1:
 * Input: LL: 1  2  3  4  5
 * Output: 3
 * Explanation: Node with value 3 is the middle node of this linked list.
 */
public class _01FindMiddleElementLinkedList {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        LinkedList linkedList = LinkedList.create(arr);
        System.out.println(linkedList);

        int middleElement = findMiddle(linkedList.head);
        System.out.println(middleElement);

    }

    private static int findMiddle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow.val;
    }
}
