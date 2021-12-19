package com.example.problems.tree;

import com.example.problems.assistant.TreeNode;
import com.example.problems.assistant.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lichunxia on 2019-09-15 14:12
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        ValidateBinarySearchTree binarySearchTree = new ValidateBinarySearchTree();
        boolean isBST = binarySearchTree.isValidBSTByMinMax(TreeUtil.buildATree());
        System.out.println(isBST);
    }

    /**
     * Runtime: 2 ms, faster than 24.57% of Java online submissions for Validate Binary Search Tree.
     * Memory Usage: 37.1 MB, less than 100.00% of Java online submissions for Validate Binary Search Tree.
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> treeNode = new ArrayList<>();
        inorder(root, treeNode);
        for (int i = 0; i < treeNode.size() - 1; i++) {
            if (treeNode.get(i) >= treeNode.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void inorder(TreeNode root, List<Integer> treeNode) {
        if (root != null) {
            inorder(root.left, treeNode);
            treeNode.add(root.val);
            inorder(root.right, treeNode);
        }
    }


    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
     * Memory Usage: 39.1 MB, less than 81.40% of Java online submissions for Validate Binary Search Tree.
     * @param root
     * @return
     */
    public boolean isValidBSTByMinMax(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidBSTMinMax(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTMinMax(TreeNode root, long minValue, long maxValue) {
        if (root == null) return true;
        if (root.val <= minValue) return false;
        if (root.val >= maxValue) return false;
        return isValidBSTMinMax(root.left, minValue, root.val) && isValidBSTMinMax(root.right, root.val, maxValue);
    }

    /**
     * Wrong Answer
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode pre = null;
        return helper(root, pre);
    }

    private boolean helper(TreeNode root, TreeNode pre) {
        if (root != null) {
            if (!helper(root.left, pre)) {
                return false;
            }
            if (pre != null && pre.val >= root.val) {
                return false;
            }
            pre = root;
            return helper(root.right, pre);
        } else {
            return true;
        }
    }
}
