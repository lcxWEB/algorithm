package com.example.demo.medium;

import com.example.demo.assistant.TreeNode;

/**
 * Created by lichunxia on 2019-09-14 11:13
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class ConstructBinaryTreefromPreorderInorder {

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        ConstructBinaryTreefromPreorderInorder c = new ConstructBinaryTreefromPreorderInorder();
        TreeNode tree = c.buildTree(preorder, inorder);
        System.out.println();
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        if (preorder.length == 1 && inorder.length == 1) {
            return new TreeNode(preorder[0]);
        }

        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {

            }
        }

        return root;
    }

    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inoerder) {

        return null;
    }
}
