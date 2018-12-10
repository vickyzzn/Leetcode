package leetcodeSolution;

import java.util.ArrayList;
import java.util.List;

/*
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

time: O(n!*n)
space: O(n)
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        List<Integer> com = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        helper(res, com, nums, used);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> com, int[] nums, boolean[] used){
        if(com.size() == nums.length){
            res.add(new ArrayList<>(com));
            return;
        }
        for(int i = 0; i < nums.length; i++){
             if(used[i]) continue;
             used[i] = true;
             com.add(nums[i]);
             helper(res, com, nums, used);
             com.remove(com.size() - 1);
             used[i] = false;
        }
    }

    public static void main(String[] args) {
        Permutations res = new Permutations();
        int[] nums = {1, 2, 3};
        System.out.println(res.permute(nums));
    }
    }
