package com.leetcode;

//
//  Merge Two Sorted Lists
//
//  Created by Nikhil Garg on 06/02/2021.
//  Copyright © 2021 Personal. All rights reserved.
//

public class MergeSortedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tNode = new ListNode(0);
        ListNode retNode = tNode;

        if(null == l1)
            return l2;

        if(null == l2){
            return l1;
        }

        while (l1!=null && l2!=null){
            if(l1.val>=l2.val) {
                retNode.next = l2;
                l2 = l2.next;
            }else {
                retNode.next = l1;
                l1 = l1.next;
            }
            retNode = retNode.next;
        }
        if(null!=l1){
            retNode.next = l1;
        }

        if(null!=l2){
            retNode.next = l2;
        }
        return tNode.next;
    }

}
