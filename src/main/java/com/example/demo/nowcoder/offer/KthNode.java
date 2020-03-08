package com.example.demo.nowcoder.offer;

import com.example.demo.assistant.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lichunxia on 2020-01-31 20:48
 */
public class KthNode {

    private int count = 0;

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node4.left = node2;
        node4.right = node6;

        node2.left = node1;
        node2.right = node3;

        node6.left = node5;
        node6.right = node7;

        TreeNode treeNode = new KthNode().KthNode210(node4, 4);
        System.out.println(treeNode.val);

    }

    /**
     * 2.10
     *
     * @param pRoot
     * @param k
     * @return
     */
    TreeNode KthNode210(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }
        TreeNode treeNode = KthNode210(pRoot.left, k);
        if (treeNode != null) {
            return treeNode;
        }
        count++;
        if (count == k) {
            return pRoot;
        }
        treeNode = KthNode210(pRoot.right, k);
        if (treeNode != null) {
            return treeNode;
        }
        return null;
    }


    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        inOrder(pRoot, list);
        if (k > list.size()) {
            return null;
        }
        return list.get(k - 1);
    }

    private void inOrder(TreeNode node, List<TreeNode> list) {
        if (node == null) return;
        inOrder(node.left, list);
        list.add(node);
        inOrder(node.right, list);
    }

    TreeNode KthNode2(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        inOrder(pRoot, list, k);
        if (k > list.size()) {
            return null;
        }
        return list.get(k - 1);
    }

    private void inOrder(TreeNode node, List<TreeNode> list, int k) {
        if (node == null) return;
        inOrder(node.left, list, k);
        if (list.size() == k) {
            return;
        }
        list.add(node);
        if (list.size() == k) {
            return;
        }
        inOrder(node.right, list, k);
        if (list.size() == k) {
            return;
        }
    }


    TreeNode KthNode1(TreeNode pRoot, int k) {
        // if (pRoot == null || k <= 0) {
        //     return null;
        // }
        // TreeNode treeNode = KthNode1(pRoot.left, k);
        // if (treeNode != null) return treeNode;
        // count++;
        // // 找到了，直接返回
        // if (count == k) {
        //     return pRoot;
        // }
        // treeNode = KthNode1(pRoot.right, k);
        // if (treeNode != null) return treeNode;
        // return null;

        if (pRoot != null) {
            TreeNode treeNode = KthNode1(pRoot.left, k);
            if (treeNode != null) return treeNode;
            count++;
            if (count == k) {
                return pRoot;
            }
            treeNode = KthNode1(pRoot.right, k);
            if (treeNode != null) return treeNode;
        }
        return null;
    }

}
