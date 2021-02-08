package com.leetcode;

//
//  Merge K Sorted Lists (using heap)
//
//  Created by Nikhil Garg on 06/02/2021.
//  Copyright © 2021 Personal. All rights reserved.
//

import java.util.Comparator;
import java.util.PriorityQueue;

class CustomComparator implements Comparator<ListNode>{

    public int compare(ListNode o1, ListNode o2){
        return o1.val - o2.val;
    }
}

public class MergeKSorted {

    public ListNode mergeKLists(ListNode[] lists) {
        if(null == lists)
            return null;



        int k = lists.length;
        if(k==0)
            return null;


        int idx=0, kList=0;
        ListNode head=null, tail=null;

        PriorityQueue<ListNode> pQ = new PriorityQueue<>(new CustomComparator());

        for(ListNode l : lists){
            if(l != null){
                pQ.offer(l);
            }
        }




        while (!pQ.isEmpty()){
            ListNode node = pQ.poll();

            if (null == head){
                head = tail = node;
            }else {
                tail.next = node;
                tail = node;
            }

            if(null != node.next)
                pQ.add(node.next);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode[] nArray = new ListNode[3];

        nArray[0] = new ListNode(1);
        nArray[0].next = new ListNode(4);
        nArray[0].next.next = new ListNode(7);

        nArray[1] = new ListNode(2);
        nArray[1].next = new ListNode(6);
        nArray[1].next.next = new ListNode(9);
        nArray[1].next.next.next = new ListNode(10);
        nArray[1].next.next.next.next = new ListNode(50);

        nArray[2] = new ListNode(3);
        nArray[2].next = new ListNode(5);
        nArray[2].next.next = new ListNode(16);
        nArray[2].next.next.next = new ListNode(20);
        nArray[2].next.next.next.next = new ListNode(35);

        MergeKSorted mergeKSorted = new MergeKSorted();
        mergeKSorted.mergeKLists(nArray);

    }

}
