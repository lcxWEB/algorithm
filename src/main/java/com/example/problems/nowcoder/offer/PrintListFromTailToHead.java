package com.example.problems.nowcoder.offer;

import com.example.problems.assistant.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by lichunxia on 2020-02-05 12:40
 */
public class PrintListFromTailToHead {

    ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        PrintListFromTailToHead print = new PrintListFromTailToHead();
        ArrayList<Integer> result = print.printListFromTailToHead2(listNode1);
        System.out.println(result);
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if (listNode == null) {
            return result;
        }
        printFromTailToHeadCore(listNode, result);
        return result;
    }

    private void printFromTailToHeadCore(ListNode listNode, ArrayList<Integer> list) {
        if (listNode != null) {
            printFromTailToHeadCore(listNode.next, list);
            list.add(listNode.val);
        }
    }

    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead1(listNode.next);
            result.add(listNode.val);
        }
        return result;
    }

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!stack.empty()) {
            result.add(stack.pop());
        }
        return result;
    }


}
