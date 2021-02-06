package com.leetcode;

//
//  Linked List Cycle
//
//  Created by Nikhil Garg on 06/02/2021.
//  Copyright © 2021 Personal. All rights reserved.
//

public class LinkedListCycle {

    static ListNode head;

    public boolean hasCycle(ListNode head) {
        ListNode sPtr = head;
        ListNode fPtr = head;

        while(sPtr!=null && fPtr!=null && fPtr.next!=null){
            sPtr=sPtr.next;
            fPtr=fPtr.next.next;
            if(sPtr==fPtr){
                this.removeCycle(sPtr, head);
                return true;
            }
        }
        return false;
    }

    private void removeCycle(ListNode sPtr, ListNode head) {
        ListNode ptr1 = sPtr;
        ListNode ptr2 = sPtr;

        int k=1;
        while (ptr1.next!=ptr2){
            ptr1 = ptr1.next;
            k++;
        }
        System.out.println(k);

        ptr1 = head; ptr2 = head;

        for(int i=0; i<k; i++){
            ptr2 = ptr2.next;
        }

        while (ptr1!=ptr2){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        while (ptr2.next!=ptr1){
            ptr2 = ptr2.next;
        }
        ptr2.next = null;
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
        list.head.next.next.next.next.next = new ListNode(3);
        list.head.next.next.next.next.next.next = new ListNode(2);
        list.head.next.next.next.next.next.next.next = new ListNode(1);

        // Creating a loop for testing
        list.head.next.next.next.next.next.next.next.next = head.next.next;
        System.out.println(list.hasCycle(head));
        System.out.println("Linked List after removing loop : ");
        list.printList(head);
    }
}