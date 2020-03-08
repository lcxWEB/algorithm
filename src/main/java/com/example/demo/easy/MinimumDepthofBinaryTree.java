package com.example.demo.easy;

import com.example.demo.assistant.TreeNode;
import com.example.demo.assistant.TreeUtil;

/**
 * Created by lichunxia on 2019-09-14 10:37
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
 * return its minimum depth = 2.
 */
public class MinimumDepthofBinaryTree {

    public static void main(String[] args) {
        MinimumDepthofBinaryTree minimumDepthofBinaryTree = new MinimumDepthofBinaryTree();
        // int minDepth = minimumDepthofBinaryTree.minDepth(TreeUtil.buildATree());
        int minDepth = minimumDepthofBinaryTree.minDepth(TreeUtil.buildATwoNodeTree());
        System.out.println(minDepth);
    }


    /**
     * Wrong Answer
     * @param root
     * @return
     */
    public int minDepthW(TreeNode root) {
        int hl, hr, h;
        if (root != null) {
            hl = minDepth(root.left);
            hr = minDepth(root.right);
            h = Math.min(hl, hr) + 1;
            return h;
        } else return 0;
    }

    /**
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Depth of Binary Tree.
     * Memory Usage: 39.2 MB, less than 98.44% of Java online submissions for Minimum Depth of Binary Tree.
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        int hl, hr, h;
        if (root != null) {
            hl = minDepth(root.left);
            hr = minDepth(root.right);
            if (hl == 0) {
                h = hr + 1;
            } else if (hr == 0) {
                h = hl + 1;
            } else {
                h = Math.min(hl, hr) + 1;
            }
            return h;
        } else return 0;
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Depth of Binary Tree.
     * Memory Usage: 38.4 MB, less than 98.44% of Java online submissions for Minimum Depth of Binary Tree.
     * @param root
     * @return
     */
    public int minDepthDFS(TreeNode root) {
       if (root == null) {
           return 0;
       }
       if (root.left == null) return 1 + minDepthDFS(root.right);
       if (root.right == null) return 1 + minDepthDFS(root.left);
       int leftDepth = minDepthDFS(root.left);
       int rightDepth = minDepthDFS(root.right);
       // +1 是因为当前结点也要算一层
       int result = 1 + Math.min(leftDepth, rightDepth);
       return result;
    }
}
