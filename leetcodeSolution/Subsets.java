package leetcodeSolution;

import java.util.ArrayList;
import java.util.List;

/*

Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
time: O(2^n)
space: O(n)
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0)  return res;
        List<Integer> com = new ArrayList<>();
        helper(res, com, nums, 0);

        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> com, int[] nums, int start){
        res.add(new ArrayList<>(com));
        for(int i = start; i < nums.length; i++){
            com.add(nums[i]);
            helper(res, com, nums, i + 1);
            com.remove(com.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets res = new Subsets();
        int[] nums = {1,2,3};
        System.out.println(res.subsets(nums));
    }
    }
