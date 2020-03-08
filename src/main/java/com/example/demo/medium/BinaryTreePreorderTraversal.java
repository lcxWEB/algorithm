package com.example.demo.medium;

import com.example.demo.assistant.TreeNode;
import com.example.demo.assistant.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lichunxia on 2019-09-14 09:39
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.
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
 * Output: [1,2,3]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 */
public class BinaryTreePreorderTraversal {

    public static void main(String[] args) {
        BinaryTreePreorderTraversal binaryTreePreorderTraversal = new BinaryTreePreorderTraversal();
        List<Integer> list = binaryTreePreorderTraversal.preorderTraversal(TreeUtil.buildATree());
        System.out.println(list);
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Preorder Traversal.
     * Memory Usage: 34.7 MB, less than 100.00% of Java online submissions for Binary Tree Preorder Traversal.
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            helper(root.left, result);
            helper(root.right, result);
        }
    }
}
