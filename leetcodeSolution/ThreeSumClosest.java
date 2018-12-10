/*
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

time: O(n^2)
 */

package leetcodeSolution;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target){
        int min = nums[0] + nums[nums.length - 1]+ nums[1];
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > target) k--;
                if(sum < target) j++;
                sum += nums[j] + nums[k];
                if(Math.abs(sum - target) < Math.abs(min - target)){
                    min = sum;
                }
            }
        }
        return min;
    }
}
