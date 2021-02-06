package com.leetcode;

/**
 * Definition for singly-linked list.**/

public class LinkedListCycle {

    static ListNode head;

    public boolean hasCycle(ListNode head) {
        ListNode sPtr = head;
        ListNode fPtr = head;

        while(sPtr!=null && fPtr!=null && fPtr.next!=null){
            sPtr=sPtr.next;
            fPtr=fPtr.next.next;
            if(sPtr==fPtr){
                return true;
            }
        }
        return false;
    }

    void printList(ListNode node)
    {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
    
    public static void main(String[] args)
    {
        LinkedListCycle list = new LinkedListCycle();
        list.head = new ListNode(50);
        list.head.next = new ListNode(20);
        list.head.next.next = new ListNode(15);
        list.head.next.next.next = new ListNode(4);
        list.head.next.next.next.next = new ListNode(10);

        // Creating a loop for testing
        head.next.next.next.next.next = head.next.next;
        System.out.println(list.hasCycle(head));
        //System.out.println("Linked List after removing loop : ");
        //list.printList(head);
    }
}