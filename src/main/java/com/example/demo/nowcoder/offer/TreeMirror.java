package com.example.demo.nowcoder.offer;

import com.example.demo.assistant.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeMirror {

    public void Mirror(TreeNode root) {

        if (root == null) {
            return;
        }
        TreeNode mirrorTree = root.left;
        root.left = root.right;
        root.right = mirrorTree;

        Mirror(root.left);
        Mirror(root.right);

    }

    public void MirrorCircle(TreeNode root) {

        if (root == null) {
            return;
        }
        TreeNode oldRoot = root;
        while (root.left != null) {
            TreeNode mirrorTree = root.left;
            root.left = root.right;
            root.right = mirrorTree;
            root = root.left;
        }

        while (root.right != null) {
            TreeNode mirrorTree = root.left;
            root.left = root.right;
            root.right = mirrorTree;
            root = root.right;
        }
    }

    public void MirrorTree(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode pointer = root;
        Queue<TreeNode> queue = new LinkedList<>();
        while (pointer != null) {
            TreeNode mirrorTree = pointer.left;
            pointer.left = pointer.right;
            pointer.right = mirrorTree;

            if (pointer.left != null) {
                queue.add(pointer.left);
            }
            if (pointer.right != null) {
                queue.add(pointer.right);
            }
            if (queue.peek() != null) {
                pointer = queue.poll();
            } else {
                break;
            }
        }
    }
}
