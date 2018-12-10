package leetcodeSolution;

import java.util.Arrays;

/*
Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
Input: nums = [3,5,2,1,6,4]
               [3,5,1,2,6,4]
               0  1 2 3 4  5
Output: One possible answer is [3,5,1,6,2,4]

time: O(n)
space: O(1)
 */
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length == 0) return;
        for(int i = 1; i < nums.length; i++){
            if(i % 2 == 1 && nums[i] < nums[i - 1]){
                swap(nums, i, i - 1);
            }
            if(i % 2 == 0 && nums[i] > nums[i - 1]){
                swap(nums, i, i - 1);
            }
        }
    }
    public void swap(int[] nums, int r, int l){
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    public static void main(String[] args) {
        WiggleSort res = new WiggleSort();
        int[] nums = {3,5,2,1,6,4};
        res.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    }
