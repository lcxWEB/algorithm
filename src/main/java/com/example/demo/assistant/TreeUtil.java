package com.example.demo.assistant;

/**
 * Created by lichunxia on 2019-08-28 12:37
 */
public class TreeUtil {

    public static TreeNode buildATree() {
        TreeNode root = new TreeNode(7);
        TreeNode l1 = new TreeNode(5);
        TreeNode r1 = new TreeNode(8);
        root.left = l1;
        root.right = r1;
        TreeNode l2 = new TreeNode(3);
        l1.left = l2;
        TreeNode r2 = new TreeNode(9);
        l1.right = r2;
        return root;
    }

    public static TreeNode buildATwoNodeTree() {
        TreeNode root = new TreeNode(7);
        TreeNode l1 = new TreeNode(5);
        root.left = l1;
        return root;
    }
}
