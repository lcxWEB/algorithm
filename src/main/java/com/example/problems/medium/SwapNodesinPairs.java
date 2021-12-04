package com.example.problems.medium;

import com.example.problems.assistant.LinkedListUtil;
import com.example.problems.assistant.ListNode;

/**
 * Created by lichunxia on 2019-09-14 19:49
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 *
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class SwapNodesinPairs {

    public static void main(String[] args) {
        SwapNodesinPairs swapNodesinPairs = new SwapNodesinPairs();
        ListNode listNode = swapNodesinPairs.swapPairs(LinkedListUtil.buildAList());
        System.out.println();
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Swap Nodes in Pairs.
     * Memory Usage: 34.3 MB, less than 100.00% of Java online submissions for Swap Nodes in Pairs.
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null && pre.next.next != null) {
            ListNode a = pre.next;
            ListNode b = a.next;
            // 一定要注意指针转向顺序
            // 从最后的指针开始转
            a.next = b.next;
            b.next = a;
            pre.next = b;
            pre = a;
        }
        return dummy.next;
    }
}
