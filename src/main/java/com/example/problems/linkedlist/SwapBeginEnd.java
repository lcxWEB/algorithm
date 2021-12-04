package com.example.problems.linkedlist;

import com.example.problems.assistant.LinkedListUtil;
import com.example.problems.assistant.ListNode;

/**
 * @author: lichunxia
 * @create: 12/1/21 5:08 PM
 */
public class SwapBeginEnd {


    public static void main(String[] args) {
        ListNode head = LinkedListUtil.build(5);
        ListNode listNode = swap(head);

        ListNode p = listNode;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }

    }

    private static ListNode swap(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        int l = getLength(head);
        // 链表拆成两半，前半段 >= 后半段
        int mid = l / 2 + l % 2;
        ListNode p2 = head;
        while (mid > 0) {
            if (mid == 1) {
                ListNode temp = p2.next;
                p2.next = null;
                p2 = temp;
            } else {
                p2 = p2.next;
            }
            mid--;
        }

        p2 = reverse(p2);
        ListNode p1 = head;
        merge(p2, p1);

        return head;
    }

    private static void merge(ListNode p2, ListNode p1) {
        while (p1 != null && p2 != null) {
            ListNode next1 = p1.next;
            ListNode next2 = p2.next;
            p1.next = p2;
            p2.next = next1;
            p1 = next1;
            p2 = next2;
        }
    }

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    // private static ListNode reverse(ListNode head) {
    //     if (head == null || head.next == null) {
    //         return head;
    //     }
    //     ListNode res = reverse(head.next);
    //     head.next.next = head;
    //     head.next = null;
    //     return res;
    // }

    private static int getLength(ListNode head) {
        ListNode p = head;
        int l = 0;
        while (p != null) {
            p = p.next;
            l++;
        }
        return l;
    }

}
