package com.example.demo.nowcoder.offer;

import com.example.demo.assistant.TreeNode;

/**
 * Created by lichunxia on 2020-01-31 17:58
 */
public class IsSymmetrical {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(4);

        root.left = node2;
        root.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node7;
        node3.right = node6;

        boolean symmetrical = new IsSymmetrical().isSymmetrical(root);
        System.out.println(symmetrical);

    }

    boolean isSymmetrical(TreeNode pRoot) {
        boolean result = isSymmetrical(pRoot, pRoot);
        return result;

    }

    private boolean isSymmetrical(TreeNode pRoot1, TreeNode pRoot2) {
        if (pRoot1 == null && pRoot2 == null) {
            return true;
        }

        if (pRoot1 == null || pRoot2 == null) {
            return false;
        }

        if (pRoot1.val != pRoot2.val) {
            return false;
        }

        return isSymmetrical(pRoot1.left, pRoot2.right) && isSymmetrical(pRoot1.right, pRoot2.left);
    }

}
