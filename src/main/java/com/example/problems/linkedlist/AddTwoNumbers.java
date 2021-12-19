package com.example.problems.linkedlist;

import com.example.problems.assistant.ListNode;

/**
 * LeetCode 2
 *
 * https://leetcode.com/problems/add-two-numbers/
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l1Node = new ListNode(4);
        l1.next = l1Node;
        l1Node.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        ListNode l2Node = new ListNode(6);
        l2.next = l2Node;
        l2Node.next = new ListNode(4);
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode listNode = addTwoNumbers.addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }

    /**
     * 错误解法
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbersWrong(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode pre = head;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int valL1 = 0;
            int valL2 = 0;
            if (l1 != null) {
                valL1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                valL2 = l2.val;
                l2 = l2.next;
            }
            pre.val = valL1 + valL2 + carry;
            carry = 0;
            if (pre.val >= 10) {
                carry = 1;
                pre.val = pre.val % 10;
            }
            pre.next = new ListNode(0);
            pre = pre.next;
        }
        return head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode pre = head;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int valL1 = 0;
            int valL2 = 0;
            if (l1 != null) {
                valL1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                valL2 = l2.val;
                l2 = l2.next;
            }
            cur.val = valL1 + valL2 + carry;
            carry = 0;
            if (cur.val >= 10) {
                carry = 1;
                cur.val = cur.val % 10;
            }
            pre.next = cur;
            pre = pre.next;
        }
        return head.next;
    }

}
