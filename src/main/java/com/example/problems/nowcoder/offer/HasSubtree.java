package com.example.problems.nowcoder.offer;


import com.example.problems.assistant.TreeNode;
import com.example.problems.assistant.TreeUtil;

public class HasSubtree {

    public static void main(String[] args) {
        TreeNode root1 = TreeUtil.buildATree();
        TreeNode root2 = TreeUtil.buildATwoNodeTree();
        boolean hasSubtree = new HasSubtree().HasSubtree(root1, root2);
        System.out.println(hasSubtree);
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
//        // 如果tree1 或者 tree2 为 null，直接返回false
//        if (root1 == null || root2 == null) {
//            return false;
//        }
        boolean result = false;
        if (root1 != null && root2 != null) {
            // 找到根结点
            if (root1.val == root2.val) {
                // 以这个根节点为起点判断是否包含tree2
                result = HasSubtreeS(root1, root2);
            }
            // 如果找不到，那么就再去Tree1的左儿子当作起点，去判断是否包含Tree2
            if (!result) {
                result = HasSubtreeS(root1.left, root2);
            }
            // 如果还找不到，那么就再去Tree1的右儿子当作起点，去判断是否包含Tree2
            if (!result) {
                result = HasSubtreeS(root1.right, root2);
            }
        }
        return result;
    }


    private boolean HasSubtreeS(TreeNode root1, TreeNode root2) {

//        //如果Tree1已经遍历完了，返回false
//        if (root1 == null) {
//            return false;
//        }

        //如果Tree2已经遍历完了都能对应的上，返回true
        if (root2 == null) {
            return true;
        }
        //如果Tree2还没遍历完，但是Tree1已经遍历完了，返回false
        if (root1 == null) {
            return false;
        }
        //如果其中有一个点没有对应上，返回false
        if (root1.val != root2.val) {
            return false;
        }
        return HasSubtreeS(root1.left, root2.left) && HasSubtreeS(root1.right, root2.right);
    }


}
