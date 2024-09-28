package com.shaurya._17striver._09linkedlist;

public class _06CheckIfTheGivenLinkedListPalindrome {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 2, 1};
        LinkedList linkedList = LinkedList.create(arr);
        System.out.println(linkedList);
        boolean isPalindrome = isPalindrome(linkedList.head);
        System.out.println(isPalindrome);
        System.out.println(linkedList);
    }

    private static boolean isPalindrome(Node head) {

        Node slow = head;
        Node fast = head;

        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node newHead = reverse(slow);

        Node first = head;
        Node second = newHead;

        while (second != null) {
            if (first.val != second.val) {
                reverse(newHead);
                return false;
            }

            second = second.next;
            first = first.next;
        }

        reverse(newHead);

        return true;
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
