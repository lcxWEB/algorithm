package com.example.demo.easy;

import com.example.demo.assistant.TreeNode;
import com.example.demo.assistant.TreeUtil;

/**
 * Created by lichunxia on 2019-08-28 09:55
 *
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 */

public class MaximumDepthofBinaryTree {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildATree();
        MaximumDepthofBinaryTree maximumDepthofBinaryTree = new MaximumDepthofBinaryTree();
        int maxDepth = maximumDepthofBinaryTree.maxDepth(root);
        System.out.println(maxDepth);
    }

    /**
     * 不是自己想的
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);
        return lDepth > rDepth ? lDepth + 1 : rDepth + 1;
    }
}
