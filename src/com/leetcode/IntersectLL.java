package com.leetcode;

//
//  Intersection of Two Linked Lists
//
//  Created by Nikhil Garg on 06/02/2021.
//  Copyright © 2021 Personal. All rights reserved.
//

public class IntersectLL {

        /*public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            Set<ListNode> aSet = new HashSet<>();

            if(headA==null || headB==null)
                return null;

            while (null != headA){
                aSet.add(headA);
                headA = headA.next;
            }

            while (null != headB){
                if(!aSet.contains(headB)){
                    headB = headB.next;
                }else {
                    return headB;
                }
            }
            return null;
        }*/

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptr1 = headA;
        ListNode ptr2 = headB;

        if(ptr1==null || ptr2==null)
            return null;

        int m=0, n=0;
        while (null != ptr1) {
            m++;
            ptr1 = ptr1.next;
        }

        while (null != ptr2) {
            n++;
            ptr2 = ptr2.next;
        }

        int d = Math.abs(m-n);

        if(m>n){
            return getIntersection(headB, headA, d);
        }else {
            return getIntersection(headA, headB, d);
        }


    }

    private ListNode getIntersection(ListNode ll1, ListNode ll2, int d) {

        ListNode ptr1 = ll1;
        ListNode ptr2 = ll2;

        for(int i=0; i<d; i++){
            if (ptr2 == null)
                return null;
            ptr2 = ptr2.next;
        }

        while (ptr1!=null && ptr2!=null){
            if(ptr1==ptr2){
                return ptr1;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        IntersectLL iLL = new IntersectLL();

        ListNode head1; ListNode head2;

        head1 = new ListNode(4);
        head1.next = new ListNode(1);

        head2 = new ListNode(5);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(1);


        head1.next.next = head2.next.next.next = new ListNode(8);
        head1.next.next.next = head2.next.next.next.next = new ListNode(4);
        head1.next.next.next.next = head2.next.next.next.next.next = new ListNode(5);

        System.out.println((iLL.getIntersectionNode(head1, head2)).val);

    }
}
