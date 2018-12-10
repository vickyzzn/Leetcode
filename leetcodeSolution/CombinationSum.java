package leetcodeSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]

time: O(2^n)
space: O(n)
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return res;
        List<Integer> com = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res, com, candidates, target, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> com, int[] candidates, int target, int start){
        if(target == 0){
            res.add(new ArrayList<>(com));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if(target < candidates[i]) break;
            com.add(candidates[i]);
            helper(res, com, candidates, target - candidates[i], i);
            com.remove(com.size() - 1);
        }
    }

    }
