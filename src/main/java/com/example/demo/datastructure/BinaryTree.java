package com.example.demo.datastructure;

import com.example.demo.assistant.TreeNode;
import com.example.demo.assistant.TreeUtil;

import java.util.*;

/**
 * Created by lichunxia on 2019-09-13 20:55
 */
public class BinaryTree {

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.inOrderTraversal(TreeUtil.buildATree());
        System.out.println();
        bt.preOrderTraversal(TreeUtil.buildATree());
        System.out.println();
        bt.afterOrderTraversal(TreeUtil.buildATree());
        System.out.println();
        System.out.println(bt.postorderTraversal(TreeUtil.buildATree()));
        int h = bt.postGetHeight(TreeUtil.buildATree());
        System.out.println(h);
    }

    void preOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                System.out.print(root.val + " ");
                stack.push(root);
                root = root.left;
            }
            // if (!stack.isEmpty()) {
            root = stack.pop();
            root = root.right;
            // }
        }
    }

    void inOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // if (!stack.isEmpty()) {
            root = stack.pop();
            System.out.print(root.val + " ");
            root = root.right;
            // }
        }
    }


    void afterOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastVisited = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // if (!stack.isEmpty()) {
            root = stack.peek();
            // 如果不存在右子树，或右子树已被访问了，那么可以访问根节点，出栈，并不需要转向；
            // 如果还没有访问，就转向，使其“右”节点成为“左”节点，等着它先被访问之后，再来访问根节点
            // 所以，我们需要增加一个标志，记录右子树的访问情况。由于访问根节点前，一定先紧挨着访问了其右子树，所以我们只需要一个标志位
            if (root.right == null || lastVisited == root.right) {
                System.out.print(root.val + " ");
                stack.pop();
                lastVisited = root;
                root = null;
            } else {
                root = root.right;
            }
            // }
        }
    }

    /**
     * 左->右->根 是 根->右->左 的倒序
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                list.add(0, node.val);
                node = node.right;
            }
            node = stack.pop();
            node = node.left;
        }
        return list;
    }

    /**
     * 树的高度，后续遍历的变形
     *
     * @param root
     * @return
     */
    int postGetHeight(TreeNode root) {
        int hl, hr, h;
        if (root != null) {
            hl = postGetHeight(root.left);
            hr = postGetHeight(root.right);
            h = Math.max(hl, hr) + 1;
            return h;
        } else {
            return 0;
        }
    }
}
