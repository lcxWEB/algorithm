package com.example.demo.nowcoder.offer;


import com.example.demo.assistant.ListNode;

public class FindKthToTail {

    /**
     * 2.7
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail2(ListNode head, int k) {
        if (head == null || k < 1) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            k--;
            // 链表已经遍历到最后，k还大于0，说明k大于链表长度，参数不合法
            if (k > 0 && fast == null) {
                return null;
            }
            // 快指针走了k步之后，慢指针开始走
            if (k < 0) {
                slow = slow.next;
            }
        }
        return slow;
    }


    /**
     * 2.7
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k < 1) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (k > 0 && fast != null) {
            fast = fast.next;
            k--;
        }
        if (k > 0) {
            return null;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }

        ListNode result = head;
        ListNode oldHead = head;
        int length = 1;
        while (oldHead.next != null) {
            oldHead = oldHead.next;
            length++;
        }

        if (k > length) {
            return null;
        }

        // 正数第n个
        int n = length - k + 1;
        for (int i = 0; i < n - 1; i++) {
            result = result.next;
        }
        return result;
    }


    public ListNode findKthToTail2(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        // 两个指针
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k - 1; i++) {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                return null;
            }
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
