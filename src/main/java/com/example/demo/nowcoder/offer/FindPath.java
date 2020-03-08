package com.example.demo.nowcoder.offer;


import com.example.demo.assistant.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class FindPath {

    private ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
    private ArrayList<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(1);
        treeNode.left = left;
        treeNode.right = right;
        right.left = new TreeNode(2);

        FindPath findPath = new FindPath();
        ArrayList<ArrayList<Integer>> paths = findPath.FindPath(treeNode, 5);
        System.out.println(paths);
        paths = findPath.FindPath210(treeNode, 5);
        System.out.println(paths);
    }

    /**
     * 2.10
     *
     * @param root
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindPath210(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null || target < root.val) {
            return result;
        }
        LinkedList<Integer> path = new LinkedList<>();
        int currentNum = 0;
        FindPath210(root, target, currentNum, path, result);
        return result;
    }

    private void FindPath210(TreeNode root, int target, int currentNum, LinkedList<Integer> path, ArrayList<ArrayList<Integer>> paths) {
        currentNum = currentNum + root.val;
        path.addLast(root.val);
        boolean isLeaf = root.left == null && root.right == null;
        if (currentNum == target && isLeaf) {
            // 不重新new的话从始至终paths中所有引用都指向了同一个path
            paths.add(new ArrayList<>(path));
        }
        if (root.left != null) {
            FindPath210(root.left, target, currentNum, path, paths);
        }
        if (root.right != null) {
            FindPath210(root.right, target, currentNum, path, paths);
        }
        // 递归调用自动回到它的父节点之前，将当前节点从路径中删除
        // 移除最后一个元素，深度遍历完一条路径后要回退
        path.removeLast();
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null || target < root.val) {
            return paths;
        }
        path.add(root.val);
        target = target - root.val;
        if (target == 0 && root.left == null && root.right == null) {
            paths.add(new ArrayList<>(path));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        path.remove(path.size() - 1);
        return paths;
    }
}
