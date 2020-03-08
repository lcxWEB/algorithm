package com.example.demo.nowcoder.offer;


import com.example.demo.assistant.TreeNode;

public class ReconstructBinaryTree {

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = new int[]{4, 7, 2, 1, 5, 3, 8, 6};

        ReconstructBinaryTree binaryTree = new ReconstructBinaryTree();
        TreeNode treeNode = binaryTree.reConstructBinaryTree(pre, in);
        binaryTree.preOrder(treeNode);
    }

    /**
     * 2020-02-06
     *
     * @param pre
     * @param startPre
     * @param endPre
     * @param in
     * @param startIn
     * @param endIn
     * @return
     */
    private TreeNode reConstructTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        int rootValue = pre[startPre];
        TreeNode root = new TreeNode(rootValue);

        // if (startPre == endPre && startIn == endIn) {
        //     return root;
        // }

        // 从中序遍历里找出根节点位置，则该位置左侧为左子树，右侧为右子树
        int indexOfRootInIn = startIn;
        for (; indexOfRootInIn < in.length; indexOfRootInIn++) {
            if (in[indexOfRootInIn] == rootValue) {
                break;
            }
        }

        root.left = reConstructTree(pre, startPre + 1, startPre + indexOfRootInIn - startIn, in, startIn, indexOfRootInIn - 1);
        root.right = reConstructTree(pre, startPre + indexOfRootInIn - startIn + 1, endPre, in, indexOfRootInIn + 1, endIn);
        return root;
    }


    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        // 传入前序遍历和中序遍历，返回二叉树
        // TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        TreeNode root = reConstructTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {

        System.out.println("startPre : " + startPre + " endPre : " + endPre + " startIn : " + startIn + " endIn : " + endIn);
        // 检查是否遍历完
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        // 存入子树的根结点
        TreeNode root = new TreeNode(pre[startPre]);

        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == pre[startPre]) {
                System.out.println("i : " + i);
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
//                break;
            }
        }

        return root;
    }

    public void preOrder(TreeNode node) {
        // if (node == null) {
        //     return;
        // }
        if (node != null) {
            System.out.println(node.val);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

}
