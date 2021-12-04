package com.example.problems.nowcoder.offer;


import com.example.problems.assistant.TreeNode;

import java.util.Stack;

public class ConvertTree {

    private TreeNode lastNode = null;


    // public TreeNode Convert211(TreeNode pRootOfTree) {
    //     // if (pRootOfTree == null) {
    //     //     return null;
    //     // }
    //     TreeNode lastNode = null;
    //     Convert211(pRootOfTree, lastNode);
    //     TreeNode head = lastNode;
    //     while (head != null && head.left != null) {
    //         head = head.left;
    //     }
    //     return head;
    // }

    // private void Convert211(TreeNode root, TreeNode lastNode) {
    //     if (root == null) {
    //         return;
    //     }
    //     TreeNode current = root;
    //     if (root.left != null) {
    //         Convert211(root.left, lastNode);
    //     }
    //
    //     current.left = lastNode;
    //     if (lastNode != null) {
    //         lastNode.right = current;
    //     }
    //     lastNode = current;
    //
    //     if (root.right != null) {
    //         Convert211(root.right, lastNode);
    //     }
    // }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(10);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(15);
        head.left = left;
        head.right = right;
        ConvertTree convertTree = new ConvertTree();
        TreeNode linkHead = convertTree.Convert(head);
        while (linkHead != null) {
            System.out.println(linkHead.val);
            linkHead = linkHead.right;
        }
    }


    /**
     * 2.11
     * 非递归版
     *
     * @param pRootOfTree
     * @return
     */
    public TreeNode ConvertBSTToBiList(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = pRootOfTree;
        TreeNode pre = null; // 前一个节点
        TreeNode root = null;
        boolean isFirst = true;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (isFirst) {
                root = p; // 中序遍历的第一个节点记为root
                pre = root;
                isFirst = false;
            } else {
                pre.right = p;
                p.left = pre;
                pre = p;
            }
            p = p.right;
        }
        return root;
    }


    public TreeNode Convert(TreeNode pRootOfTree) {
        // if (pRootOfTree == null) {
        //     return null;
        // }
        ConvertHelper(pRootOfTree);
        TreeNode head = lastNode;
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }

    private void ConvertHelper(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return;
        }
        // TreeNode current = pRootOfTree;

        if (pRootOfTree.left != null) {
            ConvertHelper(pRootOfTree.left);
        }

        pRootOfTree.left = lastNode;
        if (lastNode != null) {
            lastNode.right = pRootOfTree;
        }
        lastNode = pRootOfTree;

        if (pRootOfTree.right != null) {
            ConvertHelper(pRootOfTree.right);
        }
    }


}
