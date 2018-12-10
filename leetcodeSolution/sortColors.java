package leetcodeSolution;

import java.util.ArrayList;
import java.util.Arrays;

/*
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Time:
1 - counting sort O(m+n)
2 - three-pointer partition O(n)

Space:
1 - counting sort O(m+n)
2 - three-pointer partition O(1)

 */
public class sortColors {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        for(int i = 0; i < count[0]; i++)  nums[i] = 0;
        for(int i = 0; i < count[1]; i++)  nums[count[0] + i] = 1;
        for(int i = 0; i < count[2]; i++)  nums[count[0] + count[1] + i] = 2;
    }

    public void sortColors2(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int i = 0;
        int j = 0;
        int k = nums.length - 1;
        while(j <= k){
            if(nums[j] == 0){
                swap(nums, i++, j++);
            }else if(nums[j] == 1){
                j++;
            }else{
                swap(nums, j, k--);
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        sortColors res = new sortColors();
        int[] nums = {2,0,2,1,1,0};
        res.sortColors2(nums);
        System.out.println(Arrays.toString(nums));
    }
}
