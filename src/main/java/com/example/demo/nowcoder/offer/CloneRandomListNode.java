package com.example.demo.nowcoder.offer;


import com.example.demo.assistant.RandomListNode;

import java.util.HashMap;

public class CloneRandomListNode {


    /**
     * 2.11
     * 空间换时间
     *
     * @param pHead
     * @return
     */
    public RandomListNode CloneComplexList(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        HashMap<RandomListNode, RandomListNode> originalCloneMap = new HashMap<>();
        RandomListNode head = pHead;

        while (head != null) {
            RandomListNode cloneNode = new RandomListNode(head.label);
            originalCloneMap.put(head, cloneNode);
            head = head.next;
        }

        head = pHead;
        while (head != null) {
            RandomListNode cloneNode = originalCloneMap.get(head);
            if (head.next != null) {
                cloneNode.next = originalCloneMap.get(head.next);
            }
            if (head.random != null) {
                cloneNode.random = originalCloneMap.get(head.random);
            }
            head = head.next;
        }
        return originalCloneMap.get(pHead);
    }


    public RandomListNode Clone(RandomListNode pHead) {
        CloneNodes(pHead);
        ConnectRandomNodes(pHead);
        return ReconnectNodes(pHead);
    }

    private void CloneNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while (pNode != null) {
            // A - A' - B - B' 将克隆的节点连到源节点后面
            RandomListNode pClonedNode = new RandomListNode(pNode.label);
            pClonedNode.next = pNode.next;
            pNode.next = pClonedNode;
            pNode = pClonedNode.next;
        }
    }

    private void ConnectRandomNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        // 处理复制节点的随机节点
        while (pNode != null) {
            RandomListNode pClonedNode = pNode.next;
            if (pNode.random != null) {
                pClonedNode.random = pNode.random.next;
            }
            pNode = pClonedNode.next;
        }
    }

    private RandomListNode ReconnectNodes(RandomListNode pHead) {
        // 拆分为两个链表
        RandomListNode pNode = pHead;
        RandomListNode pClonedHead = null;
        RandomListNode pClonedNode = null;
        if (pNode != null) {
            pClonedHead = pClonedNode = pNode.next;
            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }

        while (pNode != null) {
            pClonedNode.next = pNode.next;
            pClonedNode = pClonedNode.next;
            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }

        return pClonedHead;
    }


}
