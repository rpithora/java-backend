package com.shaurya._17striver._09linkedlist;

public class _03ReverseLinkedListRecursive {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        LinkedList linkedList = LinkedList.create(arr);
        System.out.println(linkedList);
        linkedList.head = reverse(linkedList.head);
        System.out.println(linkedList);
    }

    private static Node reverse(Node head) {

        if (null == head || null == head.next)
            return head;

        Node newHead = reverse(head.next);

        Node front = head.next;

        front.next = head;

        head.next = null;

        return newHead;
    }
}
