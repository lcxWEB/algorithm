package com.example.problems.dfs;

import com.example.problems.assistant.TreeNode;
import com.example.problems.assistant.TreeUtil;

/**
 * Created by lichunxia on 2019-08-30 11:01
 *
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
public class PathSumIII {

    public static void main(String[] args) {
        TreeNode treeNode = TreeUtil.buildATree();
        PathSumIII sumIII = new PathSumIII();
        int pathSum = sumIII.pathSum(treeNode, 3);
        System.out.println(pathSum);
    }

    public int pathSumW(TreeNode root, int sum) {
        if (root == null){
            return 0;
        }
        if ( root.val == sum) {
            return 1;
        }
        return pathSum(root.left, sum - root.val) + pathSum(root.right, sum - root.val);
    }

    /**
     * Runtime: 11 ms, faster than 49.41% of Java online submissions for Path Sum III.
     * Memory Usage: 40.7 MB, less than 65.91% of Java online submissions for Path Sum III.
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null){
            return 0;
        }
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumFrom(TreeNode root, int sum) {
        if (root == null){
            return 0;
        }
        return (root.val == sum ? 1 : 0) + pathSumFrom(root.left, sum - root.val) + pathSumFrom(root.right, sum - root.val);
    }


}
