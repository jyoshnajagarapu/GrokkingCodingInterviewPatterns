package TwoPointer;

import java.util.*;
//Time complexity#
//The time complexity is O(n), where n is the number of nodes in the linked list.
//Space complexity
//The space complexity is O(1) because we use constant space to store two pointers.
class RemoveNthNode {

    public static LinkedListNode removeNthLastNode(LinkedListNode head, int n) {
        LinkedListNode right = head;
        LinkedListNode left = head;
        int count = 0;
        while(count < n && right.next!=null){
            right = right.next;
            count++;
        }
        if(n - count == 1){
            head = head.next;
        }else{
            while(right.next != null){
                right = right.next;
                left = left.next;
            }
            left.next = left.next.next;
        }
        return head;
    }


//below are helper classes

    // Driver Code
    public static void main(String[] args) {
        int[][] inputs = {
                {23, 89, 10, 5, 67, 39, 70,28},
                {34, 53, 6, 95, 38, 28, 17, 63, 16, 76},
                {288, 224, 275, 390, 4, 383, 330, 60, 193},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {69, 8, 49, 106, 116, 112, 104, 129, 39, 14, 27, 12}
        };

        int[] n = {4, 1, 6, 9, 11};

        for (int i = 0; i < inputs.length; i++) {
            LinkedList < Integer > inputLinkedList = new LinkedList < Integer > ();
            inputLinkedList.createLinkedList(inputs[i]);
            System.out.print((i + 1) + ".\tLinked List:\t\t");
            PrintList.printListWithForwardArrow(inputLinkedList.head);
            System.out.print("\n\tn = " + n[i]);
            System.out.print("\n\tUpdated Linked List:\t");
            PrintList.printListWithForwardArrow(removeNthLastNode(inputLinkedList.head, n[i]));
            System.out.println();
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}

class LinkedListNode {
    public int data;
    public LinkedListNode next;
    // LinkedListNode() will be used to make a LinkedListNode type object.
    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

// Template for printing the linked list with forward arrows
class PrintList
{
    public static void printListWithForwardArrow(LinkedListNode head)
    {
        LinkedListNode temp = head;

        while (temp != null) {
            System.out.print(temp.data); // print node value
            temp = temp.next;
            if (temp != null) {
                System.out.print(" → ");
            }
        }
        // if this is the last node, print null at the end
        System.out.print(" → null ");
    }
}

// Template for the linked list
class LinkedList<T> {
    public LinkedListNode head;
    // constructor will be used to make a LinkedList type object
    public LinkedList() {
        this.head = null;
    }
    // insertNodeAtHead method will insert a LinkedListNode at head
    // of a linked list.
    public void insertNodeAtHead(LinkedListNode node) {
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }
    // createLinkedList method will create the linked list using the
    // given integer array with the help of InsertAthead method.
    public void createLinkedList(int[] lst) {
        for (int i = lst.length - 1; i >= 0; i--) {
            LinkedListNode newNode = new LinkedListNode(lst[i]);
            insertNodeAtHead(newNode);
        }
    }


}