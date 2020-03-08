package com.example.demo.nowcoder.offer;

/**
 * Created by lichunxia on 2020-01-31 16:11
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class GetNext {

    public static void main(String[] args) {
        TreeLinkNode node1 = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        TreeLinkNode node5 = new TreeLinkNode(5);
        TreeLinkNode node6 = new TreeLinkNode(6);
        TreeLinkNode node7 = new TreeLinkNode(7);
        TreeLinkNode node8 = new TreeLinkNode(8);
        TreeLinkNode node9 = new TreeLinkNode(9);

        node1.left = node2;
        node1.right = node3;
        node2.next = node3.next = node1;

        node2.left = node4;
        node2.right = node5;
        node4.next = node5.next = node2;

        node3.left = node6;
        node3.right = node7;
        node6.next = node7.next = node3;

        node5.left = node8;
        node5.right = node9;
        node8.next = node9.next = node5;

        GetNext getNext = new GetNext();
        TreeLinkNode treeLinkNode = getNext.getNext(node7);
        if (treeLinkNode != null) {
            System.out.println(treeLinkNode.val);
        } else {
            System.out.println(treeLinkNode);
        }
    }


    public TreeLinkNode getNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        // 情况一：有右子树，下一个就是右子树最左的那个节点
        if (pNode.right != null) {
            TreeLinkNode right = pNode.right;
            while (right.left != null) {
                right = right.left;
            }
            return right;
        }

        // 情况二：无右子树，且它是父节点的左孩子，下一个节点就是父节点
        // 情况二和三，可以合并
        // if (pNode.next != null && pNode.next.left == pNode) {
        //     return pNode.next;
        // }

        // 情况三：无右子树，且它是其父节点的右孩子，下一个节点为：找到一个节点，which is its parent's left child.
        // 这个节点的父节点就是下一个节点
        while (pNode.next != null && pNode.next.left != pNode) {
            pNode = pNode.next;
        }
        return pNode.next;
    }


    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        TreeLinkNode result = null;
        TreeLinkNode right = pNode.right;
        TreeLinkNode next = pNode.next;
        // 有右子树
        if (right != null) {
            while (right.left != null) {
                right = right.left;
            }
            result = right;
        } else if (next != null) {
            // 是左节点，下一个节点就是父节点
            if (next.left == pNode) {
                result = next;
            } else {
                // 是右节点，找到一个节点 他是他父节点的左节点，则这个节点的父节点就是下一个节点
                while (next.next != null) {
                    if (next.next.left != next) {
                        next = next.next;
                    } else break;
                }
                result = next.next;
            }
        }
        return result;
    }

    public TreeLinkNode GetNext1(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        TreeLinkNode result = null;
        TreeLinkNode right = pNode.right;
        TreeLinkNode next = pNode.next;
        // 有右子树
        if (right != null) {
            while (right.left != null) {
                right = right.left;
            }
            result = right;
        } else if (next != null) {
            TreeLinkNode current = pNode;
            TreeLinkNode parent = next;
            while (parent != null) {
                if (parent.left != current) {
                    current = parent;
                    parent = parent.next;
                } else break;
            }
            result = parent;
        }
        return result;
    }

    public TreeLinkNode GetNext2(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        // 有右子树
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        while (pNode.next != null) {
            TreeLinkNode parent = pNode.next;
            if (parent.left == pNode) {
                return parent;
            }
            pNode = pNode.next;
        }
        return null;
    }

}
