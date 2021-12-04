package com.example.problems.nowcoder.offer;


import com.example.problems.assistant.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by lichunxia on 2020-01-29 20:47
 */
public class FindFirstCommonNode {

    /**
     * 2.7
     *
     * 有个思路，不需要存储链表的额外空间。也不需要提前知道链表的长度。看下面的链表例子：
     * 0-1-2-3-4-5-null
     * a-b-4-5-null
     * 代码的ifelse语句，对于某个指针p1来说，其实就是让它跑了连接好的的链表，长度就变成一样了。
     * 如果有公共结点，那么指针一起走到末尾的部分，也就一定会重叠。看看下面指针的路径吧。
     * p1： 0-1-2-3-4-5-null(此时遇到if-else)-a-b-4-5-null
     * p2:  a-b-4-5-null(此时遇到if-else)0-1-2-3-4-5-null
     * 因此，两个指针所要遍历的链表就长度一样了！
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNodeSimple(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = p1 == null ? pHead2 : p1.next;
            p2 = p2 == null ? pHead1 : p2.next;
        }
        return p1;
    }

    /**
     * 2.7
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int length1 = getListLength(pHead1);
        int length2 = getListLength(pHead2);
        int diff = 0;
        ListNode head1 = pHead1;
        ListNode head2 = pHead2;
        if (length1 > length2) {
            diff = length1 - length2;
            while (diff > 0) {
                head1 = head1.next;
                diff--;
            }
        } else {
            diff = length2 - length1;
            while (diff > 0) {
                head2 = head2.next;
                diff--;
            }
        }

        while (head1 != null && head2 != null) {
            if (head1 == head2) {
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1;
    }

    private int getListLength(ListNode listNode) {
        ListNode head = listNode;
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        Stack<ListNode> stack1 = new Stack();
        Stack<ListNode> stack2 = new Stack();
        ListNode pHeadNode1 = pHead1;
        ListNode pHeadNode2 = pHead2;
        while (pHeadNode1 != null) {
            stack1.push(pHeadNode1);
            pHeadNode1 = pHeadNode1.next;
        }
        while (pHeadNode2 != null) {
            stack2.push(pHeadNode2);
            pHeadNode2 = pHeadNode2.next;
        }
        ListNode result = null;
        // stack.peek()  EmptyStackException
        while (!stack1.empty() && !stack2.empty() && stack1.peek() == stack2.peek()) {
            result = stack1.pop();
            stack2.pop();
        }
        return result;
    }

    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode pHeadNode1 = pHead1;
        ListNode pHeadNode2 = pHead2;
        List<ListNode> nodeList = new ArrayList<>();
        while (pHeadNode1 != null) {
            nodeList.add(pHeadNode1);
            pHeadNode1 = pHeadNode1.next;
        }
        while (pHeadNode2 != null) {
            if (nodeList.contains(pHeadNode2)) {
                return pHeadNode2;
            }
            pHeadNode2 = pHeadNode2.next;
        }
        return null;
    }


    public ListNode FindFirstCommonNode3(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode pHeadNode1 = pHead1;
        ListNode pHeadNode2 = pHead2;

        int length1 = getListNodeLength(pHeadNode1);
        int length2 = getListNodeLength(pHeadNode2);
        int lengthDiff = length1 - length2;
        if (length1 < length2) {
            pHeadNode1 = pHead2;
            pHeadNode2 = pHead1;
            lengthDiff = length2 - length1;
        }

        while (lengthDiff > 0) {
            pHeadNode1 = pHeadNode1.next;
            lengthDiff--;
        }

        while (pHeadNode1 != null && pHeadNode2 != null && pHeadNode1 != pHeadNode2) {
            pHeadNode1 = pHeadNode1.next;
            pHeadNode2 = pHeadNode2.next;
        }

        ListNode result = pHeadNode1;
        return result;
    }

    private int getListNodeLength(ListNode headNode) {
        ListNode listNode = headNode;
        int length = 0;
        while (listNode != null) {
            length++;
            listNode = listNode.next;
        }
        return length;
    }

}
