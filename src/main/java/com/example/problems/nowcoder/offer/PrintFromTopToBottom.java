package com.example.problems.nowcoder.offer;

import com.example.problems.assistant.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */

public class PrintFromTopToBottom {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        root.left = node2;
        root.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;
        ArrayList<ArrayList<Integer>> print = new PrintFromTopToBottom().PrintOneLineForEachLevelWhile(root);
        System.out.println(print);
    }

    /**
     * 2.9
     * 不分行打印
     * 广度优先遍历
     *
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom29(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayList<TreeNode> level = new ArrayList<>();
        level.add(root);
        while (!level.isEmpty()) {
            TreeNode parent = level.remove(0);
            result.add(parent.val);
            if (parent.left != null) {
                level.add(parent.left);
            }
            if (parent.right != null) {
                level.add(parent.right);
            }
        }
        return result;
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null) {
            return arrayList;
        }
        ArrayList<TreeNode> treeNodeArrayList = new ArrayList<>();
        treeNodeArrayList.add(root);
        while (treeNodeArrayList.size() > 0) {
            TreeNode temp = treeNodeArrayList.remove(0);
            if (temp.left != null) {
                treeNodeArrayList.add(temp.left);
            }
            if (temp.right != null) {
                treeNodeArrayList.add(temp.right);
            }
            arrayList.add(temp.val);
        }
        return arrayList;
    }

    /**
     * 2.9
     * 分行打印 ArrayList
     * 广度优先遍历
     *
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer>> Print29(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        ArrayList<TreeNode> level = new ArrayList<>();
        level.add(pRoot);
        while (!level.isEmpty()) {
            ArrayList<Integer> levelInt = new ArrayList<>();
            result.add(levelInt);
            int levelSize = level.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode parent = level.remove(0);
                levelInt.add(parent.val);
                if (parent.left != null) {
                    level.add(parent.left);
                }
                if (parent.right != null) {
                    level.add(parent.right);
                }
            }
        }
        return result;
    }


    /**
     * 分行打印 LinkedList
     * 广度优先遍历
     *
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer>> PrintOneLineForEachLevelWhile(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            ArrayList<Integer> levelIntList = new ArrayList<>();
            result.add(levelIntList);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.removeFirst();
                levelIntList.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
        }
        return result;
    }


    /**
     * 分行打印 递归 前序遍历
     * <p>
     * 多传递一个当前结点所在层次就可以用前序遍历实现了，学习了
     *
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer>> PrintOneLineForEachLevelRecurse(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        depth(pRoot, 1, result);
        return result;
    }

    private void depth(TreeNode pRoot, int level, ArrayList<ArrayList<Integer>> list) {
        if (pRoot == null) return;
        if (level > list.size()) {
            list.add(new ArrayList<>());
        }
        list.get(level - 1).add(pRoot.val);
        depth(pRoot.left, level + 1, list);
        depth(pRoot.right, level + 1, list);
    }


    /**
     * 2.9
     * 之字形打印
     * 利用双端队列特性：奇数层从队列头遍历，偶数层从队列尾遍历
     *
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> PrintZhi29(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(pRoot);
        int level = 1;
        while (!list.isEmpty()) {
            ArrayList<Integer> levelInt = new ArrayList<>();
            result.add(levelInt);
            int levelSize = list.size();
            if (level % 2 == 1) {
                for (int i = 0; i < levelSize; i++) {
                    // 奇数层从队列头开始遍历
                    TreeNode parent = list.removeFirst();
                    levelInt.add(parent.val);
                    // 下一层（偶数层）按左-右顺序加入队列尾（不能加入队列头，否则会影响当前奇数层遍历），从而偶数层可以从队列尾从右-左顺序打印
                    if (parent.left != null) {
                        list.addLast(parent.left);
                    }
                    if (parent.right != null) {
                        list.addLast(parent.right);
                    }
                }
            } else {
                for (int i = 0; i < levelSize; i++) {
                    // 偶数层从队列尾开始遍历
                    TreeNode parent = list.removeLast();
                    levelInt.add(parent.val);
                    // 下一层（奇数层）按从右-左顺序加入队列头，从而奇数层可以从队列头开始从左-右顺序打印
                    if (parent.right != null) {
                        list.addFirst(parent.right);
                    }
                    if (parent.left != null) {
                        list.addFirst(parent.left);
                    }
                }
            }
            level++;

        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> PrintZhi1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        Stack<TreeNode> oddLevel = new Stack<>();
        Stack<TreeNode> evenLevel = new Stack<>();
        oddLevel.push(pRoot);
        int level = 2;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(pRoot.val);
        result.add(list);
        while (!oddLevel.isEmpty() || !evenLevel.isEmpty()) {
            if (level % 2 == 1) {
                ArrayList<Integer> levelList = new ArrayList<>();
                while (!evenLevel.isEmpty()) {
                    TreeNode pop = evenLevel.pop();
                    if (pop.left != null) {
                        oddLevel.push(pop.left);
                        levelList.add(pop.left.val);
                    }
                    if (pop.right != null) {
                        oddLevel.push(pop.right);
                        levelList.add(pop.right.val);
                    }
                }
                if (!levelList.isEmpty()) {
                    level++;
                    result.add(levelList);
                } else {
                    return result;
                }
            } else {
                ArrayList<Integer> levelList = new ArrayList<>();
                while (!oddLevel.isEmpty()) {
                    TreeNode pop = oddLevel.pop();
                    if (pop.right != null) {
                        evenLevel.push(pop.right);
                        levelList.add(pop.right.val);
                    }
                    if (pop.left != null) {
                        evenLevel.push(pop.left);
                        levelList.add(pop.left.val);
                    }
                }
                if (!levelList.isEmpty()) {
                    level++;
                    result.add(levelList);
                } else {
                    return result;
                }

            }
        }
        return result;
    }


    public ArrayList<ArrayList<Integer>> PrintZhiWithStack(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        Stack<TreeNode> oddLevel = new Stack<>();
        Stack<TreeNode> evenLevel = new Stack<>();
        oddLevel.push(pRoot);
        int level = 1;
        while (!oddLevel.isEmpty() || !evenLevel.isEmpty()) {
            if (level % 2 == 1) {
                ArrayList<Integer> levelList = new ArrayList<>();
                while (!oddLevel.isEmpty()) {
                    TreeNode pop = oddLevel.pop();
                    if (pop != null) {
                        levelList.add(pop.val);
                        // 打印的同时，入栈下一层的节点
                        evenLevel.push(pop.left);
                        evenLevel.push(pop.right);
                    }
                }
                if (!levelList.isEmpty()) {
                    level++;
                    result.add(levelList);
                }
            } else {
                ArrayList<Integer> levelList = new ArrayList<>();
                while (!evenLevel.isEmpty()) {
                    TreeNode pop = evenLevel.pop();
                    if (pop != null) {
                        levelList.add(pop.val);
                        oddLevel.push(pop.right);
                        oddLevel.push(pop.left);
                    }
                }
                if (!levelList.isEmpty()) {
                    level++;
                    result.add(levelList);
                }
            }
        }
        return result;
    }


}
