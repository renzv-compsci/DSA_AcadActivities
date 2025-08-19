package com.renzv.dsa.LinkedList;

public class LinkedList_DeletionName {
    static class node {
        Object data;
        node next;
        node(Object value) {
            data = value;
            next = null;
        }
    }
    static node head;

    static void printList() {
        node p = head;
        System.out.print("[");
        while (p != null) {
            System.out.print(p.data);
            if (p.next != null) {
                System.out.print(",");
            }
            p = p.next;
        }
        System.out.println("]");
    }

    // Insert at a specific position (1-based)
    static void insertAtPosition(int pos, Object data) {
        node newNode = new node(data);
        if (pos <= 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        node prev = head;
        for (int i = 1; i < pos - 1 && prev != null; i++) {
            prev = prev.next;
        }
        if (prev != null) {
            newNode.next = prev.next;
            prev.next = newNode;
        }
    }

    // Delete node at a specific position (1-based)
    static void deleteAtPosition(int pos) {
        if (head == null || pos <= 0) return;
        if (pos == 1) {
            head = head.next;
            return;
        }
        node prev = head;
        for (int i = 1; i < pos - 1 && prev != null; i++) {
            prev = prev.next;
        }
        if (prev != null && prev.next != null) {
            prev.next = prev.next.next;
        }
    }

    // Sort only numeric nodes, keep string at position 4 (1-based)
    static void sortNumericsExcept4th() {
        java.util.List<Integer> nums = new java.util.ArrayList<>();
        node p = head;
        int idx = 1;
        while (p != null) {
            if (idx != 4 && p.data instanceof Integer)
                nums.add((Integer)p.data);
            p = p.next;
            idx++;
        }
        java.util.Collections.sort(nums);

        p = head;
        idx = 1;
        int numIdx = 0;
        while (p != null) {
            if (idx != 4 && p.data instanceof Integer) {
                p.data = nums.get(numIdx++);
            }
            p = p.next;
            idx++;
        }
    }

    public static void main(String[] args) {
        // Build the list
        insertAtPosition(1, 33);
        insertAtPosition(2, 50);
        insertAtPosition(3, 44);
        insertAtPosition(4, 30);
        insertAtPosition(5, 22);
        insertAtPosition(6, 12);

        deleteAtPosition(6); // Remove 12
        deleteAtPosition(3); // Remove 44
        insertAtPosition(2, 0); // Insert 0 at pos 2

        System.out.print("Before (unsorted, no string): ");
        printList();

        insertAtPosition(4, "Renz Viloria"); // Insert string at position 4

        System.out.print("Before (with string at pos 4): ");
        printList();

        deleteAtPosition(1); // Remove 33

        sortNumericsExcept4th();

        // Trim list to 5 nodes (0,22,30,"Renz Viloria",50)
        node p = head;
        for (int i = 1; i < 5 && p != null; i++) {
            p = p.next;
        }
        if (p != null) p.next = null;

        System.out.print("After (sorted numerics, string at pos 4): ");
        printList();
    }
}
