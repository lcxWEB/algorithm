package com.example.problems.easy;

import com.example.problems.assistant.LinkedListUtil;
import com.example.problems.assistant.ListNode;

/**
 * Created by lichunxia on 2019-08-28 18:08
 * <p>
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * <p>
 * Notes:
 * <p>
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class IntersectionofTwoLinkedLists {

    public static void main(String[] args) {
        ListNode headA = LinkedListUtil.buildAList();
        ListNode headB = LinkedListUtil.buildAnotherList();
        IntersectionofTwoLinkedLists intersectionofTwoLinkedLists = new IntersectionofTwoLinkedLists();
        ListNode node = intersectionofTwoLinkedLists.getIntersectionNode(headA, headB);
        System.out.println(node);
        ListNode l1 = new ListNode(2);
        ListNode l1Node = new ListNode(4);
        System.out.println(l1Node);
        l1.next = l1Node;
        l1Node.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        ListNode l2Node = new ListNode(8);
        l2.next = l2Node;
        l2Node.next = l1Node;
        node = intersectionofTwoLinkedLists.getIntersectionNode(l1, l2);
        System.out.println(node);
    }


    /**
     * ？？？为什么报空指针异常？因为没有将diff--
     *
     * java.lang.NullPointerException
     * at line 37, Solution.getIntersectionNode
     * at line 101, __Driver__.main
     *
     *
     * Runtime: 1 ms, faster than 98.62% of Java online submissions for Intersection of Two Linked Lists.
     * Memory Usage: 39.6 MB, less than 15.00% of Java online submissions for Intersection of Two Linked Lists.
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode l1 = headA;
        ListNode l2 = headB;
        int len1 = 0;
        int len2 = 0;
        while (l1 != null) {
            len1++;
            l1 = l1.next;
        }
        while (l2 != null) {
            len2++;
            l2 = l2.next;
        }
        l1 = headA;
        l2 = headB;
        int diff = Math.abs(len1 - len2);

        // while (diff > 0) {
        //     if (len1 > len2) {
        //         l1 = l1.next;
        //     } else {
        //         l2 = l2.next; // 空指针异常
        //     }
        // }

        if (len1 > len2) {
            while (diff > 0) {
                l1 = l1.next;
                diff--;
            }
        } else {
            while (diff > 0) {
                l2 = l2.next;
                diff--;
            }
        }

        while (l1 != null && l2 != null) {
            if (l1 == l2) {
                return l1;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return null;
    }
}
