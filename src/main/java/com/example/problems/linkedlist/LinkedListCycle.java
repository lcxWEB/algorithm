package com.example.problems.linkedlist;

import com.example.problems.assistant.LinkedListUtil;
import com.example.problems.assistant.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lichunxia on 2019-08-28 16:19
 *
 * Given a linked list, determine if it has a cycle in it.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 *
 *
 * Example 1:
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 *
 * Example 2:
 *
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 *
 * Example 3:
 *
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 *
 *
 *
 *
 * Follow up:
 *
 * Can you solve it using O(1) (i.e. constant) memory?
 */

public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode head = LinkedListUtil.buildACycleList();
        // ListNode head = LinkedListUtil.buildAList();
        LinkedListCycle linkedListCycle = new LinkedListCycle();
        boolean hasCycle = linkedListCycle.hasCycle1(head);
        System.out.println(hasCycle);
    }

    /**
     * 自己想的，用set判断结点是否访问过
     * Runtime: 5 ms, faster than 7.07% of Java online submissions for Linked List Cycle.
     * Memory Usage: 38.4 MB, less than 80.71% of Java online submissions for Linked List Cycle.
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.contains(head)) {
                set.add(head);
            } else {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 块慢指针法
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle.
     * Memory Usage: 37.3 MB, less than 100.00% of Java online submissions for Linked List Cycle.
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && slow != null) {
            if (slow.val == fast.val) {
                return true;
            }
            slow = slow.next;
            if (fast.next == null) {
                return false;
            }
            fast = fast.next.next;
        }
        return false;
    }


    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle.
     * Memory Usage: 37.4 MB, less than 98.57% of Java online submissions for Linked List Cycle.
     *
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.val == fast.val) {
                return true;
            }
        }
        return false;
    }
}
