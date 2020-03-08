package com.example.demo.nowcoder.offer;

import com.example.demo.assistant.TreeNode;

/**
 * Created by lichunxia on 2020-01-30 14:00
 */
public class IsBalancedTree {

    private boolean isBalanced = false;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);

        root.left = treeNode1;
        root.right = treeNode2;

        treeNode1.left = treeNode3;
        treeNode3.left = treeNode4;

        boolean isBalanced = new IsBalancedTree().IsBalanced(root);
        System.out.println(isBalanced);
    }

    /**
     * 高效解法
     *
     * @param root
     * @return
     */
    public boolean IsBalanced(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        if (leftDepth == -1) {
            return -1;
        }
        int rightDepth = getDepth(root.right);
        if (rightDepth == -1) {
            return -1;
        }
        int diff = leftDepth - rightDepth;
        if (diff > 1 || diff < -1) {
            return -1;
        }
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }

    /**
     * 低效解法
     *
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = TreeDepth(left);
        int rightDepth = TreeDepth(right);
        int diff = Math.abs(leftDepth - rightDepth);
        if (diff > 1) {
            return false;
        }
        return IsBalanced_Solution(left) && IsBalanced_Solution(right);
    }

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = TreeDepth(left);
        int rightDepth = TreeDepth(right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * 错误解法
     *
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution2(TreeNode root) {
        if (root == null) {
            return true;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = TreeDepth(left);
        int rightDepth = TreeDepth(right);
        int diff = Math.abs(leftDepth - rightDepth);
        // 不能直接返回，只判断了根结点是否是平衡的
        return diff < 2;
    }

    public boolean IsBalanced_Solution3(TreeNode root) {
        int depth = 0;
        boolean isLeftBalanced = isBalanced(root, depth);
        return isLeftBalanced;
    }

    private boolean isBalanced(TreeNode root, int depth) {
        if (root == null) {
            depth = 0;
            return true;
        }
        int left = 0, right = 0;
        boolean leftBalanced = isBalanced(root.left, left);
        boolean rightBalanced = isBalanced(root.right, right);
        if (leftBalanced && rightBalanced) {
            int diff = left - right;
            if (diff <= 1 || diff >= -1) {
                depth = (left > right ? left : right) + 1;
                return true;
            }
        }
        return false;
    }


    /**
     * 错误解法，leetcode上通不过
     *
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution4(TreeNode root) {
        getDepth1(root);
        return isBalanced;
    }

    private int getDepth1(TreeNode root) {
        if (root == null) {
            isBalanced = true;
            return 0;
        }
        int leftDepth = getDepth1(root.left);
        int rightDepth = getDepth1(root.right);
        int diff = leftDepth - rightDepth;

        if (diff > 1 || diff < -1) {
            isBalanced = false;
        }
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;

        // if (isBalanced && diff <= 1 && diff >= -1) {
        //
        // }

    }


}
