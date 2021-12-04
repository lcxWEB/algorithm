package com.example.problems.easy;

import com.example.problems.assistant.ListNode;

/**
 * Created by lichunxia on 2019-08-27 10:38
 * <p>
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        l1.next = node2;
        node2.next = node3;

        ListNode l2 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        l2.next = node4;
        node4.next = node5;

        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode listNode = mergeTwoSortedLists.mergeTwoLists(l1, l2);
    }

    /**
     * 第一种解法
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
     * Memory Usage: 40.7 MB, less than 12.12% of Java online submissions for Merge Two Sorted Lists.
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode pre = result;
        ListNode L1 = l1;
        ListNode L2 = l2;
        while (L1 != null && L2 != null) {
            if (L1.val <= L2.val) {
                pre.next = L1;
                L1 = L1.next;
            } else {
                pre.next = L2;
                L2 = L2.next;
            }
            pre = pre.next;
        }
        while (L1 != null) {
            pre.next = L1;
            L1 = L1.next;
            pre = pre.next;
        }
        while (L2 != null) {
            pre.next = L2;
            L2 = L2.next;
            pre = pre.next;
        }
        return result.next;
    }

    /**
     * 第二种解法
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
     * Memory Usage: 39.4 MB, less than 17.17% of Java online submissions for Merge Two Sorted Lists.
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsOp(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode pre = result;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        while (l1 != null) {
            pre.next = l1;
            l1 = l1.next;
            pre = pre.next;
        }
        while (l2 != null) {
            pre.next = l2;
            l2 = l2.next;
            pre = pre.next;
        }
        return result.next;
    }
}
