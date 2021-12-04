package com.example.problems.assistant;

/**
 * Created by lichunxia on 2019-08-28 16:20
 */
public class LinkedListUtil {

    public static ListNode build(int num) {
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        for (int i = 0; i < num; i++) {
            p.next = new ListNode(i+1);
            p = p.next;
        }
        return dummy.next;
    }

    public static ListNode buildAList() {
        ListNode l1 = new ListNode(2);
        ListNode l1Node = new ListNode(4);
        l1.next = l1Node;
        ListNode l2 = new ListNode(3);
        l1Node.next = l2;
        l2.next = new ListNode(10);
        return l1;
    }

    public static ListNode buildACycleList() {
        ListNode l1 = new ListNode(2);
        ListNode l1Node = new ListNode(4);
        l1.next = l1Node;
        ListNode l2Node = new ListNode(3);
        l1Node.next = l2Node;
        l2Node.next = l1Node;
        return l1;
    }

    public static ListNode buildAnotherList() {
        ListNode l1 = new ListNode(5);
        ListNode l1Node = new ListNode(4);
        l1.next = l1Node;
        l1Node.next = new ListNode(3);
        return l1;
    }

    public static ListNode builPalindromeList() {
        ListNode l1 = new ListNode(2);
        ListNode l1Node = new ListNode(1);
        l1.next = l1Node;
        ListNode l2Node = new ListNode(2);
        l1Node.next = l2Node;
        return l1;
    }
}
