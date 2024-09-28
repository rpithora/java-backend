package com.shaurya._17striver._09linkedlist;

/**
 * Detect a Cycle in a Linked List
 * <p>
 * <p>
 * 101
 * <p>
 * 4
 * Examples
 * Example 1:
 * <p>
 * Input Format:
 * <p>
 * LL: 1 2 3 4 5
 * Result: True
 * <p>
 * Explanation: The last node with the value of 5 has its 'next' pointer pointing back to a previous node with the value of 3. This has resulted in a loop, hence we return true.
 */
public class _04FindLoopInLinkedList {
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
        fourth.next = third;

        LinkedList linkedList = new LinkedList();
        linkedList.head = head;

        //System.out.println(linkedList);

        boolean detectLoop = detectLoop(linkedList.head);
        System.out.println(detectLoop);

        int startPoint = loopStartPoint(linkedList.head);
        System.out.println(startPoint);

    }

    private static boolean detectLoop(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow)
                return true;
        }

        return false;
    }

    private static int loopStartPoint(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow.val;
            }
        }

        return -1;
    }
}
