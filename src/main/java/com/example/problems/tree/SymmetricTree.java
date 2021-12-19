package com.example.problems.tree;

import com.example.problems.assistant.TreeNode;
import com.example.problems.assistant.TreeUtil;

/**
 * Created by lichunxia on 2019-08-27 22:15
 * <p>
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 */
public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildATree();
        SymmetricTree symmetricTree = new SymmetricTree();
        boolean symmetric = symmetricTree.isSymmetric(root);
        System.out.println(symmetric);
    }

    /**
     * 第一种解法
     * Runtime: 1 ms, faster than 40.96% of Java online submissions for Symmetric Tree.
     * Memory Usage: 37.5 MB, less than 74.15% of Java online submissions for Symmetric Tree.
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode l = root.left;
        TreeNode r = root.right;
        return isEqual(l, r);
        // boolean flag = false;
        // while (l != null || r != null) {
        //     flag = isEqual(l, r);
        //     TreeNode l1 = l.left;
        //     TreeNode r1 = r.right;
        //     flag = isEqual(l1, r1);
        //     TreeNode l2 = l.right;
        //     TreeNode r2 = r.left;
        //     flag = isEqual(l2, r2);
        //     l = l.left;
        //     r = l.right;
        // }
        // return flag;
    }

    public boolean isEqual(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }
        // if (l != null && r != null) {
        //     return l.val == r.val;
        // }
        if (l == null || r == null) {
            return false;
        }
        if (l.val != r.val) {
            return false;
        }
        return isEqual(l.left, r.right) && isEqual(l.right, r.left);
    }
}
