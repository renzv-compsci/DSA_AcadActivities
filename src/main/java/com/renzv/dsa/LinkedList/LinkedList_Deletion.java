package com.renzv.dsa.LinkedList;

public class LinkedList_Deletion{
    static class node {
        int data;
        node next;
        node(int value) {
            data = value;
            next = null;
        }
    }
    static node head;

    static void printList() {
        node p = head;
        System.out.print("\n[");
        while (p != null) {
            System.out.print(p.data);
            if (p.next != null) {
                System.out.print(",");
            }
            p = p.next;
        }
        System.out.print("]");
    }
    // Renz Jerik C. Viloria 
    static void insertAtBegin(int data) {
        node lk = new node(data);
        lk.next = head;
        head = lk;
    }

    // Delete node at a specific position (1-based)
    static void deleteAtPosition(int pos) {
        if (head == null || pos <= 0) return;
        if (pos == 1) {
            head = head.next;
            return;
        }
        node prev = head;
        for (int i = 1; i < pos-1 && prev != null; i++) {
            prev = prev.next;
        }
        if (prev != null && prev.next != null) {
            prev.next = prev.next.next;
        }
    }
    // Renz Jerik C. Viloria 
    // Insert at a specific position (1-based)
    static void insertAtPosition(int pos, int data) {
        node newNode = new node(data);
        if (pos <= 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        node prev = head;
        for (int i = 1; i < pos-1 && prev != null; i++) {
            prev = prev.next;
        }
        if (prev != null) {
            newNode.next = prev.next;
            prev.next = newNode;
        }
    }

    // Sort the linked list (Selection Sort)
    static void sortList() {
        for (node i = head; i != null; i = i.next) {
            node min = i;
            for (node j = i.next; j != null; j = j.next) {
                if (j.data < min.data) min = j;
            }
            int temp = i.data;
            i.data = min.data;
            min.data = temp;
        }
    }
    // Renz Jerik C. Viloria 
    public static void main(String args[]) {
        insertAtBegin(12);
        insertAtBegin(22);
        insertAtBegin(30);
        insertAtBegin(44);
        insertAtBegin(50);
        insertAtBegin(33);

        System.out.print("Linked List: ");
        printList();

        // 1. Delete 6th position (n-1: go to 5th and remove next)
        deleteAtPosition(6);

        // 2. Delete 3rd position (n-1: go to 2nd and remove next)
        deleteAtPosition(3);

        // 3. Add 0 at position 2
        insertAtPosition(2, 0);

        // 4. Sort lowest to highest
        sortList();
        // 5. Delete position 4 (to remove 33)
        deleteAtPosition(4);

        System.out.print("\nLinked List after all operations: ");
        printList();

        // Renz Jerik C. Viloria 
    }
}
