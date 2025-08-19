package com.renzv.dsa.LinkedList;

public class LinkedList_Insertion {
    static class node {
        int data;
        node next;

        node(int value) {
            data = value;
            next = null;
        }
    }

    // Renz Jerik C. Viloria 

    static node head;

    static void printList() {
        node p = head;
        System.out.print("\n[");
        while (p != null) {
            System.out.print(" " + p.data + " ");
            p = p.next;
        }
        System.out.print("]");
    }
    
    static void insertatend(int data) {
        node lk = new node(data);

        if(head == null) {
            head = lk;
            return;
        }

        node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = lk;
    }

    // Renz Jerik C. Viloria 

    static void findDuplicates() {
        // Start from the head of the linked list
        node current = head;
        int index = 0;
        
        System.out.println("\nChecking for duplicates:");
        
        // OUTER LOOP: Traverse through each node in the list
        while (current != null) {
            // INNER LOOP: For each current node, check all remaining nodes after it
            node runner = current.next;  // Start runner from the next node
            int runnerIndex = index + 1;  // Runner's index starts from current index + 1
            
            // Compare current node with all nodes that come after it
            while (runner != null) {
                // If we find a match, it's a duplicate!
                if (current.data == runner.data) {
                    System.out.println("Duplicate # is: " + current.data + "\nin Array index at #: " + index + " & " + runnerIndex);
                }
                // Move runner to the next node and increment its index
                runner = runner.next;
                runnerIndex++;
            }
            // Move current to the next node and increment its index
            current = current.next;
            index++;
        }
    }
        // Renz Jerik C. Viloria 
        public static void main(String args[]) {
        // Add some numbers with duplicates in ascending order
        insertatend(5);
        insertatend(12);
        insertatend(22);
        insertatend(12);  // Duplicate of 12
        insertatend(30);
        insertatend(44);
        insertatend(22);  // Duplicate of 22
        insertatend(50);
        
        System.out.print("Linked List: ");
        printList();
        // Find duplicates
        findDuplicates();
    }
    // Renz Jerik C. Viloria 
}
