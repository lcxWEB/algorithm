package com.example.problems.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lichunxia on 2019-09-06 15:02
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 */
public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> lists = combinationSum.combinationSum(candidates, 8);
        System.out.println(lists);
    }


    /**
     *
     * Runtime: 5 ms, faster than 50.22% of Java online submissions for Combination Sum.
     * Memory Usage: 37.5 MB, less than 100.00% of Java online submissions for Combination Sum.
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
