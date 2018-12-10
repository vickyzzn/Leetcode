package leetcodeSolution;

import java.util.HashSet;

/*
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4

time: O(n)
space:
 HashSet: O(n)
 Bit Manipulation: O(1)
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                set.remove(num);
            }else{
                set.add(num);
            }
        }
        return set.iterator().next();
    }
    public int singleNumber2(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            res = res^nums[i];
        }
        return res;
    }

    }
