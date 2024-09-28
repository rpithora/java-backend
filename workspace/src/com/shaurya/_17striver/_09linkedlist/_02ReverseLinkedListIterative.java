package com.shaurya._17striver._09linkedlist;

public class _02ReverseLinkedListIterative {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        LinkedList linkedList = LinkedList.create(arr);
        System.out.println(linkedList);
        linkedList.head = reverse(linkedList.head);
        System.out.println(linkedList);
    }

    private static Node reverse(Node head) {
        Node current = head;
        Node prev = null;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
