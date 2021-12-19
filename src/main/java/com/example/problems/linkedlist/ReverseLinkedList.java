package com.example.problems.linkedlist;

import com.example.problems.assistant.LinkedListUtil;
import com.example.problems.assistant.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lichunxia on 2019-08-29 17:44
 * <p>
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * <p>
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = LinkedListUtil.buildAList();
        // head.next = new ListNode(999);
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        reverseLinkedList.reverseList2(head);
    }

    /**
     * 思维有点乱
     *
     * @param head
     * @return
     */
    public ListNode reverseListW(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode listNode = head;
        List<ListNode> nodes = new ArrayList<>();
        while (listNode != null) {
            nodes.add(listNode);
            listNode = listNode.next;
        }
        ListNode reversedHead = nodes.get(nodes.size() - 1);
        ListNode temp = reversedHead;
        for (int i = nodes.size() - 2; i >= 0; i--) {
            temp.next = nodes.get(i);
            //  需要把之前结点断开
            // temp.next.next = null;
            temp = temp.next;
        }
        return reversedHead;
    }


    /**
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
     * Memory Usage: 37.1 MB, less than 98.92% of Java online submissions for Reverse Linked List.
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        // if (head == null) {
        //     return null;
        // }
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    /**
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
     * Memory Usage: 37.2 MB, less than 98.56% of Java online submissions for Reverse Linked List.
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
       ListNode cur = head;
       ListNode pre = null;
       while (cur != null) {
           ListNode next = cur.next;
           cur.next = pre;
           pre = cur;
           cur = next;
        }
       return pre;
    }

}
