package com.example.problems.tree;

import com.example.problems.assistant.TreeNode;
import com.example.problems.assistant.TreeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lichunxia on 2019-09-14 09:52
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> lists = binaryTreeLevelOrderTraversal.levelOrderDFS(TreeUtil.buildATree());
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }


    /**
     * Runtime: 1 ms, faster than 92.48% of Java online submissions for Binary Tree Level Order Traversal.
     * Memory Usage: 36.4 MB, less than 100.00% of Java online submissions for Binary Tree Level Order Traversal.
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList();
        if (root != null) {
            linkedList.add(root);
        }
        while (!linkedList.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            // 层的结点数
            int cnt = linkedList.size();
            for (int i = 0; i < cnt; i++) {
                TreeNode treeNode = linkedList.poll();
                levelList.add(treeNode.val);

                if (treeNode.left != null) {
                    linkedList.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    linkedList.add(treeNode.right);
                }
            }
            result.add(levelList);
        }
        return result;
    }


    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(res, root, 0);
        return res;
    }

    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val);
        levelHelper(res, root.left, height+1);
        levelHelper(res, root.right, height+1);
    }
}
