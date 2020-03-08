package com.example.demo.nowcoder.offer;


import com.example.demo.assistant.LinkedListUtil;
import com.example.demo.assistant.ListNode;

public class ReverseList {

    public static void main(String[] args) {
        ListNode list = LinkedListUtil.buildAList();
        System.out.println(list);
        ListNode listNode = reverseListRecurse(list);
        System.out.println(listNode);

    }

    /**
     * 2.7
     *
     * @param head
     * @return
     */
    public static ListNode reverseListRecurse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode listNode = reverseListRecurse(head.next);
        //再将当前节点设置为后面节点的后续节点
        head.next.next = head;
        head.next = null;
        return listNode;
    }

    /**
     * 2.7
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pNode = head;
        ListNode pre = null;
        ListNode next;
        while (pNode != null) {
            next = pNode.next;
            pNode.next = pre;
            pre = pNode;
            pNode = next;
        }
        return pre;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

//        ListNode prt = head;
//        while (prt.next != null) {
//            ListNode next = prt.next;
//            ListNode next2  = next.next;
//            next.next = prt;
//            prt = next2;
//        }
//        return prt;

        ListNode pre = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
