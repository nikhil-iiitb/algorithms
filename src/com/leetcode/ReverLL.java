package com.leetcode;

//Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }



public class ReverLL {

    /*public ListNode reverseList(ListNode head) {
        if(null == head)
            return null;

        if(null == head.next){
            return head;
        }
        ListNode retNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        head = retNode;
        return head;
    }*/

    public ListNode reverseList(ListNode head){
        if(null == head)
            return null;

        ListNode cNode = head;
        ListNode pNode = null;

        while (null != cNode){
            ListNode tNode = cNode.next;
            cNode.next = pNode;
            pNode = cNode;
            cNode = tNode;
        }
        return pNode;
    }

    public void printLL(ListNode head){
        ListNode ll = head;
        while (null != ll){
            System.out.print(ll.val + " ");
            ll = ll.next;
        }
    }

    public static void main(String[] args) {
        ReverLL rLL = new ReverLL();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        rLL.printLL(listNode);
        ListNode newList = rLL.reverseList(listNode);
        System.out.println();
        rLL.printLL(newList);
    }

}
