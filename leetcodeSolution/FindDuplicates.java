package leetcodeSolution;
/*
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:

Input: [1,3,4,2,2]
Output: 2
Example 2:

Input: [3,1,3,4,2]
Output: 3

time: O(nlogn)
space: O(1)
 */
public class FindDuplicates {
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int lo = 0;
        int hi = nums.length - 1;
        while(lo < hi){
            int mid = lo + (hi - lo)/2;
            int count = 0;
            for(int num : nums){
                if(num <= mid){
                    count++;
                }
            }
            if(count <= mid){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        return lo;
    }

    }
