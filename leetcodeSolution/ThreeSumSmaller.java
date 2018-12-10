package leetcodeSolution;

import java.util.Arrays;

/*
Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

Example:

Input: nums = [-2,0,1,3], and target = 2
Output: 2
Explanation: Because there are two triplets which sums are less than 2:
             [-2,0,1]
             [-2,0,3]

 time: O(n^2)
 */
public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length - 1; i++){
            int lo = i + 1;
            int hi = nums.length - 1;
            while(lo < hi){
                int sum = nums[i] + nums[lo] + nums[hi];
                if(sum < target){
                    lo++;
                    count = count + hi - lo;
                }else{
                    hi--;
                }
            }
        }
        return count;
    }

    }
