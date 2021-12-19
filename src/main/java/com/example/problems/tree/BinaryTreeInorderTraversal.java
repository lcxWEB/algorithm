package com.example.problems.tree;

import com.example.problems.assistant.TreeNode;
import com.example.problems.assistant.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 * Created by lichunxia on 2019-09-14 09:33
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();
        List<Integer> list = binaryTreeInorderTraversal.inorderTraversal(TreeUtil.buildATree());
        System.out.println(list);
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    /**
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
     * Memory Usage: 34.8 MB, less than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
     *
     * @param root
     * @param result
     */
    private void helper(TreeNode root, List<Integer> result) {
        if (root != null) {
            helper(root.left, result);
            result.add(root.val);
            helper(root.right, result);
        }
    }
}
