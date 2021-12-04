package com.example.problems.easy;

import com.example.problems.assistant.TreeNode;
import com.example.problems.assistant.TreeUtil;

/**
 * Created by lichunxia on 2019-09-02 20:04
 *
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 *
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
 *
 * Example 1:
 *
 * Input:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * Output:
 * Merged tree:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 *
 *
 * Note: The merging process must start from the root nodes of both trees.
 *
 */
public class MergeTwoBinaryTrees {

    public static void main(String[] args) {
        TreeNode treeNode = TreeUtil.buildATree();
        MergeTwoBinaryTrees mergeTwoBinaryTrees = new MergeTwoBinaryTrees();
        TreeNode node = mergeTwoBinaryTrees.mergeTrees(treeNode, treeNode);
        System.out.println();
    }

    /**
     * Runtime: 1 ms, faster than 64.41% of Java online submissions for Merge Two Binary Trees.
     * Memory Usage: 39.9 MB, less than 100.00% of Java online submissions for Merge Two Binary Trees.
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        } else if (t1 == null) {
            return t2;
        } else if (t2 == null) {
            return t1;
        }
        TreeNode newNode = new TreeNode(t1.val + t2.val);
        newNode.left = mergeTrees(t1.left, t2.left);
        newNode.right = mergeTrees(t1.right, t2.right);
        return newNode;
    }
}
