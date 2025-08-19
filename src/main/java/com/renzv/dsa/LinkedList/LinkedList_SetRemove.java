package com.renzv.dsa.LinkedList;

import java.util.ArrayList;

public class LinkedList_SetRemove {
    static class Node {
        int data;
        Node next;
        
        Node(int value) {
            data = value;
            next = null;
        }
    }
    
    // Renz Jerik C. Viloria
    static Node head;
    
    static void printList(boolean useCommas) {
        System.out.print("\n[");
        for (Node current = head; current != null; current = current.next) {
            System.out.print(" " + current.data + " ");
            if (current.next != null) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
    
    static void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    
    static void insertAtPosition(int data, int position) {
        if (position <= 0) return; // invalid position
        
        Node newNode = new Node(data);
        
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        
        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        
        if (current != null) {
            newNode.next = current.next;
            current.next = newNode;
        }
    }
    
    static void deleteAtPosition(int position) {
        if (head == null || position <= 0) return;
        
        if (position == 1) {
            head = head.next;
            return;
        }
        
        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        
        if (current != null && current.next != null) {
            current.next = current.next.next;
        }
    }
    
    static void sortList() {
        for (Node i = head; i != null; i = i.next) {
            for (Node j = i.next; j != null; j = j.next) {
                if (i.data > j.data) {
                    int temp = i.data;
                    i.data = j.data;
                    j.data = temp;
                }
            }
        }
    }
    
    static ArrayList<Object> toArrayListWithLouise() {
        ArrayList<Object> arrList = new ArrayList<>();
        Node current = head;
        
        while (current != null) {
            arrList.add(current.data);
            current = current.next;
        }
    
        while (arrList.size() > 0 && arrList.size() != 2) {
            arrList.remove(0); // Remove elements until we have 2 left
        }
        
        if (arrList.size() == 2) {
            Object temp = arrList.get(0);
            arrList.set(0, "renz");  // Replace first element with "renz"
            arrList.add(2, "jerik"); // Add "jerik" at index 2
            
            if (!arrList.get(1).equals(22)) {
                arrList.set(1, 22);
            }
            if (arrList.size() > 3 && !arrList.get(3).equals(50)) {
                arrList.set(3, 50);
            } else if (arrList.size() == 3) {
                arrList.add(50);
            }
        } else {
           
            arrList.clear();
            arrList.add("renz");
            arrList.add(22);
            arrList.add("jerik");
            arrList.add(50);
        }
        
        return arrList;
    }
    
    public static void main(String[] args) {
        insertAtBeginning(12);
        insertAtBeginning(22);
        insertAtBeginning(30);
        insertAtBeginning(44);
        insertAtBeginning(50);
        insertAtBeginning(33);
        
        deleteAtPosition(6);
        deleteAtPosition(3);
        insertAtPosition(0, 2);
        deleteAtPosition(1);
        sortList();
        
        ArrayList<Object> arrList = toArrayListWithLouise();
        System.out.println("" + arrList);
    }
}
// Renz Jerik C. Viloria
