package com.example.problems.tree;

import com.example.problems.assistant.TreeNode;
import com.example.problems.assistant.TreeUtil;

/**
 * Created by lichunxia on 2019-09-02 13:44
 *
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
 *
 * Example:
 *
 * Input: The root of a Binary Search Tree like this:
 *               5
 *             /   \
 *            2     13
 *
 * Output: The root of a Greater Tree like this:
 *              18
 *             /   \
 *           20     13
 *
 */
public class ConvertBSTtoGreaterTree {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildATree();
        ConvertBSTtoGreaterTree c = new ConvertBSTtoGreaterTree();
        c.convertBST(root);
        System.out.println();
    }

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }

    /**
     * 不是自己想的
     * Runtime: 1 ms, faster than 94.17% of Java online submissions for Convert BST to Greater Tree.
     * Memory Usage: 39.2 MB, less than 81.25% of Java online submissions for Convert BST to Greater Tree.
     *
     * @param cur
     */
    public void convert(TreeNode cur) {
        if (cur == null) return;
        convert(cur.right);
        cur.val += sum;
        sum = cur.val;
        convert(cur.left);
    }

}
