package com.example.demo.nowcoder.offer;

import com.example.demo.assistant.ListNode;

public class MergeList {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        ListNode list2 = new ListNode(3);
        list2.next = new ListNode(4);

        MergeList mergeList = new MergeList();
        ListNode head = mergeList.Merge(list1, list2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    /**
     * 2.7
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        ListNode newList = null;
        ListNode head = null;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                if (newList == null) {
                    newList = head = list1;
                } else {
                    newList.next = list1;
                    newList = newList.next;
                }
                list1 = list1.next;
            } else {
                if (newList == null) {
                    newList = head = list2;
                } else {
                    newList.next = list2;
                    newList = newList.next;
                }
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            if (head == null) {
                head = list1;
            } else {
                newList.next = list1;
            }
        }
        if (list2 != null) {
            if (head == null) {
                head = list2;
            } else {
                newList.next = list2;
            }
        }
        return head;
    }
}