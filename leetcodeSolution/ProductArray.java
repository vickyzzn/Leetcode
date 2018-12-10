package leetcodeSolution;
/*
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
//       [1, 1, 2, 6]
Note: Please solve it without division and in O(n).

time: O(n)
space: O(1)
 */
public class ProductArray {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        output[0] = 1;
        for(int i = 1; i < nums.length; i++){
            output[i] = output[i - 1] * nums[i - 1];
        }
        int right = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            output[i] = output[i]*right;
            right = right*nums[i];
        }
        return output;
    }

    }
