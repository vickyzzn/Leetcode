package leetcodeSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

time: O(n!*n)
space: O(n)
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        List<Integer> com = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        helper(res, com, used, nums);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> com, boolean[] used, int[] nums){
        if(com.size() == nums.length){
            res.add(new ArrayList<>(com));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i])  continue;
            if(i > 0 && nums[i] == nums[i - 1] && used[i - 1])  continue;
            used[i] = true;
            com.add(nums[i]);
            helper(res, com, used, nums);
            com.remove(com.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        PermutationsII res = new PermutationsII();
        int[] nums = {1, 1, 2};
        System.out.println(res.permuteUnique(nums));
    }

}
