package leetcodeSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

Time: O(2^n)
Space: O(n)
 */
public class combinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if(i > start && candidates[i] == candidates[i - 1]) continue;
            if(target < candidates[i]) break;
            com.add(candidates[i]);
            helper(res, com, candidates, target - candidates[i], i+1);
            com.remove(com.size() - 1);
        }

    }

    public static void main(String[] args) {
        combinationSumII res = new combinationSumII();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(res.combinationSum2(candidates, 8));

    }
    }
