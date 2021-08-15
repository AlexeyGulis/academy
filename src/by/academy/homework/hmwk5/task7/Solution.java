package by.academy.homework.hmwk5.task7;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep) throws IOException {
        while (node != null) {
            System.out.print(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                System.out.print(sep);
            }
        }
    }

    // Complete the reverse function below.

    /*
     * For your reference:
     *
     * DoublyLinkedListNode { int data; DoublyLinkedListNode next;
     * DoublyLinkedListNode prev; }
     *
     */
    public static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        if (head != null) {
            if (head.next != null) {
                DoublyLinkedListNode tailToHead = reverse(head.next);
                if (head.prev != null) {
                    DoublyLinkedListNode temp = head.next;
                    head.next = head.prev;
                    head.prev = temp;
                    return tailToHead;
                } else {
                    head.prev = head.next;
                    head.next = null;
                    return tailToHead;
                }
            } else {
                head.next = head.prev;
                head.prev = null;
                return head;
            }
        }
        return null;
    }

    public static DoublyLinkedListNode reverseList(DoublyLinkedList list) {
        if (list.head != null && list.tail != null) {
            DoublyLinkedListNode temp1 = list.tail.prev;
            list.tail.next = list.tail.prev;
            list.tail.prev = null;
            while (temp1.prev != null) {
                DoublyLinkedListNode temp = temp1.prev;
                temp1.prev = temp1.next;
                temp1.next = temp;
                temp1 = temp;
            }
            list.head.prev = list.head.next;
            list.head.next = null;
            temp1 = list.head;
            list.head = list.tail;
            list.tail = temp1;
        }
        return list.head;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        DoublyLinkedList llist = new DoublyLinkedList();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            llist.insertNode(llistItem);
        }

        DoublyLinkedListNode head = reverseList(llist);

        //DoublyLinkedListNode llist1 = reverse(llist.head);

        printDoublyLinkedList(head, " ");
        scanner.close();
    }
}

