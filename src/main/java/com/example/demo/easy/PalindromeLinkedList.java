package com.example.demo.easy;

import com.example.demo.assistant.LinkedListUtil;
import com.example.demo.assistant.ListNode;

/**
 * Created by lichunxia on 2019-08-30 10:37
 *
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 *
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        // ListNode listNode = LinkedListUtil.buildAList();
        ListNode listNode = LinkedListUtil.builPalindromeList();
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        boolean palindrome = palindromeLinkedList.isPalindrome(listNode);
        System.out.println(palindrome);
    }


    public boolean isPalindrome(ListNode head) {
        ListNode h = head;
        ListNode newHead = new ListNode(head.val);
        while (h.next != null) {
            ListNode next = new ListNode(h.next.val);
            next.next = newHead;
            newHead = next;
            h = h.next;
        }

        while (newHead != null && head != null) {
            if (newHead.val != head.val) {
                return false;
            }
            newHead = newHead.next;
            head = head.next;
        }
        return true;

        // Runtime: 2 ms, faster than 36.85% of Java online submissions for Palindrome Linked List.
        // Memory Usage: 41.4 MB, less than 48.78% of Java online submissions for Palindrome Linked List.

        // if(head == null)
        //     return true;
        //
        // ListNode p = head;
        // ListNode prev = new ListNode(head.val);
        //
        // while(p.next != null){
        //     ListNode temp = new ListNode(p.next.val);
        //     temp.next = prev;
        //     prev = temp;
        //     p = p.next;
        // }
        //
        // ListNode p1 = head;
        // ListNode p2 = prev;
        //
        // while(p1!=null){
        //     if(p1.val != p2.val)
        //         return false;
        //
        //     p1 = p1.next;
        //     p2 = p2.next;
        // }
        //
        // return true;
    }

}
