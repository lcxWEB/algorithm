package com.example.problems.linkedlist;

import com.example.problems.assistant.LinkedListUtil;
import com.example.problems.assistant.ListNode;

/**
 * Created by lichunxia on 2019-09-14 20:40
 *
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 * Note: Do not modify the linked list.
 *
 *
 *
 * Example 1:
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 *
 * Example 2:
 *
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 *
 * Example 3:
 *
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 *
 *
 *
 *
 * Follow-up:
 * Can you solve it without using extra space?
 */
public class LinkedListCycleII {

    public static void main(String[] args) {
        LinkedListCycleII listCycleII = new LinkedListCycleII();
        ListNode listNode = listCycleII.detectCycle(LinkedListUtil.buildACycleList());
        System.out.println();
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle II.
     * Memory Usage: 34.5 MB, less than 94.74% of Java online submissions for Linked List Cycle II.
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        // 注意空链表判断
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
