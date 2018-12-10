package leetcodeSolution;
/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]

time: O(n)
space: O(1)
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int lo = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[lo] = nums[i];
                lo++;
            }
        }

        for(int m = lo; m < nums.length; m++){
            nums[m] = 0;
        }
    }

    }
