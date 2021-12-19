package com.example.problems.linkedlist;

import com.example.problems.assistant.LinkedListUtil;
import com.example.problems.assistant.ListNode;

/**
 * Created by lichunxia on 2019-09-05 14:49
 *
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 */
public class RemoveNthNodeFromEndofList {

    public static void main(String[] args) {
        ListNode listNode = LinkedListUtil.buildAList();
        RemoveNthNodeFromEndofList removeNthNodeFromEndofList = new RemoveNthNodeFromEndofList();
        ListNode node = removeNthNodeFromEndofList.removeNthFromEnd(listNode, 2);
        System.out.println();
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
     * Memory Usage: 35 MB, less than 100.00% of Java online submissions for Remove Nth Node From End of List.
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // ListNode newHead = new ListNode(0);
        // newHead.next = head;
        // ListNode slow = newHead;
        // ListNode fast = newHead;
        // int i = n;
        // while (i >= 0 ) {
        //     fast = fast.next;
        //     i--;
        // }
        //
        // while (fast != null) {
        //     fast = fast.next;
        //     slow = slow.next;
        // }
        //
        // slow.next = slow.next.next;
        // return newHead.next;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode p = newHead;
        ListNode runner = newHead;
        while(n>0){
            runner = runner.next;
            n--;
        }
        while(runner.next!=null){
            runner = runner.next;
            p=p.next;
        }
        p.next = p.next.next;
        return newHead.next;
    }
}
