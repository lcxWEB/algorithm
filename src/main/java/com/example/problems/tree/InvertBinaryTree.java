package com.example.problems.tree;

import com.example.problems.assistant.TreeNode;
import com.example.problems.assistant.TreeUtil;

/**
 * Created by lichunxia on 2019-08-30 09:47
 *
 * Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 */
public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode treeNode = TreeUtil.buildATree();
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        TreeNode treeNode1 = invertBinaryTree.invertTree(treeNode);
        System.out.println(1);
    }


    /**
     * Wrong Answer
     * @param root
     * @return
     */
    public TreeNode invertTreeWrong(TreeNode root) {
        if (root == null) {
            return null;
        }
        // TreeNode newRoot = root;
        // TreeNode left = root.left;
        // TreeNode right = root.right;

        // while (newRoot != null) {
        //     newRoot.left = right;
        //     newRoot.right = left;
        //     newRoot = left;
        //     left = left.left;
        //     right = left.right;
        // }
        //  newRoot = root;
        //  left = root.left;
        //  right = root.right;
        // while (newRoot != null) {
        //     newRoot.left = right;
        //     newRoot.right = left;
        //     newRoot = left;
        //     left = left.left;
        //     right = left.right;
        // }
        root.left = invertTree(root.right);
        root.right = invertTree(root.left);
        return root;
    }

    /**
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
     * Memory Usage: 34.2 MB, less than 100.00% of Java online submissions for Invert Binary Tree.
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }

}
