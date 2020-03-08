package com.example.demo.nowcoder.offer;

import com.example.demo.assistant.ListNode;

/**
 * Created by lichunxia on 2020-01-31 14:32
 */
public class DeleteDuplication {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode listNode = new DeleteDuplication().deleteDuplicationRecurse(node1);
        System.out.println(listNode);
    }

    public ListNode deleteDuplication1(ListNode pHead) {
        if(pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = pHead;
        ListNode movingHead = dummyHead;
        // 下一个不重复节点的上一个节点
        ListNode pNode = pHead;
        while(pNode != null) {
            if (pNode.next != null && pNode.val == pNode.next.val) {
                while(pNode.next != null && pNode.val == pNode.next.val) {
                    pNode = pNode.next;
                }
                movingHead.next = pNode.next;
                // movingHead = movingHead.next;
                pNode = pNode.next;
            } else {
                movingHead = movingHead.next;
                pNode = pNode.next;
            }
        }
        return dummyHead.next;

    }


    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode head = pHead;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = pHead;
        ListNode last = dummyHead;
        while (head != null && head.next != null) {
            ListNode next = head.next;
            int val = next.val;
            if (head.val == val) {
                while (head != null && head.val == val) {
                    head = head.next;
                }
                last.next = head;
            } else {
                last = head;
                head = head.next;
            }
        }
        return dummyHead.next;
    }


    public ListNode deleteDuplicationRecurse(ListNode pHead) {
        if (pHead == null || pHead.next == null) { // 只有0个或1个结点，则返回
            return pHead;
        }
        if (pHead.val == pHead.next.val) { // 当前结点是重复结点
            ListNode pNode = pHead.next;
            while (pNode != null && pNode.val == pHead.val) {
                // 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
                pNode = pNode.next;
            }
            return deleteDuplication(pNode); // 从第一个与当前结点不同的结点开始递归
        } else { // 当前结点不是重复结点
            pHead.next = deleteDuplication(pHead.next); // 保留当前结点，从下一个结点开始递归
            return pHead;
        }
    }


}
