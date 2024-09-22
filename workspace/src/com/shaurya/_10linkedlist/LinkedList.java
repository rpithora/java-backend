package com.shaurya._10linkedlist;

public class LinkedList {
    public LinkedList add(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;

        int size1 = 0;
        int size2 = 0;

        size1 = getSize(temp1);
        size2 = getSize(temp2);

        System.out.println("size of LL 1 : " + size1);
        System.out.println("size of LL 2 : " + size2);

        temp1 = head1;
        temp2 = head2;

        LinkedList ans = new LinkedList();
        ans.insertFirst(0);

        int carry;

        if (size1 > size2) {
            carry = helper(temp1, temp2, ans.head, size1, size2);
        } else {
            carry = helper(temp2, temp1, ans.head, size2, size1);
        }

        if (carry == 1)
            ans.insertFirst(1);

        return ans;
    }

    private static int getSize(Node temp) {
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    public int helper(Node l1, Node l2, Node ans, int size1, int size2) {

        if (size1 == 0)
            return 0;

        //condition to only traverse over the bigger list
        if (size1 > size2 && size1 > 0) {
            if (size1 - 1 > 0)
                ans.next = new Node(0);

            ans.value = l1.value + helper(l1.next, l2, ans.next, size1 - 1, size2);
        }

        if (size1 == size2 && size1 > 0) {
            if (size1 - 1 > 0)
                ans.next = new Node(0);

            ans.value = l1.value + l2.value + helper(l1.next, l2.next, ans.next, size1 - 1, size2 - 1);
        }

        if (ans.value >= 10) {
            ans.value -= 10;
            return 1;
        }

        return 0;
    }

    public LinkedList addTwoNumbers(Node head1, Node head2) {
        head1 = reverse(head1);
        head2 = reverse(head2);

        Node dummy = new Node(0);
        Node temp = dummy;

        int carry = 0;

        while (head1 != null || head2 != null || carry != 0) {

            int d1 = (head1 != null) ? head1.value : 0;
            int d2 = (head2 != null) ? head2.value : 0;

            int sum = d1 + d2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            Node newNode = new Node(digit);
            temp.next = newNode;
            temp = temp.next;

            head1 = (head1 != null) ? head1.next : null;
            head2 = (head2 != null) ? head2.next : null;
        }

        LinkedList l1 = new LinkedList();
        l1.head = reverse(dummy.next);
        return l1;
    }

    private Node reverse(Node head) {
        Node current = head;
        Node next = null;
        Node prev = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    private class Node {
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
        }

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public Node head;
    private Node tail;
    private int size;

    public Node getHead() {
        return head;
    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void insert(int[] arr) {
        for (int value : arr) {
            insertLast(value);
        }
    }

    public void insertLast(int value) {
        if (tail == null) {
            insertFirst(value);
            return;
        }

        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int value, int index) {
        if (index <= 0) {
            insertFirst(value);
            return;
        }

        if (index > size) {
            insertLast(value);
            return;
        }

        Node temp = head;
        int counter = 1;
        while (counter < index) {
            temp = temp.next;
            counter++;
        }

        Node node = new Node(value);
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    public Integer deleteFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return null;
        }
        int value = head.value;
        head = head.next;

        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }

    public Integer deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }
        Node secondLast = get(size - 2);
        int value = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return value;
    }

    public Integer delete(int index) {
        if (index <= 1) {
            return deleteFirst();
        }

        if (index >= size) {
            return deleteLast();
        }

        Node prev = get(index - 1);

        Node toDel = prev.next;
        if (toDel == tail) {
            tail = prev;
        }
        int value = prev.next.value;
        prev.next = prev.next.next;

        size--;
        return value;
    }

    public Node get(int index) {
        int counter = 0;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public int size() {
        return size;
    }

    public int find(int value) {
        Node temp = head;
        int index = 0;
        while (temp != null) {
            index++;
            if (temp.value == value) {
                return index;
            }
            temp = temp.next;
        }
        return -1;
    }

    public void print() {
        if (head == null) {
            System.out.printf("List is empty.");
            return;
        }

        Node temp = head;
        System.out.printf("[ ");
        while (temp != null) {
            System.out.printf(temp.value + " ");
            temp = temp.next;
        }
        System.out.printf("]");
    }

    public int middleElement() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return 0;
            }
        }
        return slow.value;
    }

    public Node reverseBetween(int B, int C) {

        Node curr = head;
        Node prevN = null;
        int counter = 1;
        while (counter < B && curr != null) {
            prevN = curr;
            curr = curr.next;
            counter++;
        }

        Node prev = null;
        Node next = null;

        while (counter <= C && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            counter++;
        }
        prevN.next = prev;
        return prev;
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    Node reverse(Node head, int k) {
        if (head == null)
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
