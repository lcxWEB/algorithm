package com.example.problems.linkedlist;

import com.example.problems.assistant.LinkedListUtil;
import com.example.problems.assistant.ListNode;

import java.util.List;

/**
 * @author: lichunxia
 * @create: 12/6/21 6:55 PM
 */
public class ReversBetween {

    public static void main(String[] args) {
        ListNode build = LinkedListUtil.build(5);
        ListNode listNode = reverseBetween(build, 2, 4);
        LinkedListUtil.print(listNode);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode succ = dummy;
        int i = 0;
        while(i < left - 1) {
            pre = pre.next;
            succ = succ.next;
            i++;
        }
        int count = right - left + 1;
        while (count > 0) {
            succ = succ.next;
            count--;
        }

        ListNode begin = pre.next;
        ListNode end = succ.next;
        pre.next = null;
        succ.next = null;

        ListNode reverse = reverse(begin);
        pre.next = reverse;
        begin.next = end;
        return dummy.next;
    }

    static ListNode reverse(ListNode begin) {
        ListNode curr = begin;
        ListNode pre = null;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }

        return pre;
    }

}
