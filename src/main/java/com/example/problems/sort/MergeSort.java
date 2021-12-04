package com.example.problems.sort;

import com.example.problems.assistant.ListNode;

import java.util.Arrays;

/**
 * Created by lichunxia on 2020-02-06 14:29
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        arr = new int[]{6, 5, 4, 3, 2, 1};
        new MergeSort().mergeSort(arr);
        System.out.println(Arrays.toString(arr));

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node3;
        node3.next = node2;
        node2.next = node4;
        node4.next = node5;

        ListNode listNode = new MergeSort().mergeSortLinkedList(node1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public void mergeSort(int[] array) {
        int[] merge = new int[array.length];
        mergeSortRecursive(array, merge, 0, array.length - 1);
        // merge_sort(array);
    }

    private void mergeSortRecursive(int[] array, int[] merge, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;
        int start1 = low, end1 = mid;
        int start2 = mid + 1, end2 = high;
        mergeSortRecursive(array, merge, start1, end1);
        mergeSortRecursive(array, merge, start2, end2);
        int k = low;
        while (start1 <= end1 && start2 <= end2) {
            merge[k++] = array[start1] > array[start2] ? array[start2++] : array[start1++];
        }

        while (start1 <= end1) {
            merge[k++] = array[start1++];
        }

        while (start2 <= high) {
            merge[k++] = array[start2++];
        }

        for (k = low; k <= high; k++) {
            array[k] = merge[k];
        }
    }

    /**
     * 链表的归并排序
     *
     * @param head
     * @return
     */
    private ListNode mergeSortLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        // 中间节点的上一个节点
        ListNode pre = null;
        // 获取链表的中间结点,偶数时取中间第二个，如 1->2->3->4 取3
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 将链表一分为二
        pre.next = null;
        ListNode left = mergeSortLinkedList(head);
        ListNode right = mergeSortLinkedList(slow);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if (left != null) {
            cur.next = left;
        }
        if (right != null) {
            cur.next = right;
        }
        return dummyHead.next;
    }

    private void merge_sort(int[] arr) {
        int[] orderedArr = new int[arr.length];
        for (int i = 2; i < arr.length * 2; i *= 2) {
            for (int j = 0; j < (arr.length + i - 1) / i; j++) {
                int left = i * j;
                int mid = left + i / 2 >= arr.length ? (arr.length - 1) : (left + i / 2);
                int right = i * (j + 1) - 1 >= arr.length ? (arr.length - 1) : (i * (j + 1) - 1);
                int start = left, l = left, m = mid;
                while (l < mid && m <= right) {
                    if (arr[l] < arr[m]) {
                        orderedArr[start++] = arr[l++];
                    } else {
                        orderedArr[start++] = arr[m++];
                    }
                }
                while (l < mid)
                    orderedArr[start++] = arr[l++];
                while (m <= right)
                    orderedArr[start++] = arr[m++];
                System.arraycopy(orderedArr, left, arr, left, right - left + 1);
            }
        }
    }


    public ListNode sortList(ListNode head) {
        //采用归并排序
        if (head == null || head.next == null) {
            return head;
        }
        //获取中间结点
        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null;
        //合并
        return mergeSort(sortList(head), sortList(right));
    }

    /**
     * 获取链表的中间结点,偶数时取中间第一个
     *
     * @param head
     * @return
     */
    private ListNode getMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //快慢指针
        ListNode slow = head, quick = head;
        //快2步，慢一步
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }

    /**
     * 归并两个有序的链表
     *
     * @param head1
     * @param head2
     * @return
     */
    private ListNode mergeSort(ListNode head1, ListNode head2) {
        ListNode p1 = head1, p2 = head2, head;
        //得到头节点的指向
        if (head1.val < head2.val) {
            head = head1;
            p1 = p1.next;
        } else {
            head = head2;
            p2 = p2.next;
        }

        ListNode p = head;
        //比较链表中的值
        while (p1 != null && p2 != null) {

            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
                p = p.next;
            } else {
                p.next = p2;
                p2 = p2.next;
                p = p.next;
            }
        }
        //第二条链表空了
        if (p1 != null) {
            p.next = p1;
        }
        //第一条链表空了
        if (p2 != null) {
            p.next = p2;
        }
        return head;
    }
}
