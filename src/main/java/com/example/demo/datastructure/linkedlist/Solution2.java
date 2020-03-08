package com.example.demo.datastructure.linkedlist;

import com.example.demo.assistant.ListNode;

/**
 * @Author: lcx
 * @Date: 2018/12/7 13:59
 * @Description:
 */

public class Solution2 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        if (head == null) {
            return null;
        }
        ListNode pre = dummyHead;
        while (pre.next != null) {
            if (pre.next.val == val){
                ListNode delNode = pre.next;
                pre.next = delNode.next;
                delNode.next = null;
            } else {
                pre = pre.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        System.out.println(new Solution2().removeElements(head, 6));
    }
}
