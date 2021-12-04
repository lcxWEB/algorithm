package com.example.problems.nowcoder.offer;

import com.example.problems.assistant.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lichunxia on 2020-01-31 12:43
 */
public class EntryNodeOfLoop {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;
        ListNode listNode = new EntryNodeOfLoop().EntryNodeOfLoop2(node1);
        System.out.println(listNode.val);
    }


    /**
     * 2.7
     *
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop27(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }

        ListNode fast = pHead;
        ListNode slow = pHead;
        // 以下循环退出的条件：fast == null 或 fast.next == null 或 fast == slow(有环)
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        // 无环
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 辅助空间 O(n)
     *
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        List<ListNode> listNodeList = new ArrayList<>();
        ListNode head = pHead;
        while (head != null) {
            if (listNodeList.contains(head)) {
                return head;
            }
            listNodeList.add(head);
            head = head.next;
        }
        return null;
    }

    public ListNode EntryNodeOfLoop1(ListNode pHead) {
        if (pHead == null || pHead.next == null || pHead.next.next == null) {
            return null;
        }
        ListNode slow = pHead.next;
        ListNode fast = pHead.next.next;
        while (slow != fast && slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow == null || fast == null || fast.next == null) {
            return null;
        }

        fast = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public ListNode EntryNodeOfLoop2(ListNode pHead) {
        if (pHead == null || pHead.next == null || pHead.next.next == null) {
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        fast = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public ListNode EntryNodeOfLoop3(ListNode pHead) {
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = pHead;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }


}
