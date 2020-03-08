package com.example.demo.nowcoder.offer;


import com.example.demo.assistant.TreeNode;

/**
 * Created by lichunxia on 2020-01-30 13:42
 */
public class TreeDepth {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);

        root.left = treeNode1;
        root.right = treeNode2;

        treeNode1.left = treeNode3;

        int depth = new TreeDepth().TreeDepth(root);
        System.out.println(depth);
    }

    /**
     * 2.10
     *
     * @param root
     * @return
     */
    public int TreeDepth210(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = TreeDepth210(root.left);
        int rightDepth = TreeDepth210(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }


    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        // if (left == null && right == null) {
        //     return 1;
        // }
        int leftDepth = TreeDepth(left);
        int rightDepth = TreeDepth(right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

}
