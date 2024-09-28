package com.shaurya._17striver._09linkedlist;

public class _08MergeSortLinkedList {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        LinkedList linkedList = LinkedList.create(arr);
        System.out.println(linkedList);
        linkedList.head = mergeSort(linkedList.head);
        System.out.println(linkedList);
    }

    private static Node mergeSort(Node head) {

        if (null == head || null == head.next)
            return head;

        Node middleElement = getMiddleElement(head);

        Node rightElement = middleElement.next;
        middleElement.next = null;
        Node leftElement = head;

        leftElement = mergeSort(leftElement);
        rightElement = mergeSort(rightElement);

        return merge(leftElement, rightElement);
    }

    private static Node merge(Node left, Node right) {
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;

        while (left != null && right != null) {
            if (left.val < right.val) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }

        if (left != null)
            temp.next = left;
        else
            temp.next = right;

        return dummyNode.next;
    }

    private static Node getMiddleElement(Node head) {

        if (head == null || head.next == null)
            return head;

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
