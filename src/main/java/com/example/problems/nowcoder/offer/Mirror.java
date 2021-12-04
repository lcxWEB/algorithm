package com.example.problems.nowcoder.offer;

import com.example.problems.assistant.TreeNode;
import com.example.problems.assistant.TreeUtil;

import java.util.Stack;

/**
 * Created by lichunxia on 2020-02-08 13:45
 */
public class Mirror {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildATree();
        new Mirror().MirrorWhilePre(root);
        System.out.println();
    }

    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        // 前序遍历
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);

        // 后序遍历也可以
        // Mirror(root.left);
        // Mirror(root.right);
        // TreeNode temp = root.left;
        // root.left = root.right;
        // root.right = temp;
    }

    /**
     * 前序非递归
     *
     * @param root
     */
    public void MirrorWhilePre(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            TreeNode temp = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = temp;
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
        }
    }

    // /**
    //  * 后序非递归
    //  *
    //  * @param root
    //  */
    // public void MirrorWhilePost(TreeNode root) {
    //     if (root == null) {
    //         return;
    //     }
    //     Stack<TreeNode> stack = new Stack<>();
    //     stack.push(root);
    //     while (!stack.isEmpty()) {
    //         TreeNode treeNode = stack.peek();
    //         if (treeNode.right != null) {
    //             stack.push(treeNode.right);
    //         }
    //         if (treeNode.left != null) {
    //             stack.push(treeNode.left);
    //         }
    //         treeNode = stack.pop();
    //         TreeNode temp = treeNode.left;
    //         treeNode.left = treeNode.right;
    //         treeNode.right = temp;
    //     }
    // }

}
